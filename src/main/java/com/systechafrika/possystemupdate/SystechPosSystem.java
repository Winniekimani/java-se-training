package com.systechafrika.possystemupdate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import com.systechafrika.possystemupdate.jdbc.DatabaseAccess;
import com.systechafrika.possystemupdate.userdefinedexceptions.EmptyCartException;
import com.systechafrika.possystemupdate.userdefinedexceptions.InsufficientPaymentException;
import com.systechafrika.possystemupdate.userdefinedexceptions.InvalidOptionException;
import com.systechafrika.possystemupdate.userdefinedexceptions.MaxLoginAttemptsExceededException;
import com.systechafrika.possystemupdate.userdefinedexceptions.ReceiptPrintingException;

public class SystechPosSystem {

    final String DEFAULT_PASSWORD = "Admin123";
    final int MAX_LOGIN_ATTEMPTS = 3;

    private Scanner scanner;
    private ArrayList<Item> cart;// a List to store items in the cart
    private DatabaseAccess databaseAccess;

    private static final Logger LOGGER = Logger.getLogger(SystechPosSystem.class.getName());

    // Constructor
    public SystechPosSystem() {

        try {
            setupLogger();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner = new Scanner(System.in);
        cart = new ArrayList<>();// creating an empty cart
        databaseAccess = new DatabaseAccess();
    }

    public static void main(String[] args) {

        SystechPosSystem a = new SystechPosSystem();
        a.login();
        a.closeDatabaseConnection();

    }

    public void closeDatabaseConnection() {
        databaseAccess.closeConnection();
    }

    // handles user login
    public void login() {
        int loginAttempts = 0;

        while (loginAttempts < MAX_LOGIN_ATTEMPTS) {
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();
            System.out.print("Enter password to log in: ");
            String enteredPassword = scanner.nextLine();

            // Check if the user exists
            if (databaseAccess.userExists(enteredUsername)) {
                String storedPassword = databaseAccess.getPassword(enteredUsername);
                if (enteredPassword.equals(storedPassword) || enteredPassword.equals(DEFAULT_PASSWORD)) {
                    LOGGER.info("Successful login!");
                    break;
                } else {
                    loginAttempts++;
                    LOGGER.info("Incorrect password. Attempts left: " + (MAX_LOGIN_ATTEMPTS - loginAttempts));
                }
            } else {
                LOGGER.info("User not found.");
                LOGGER.info("Register as a new user (yes/no): ");
                String registerChoice = scanner.nextLine().toLowerCase();
                if (registerChoice.equals("yes")) {
                    if (databaseAccess.registerUser(enteredUsername, DEFAULT_PASSWORD)) {
                        LOGGER.info("User registered and logged in!");
                        break;
                    } else {
                        LOGGER.info("User registration failed.");
                        loginAttempts++;
                        LOGGER.info("Login attempts left: " + (MAX_LOGIN_ATTEMPTS - loginAttempts));
                    }
                } else {
                    loginAttempts++;
                    LOGGER.info("Login attempts left: " + (MAX_LOGIN_ATTEMPTS - loginAttempts));
                }
            }

            if (loginAttempts == MAX_LOGIN_ATTEMPTS) {
                try {
                    throw new MaxLoginAttemptsExceededException("Maximum login attempts exceeded. Exiting.");
                } catch (MaxLoginAttemptsExceededException e) {
                    LOGGER.info(e.getMessage());
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }

        // here i'll use a boolean variable to control the main menu loop
        // The loop will continue as long as continueShopping is true,
        // and it will exit when the user chooses to exit by selecting option 4.
        boolean continueShopping = true;
        while (continueShopping) {
            displayMenu();
            // System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            try {
                if (option < 1 || option > 7) {
                    throw new InvalidOptionException("Invalid option. Please choose a valid option.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Consume newline
                try {
                    throw new InvalidOptionException("Invalid option format. Please choose a valid option.");
                } catch (InvalidOptionException e1) {
                    e1.printStackTrace();
                }
            } catch (InvalidOptionException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                continue;
            }

            switch (option) {
                case 1:
                    // Add items
                    addItem();
                    break;

                case 2:
                    // remove items
                    deleteItem();
                    break;
                case 3:
                    // Make payment
                    try {
                        makePayment();
                    } catch (EmptyCartException | InsufficientPaymentException e) {
                        LOGGER.info(e.getMessage());
                    }
                    break;
                case 4:
                    // Display receipt
                    try {
                        displayReceipt();
                    } catch (ReceiptPrintingException e) {
                        LOGGER.info(e.getMessage());
                    }
                    break;
                case 5:
                    displayUserMenu();
                    break;
                case 6:
                    displayItemMenu();
                    break;
                case 7:
                    // Exit the program
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    LOGGER.info("Invalid option. Please choose a valid option.");
                    continueShopping = false; // here we Set the boolean to false to exit the loop
                    break;
            }
        }

        scanner.close();

    }

    public static void displayMenu() {
        System.out.println("*********************");
        System.out.println("SYSTECH POS SYSTEM");
        System.out.println("*********************");
        System.out.println("_______________________\n");
        System.out.println("1:ADD ITEM");
        System.out.println("2:DELETE ITEM");
        System.out.println("3:MAKE PAYMENT");
        System.out.println("4:DISPLAY RECEIPT");
        System.out.println("5:RETRIEVE USERS");
        System.out.println("6:RETRIEVE ITEMS");
        System.out.println("7:EXIT");
        System.out.println("*********************");

        System.out.print("Choose your option: ");

    }

    // I've added two new methods, displayUserMenu and displayItemMenu,
    // to display submenus for retrieving user and item data, respectively.
    public void displayUserMenu() {
        System.out.println("User Data Retrieval Menu");
        System.out.println("1: Retrieve Users");
        System.out.println("2: Back to Main Menu");
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                retrieveUsers();
                break;
            case 2:
                break; // Do nothing and return to the main menu
            default:
                LOGGER.info("Invalid option. Please choose a valid option.");
        }
    }

    public void displayItemMenu() {
        System.out.println("Item Data Retrieval Menu");
        System.out.println("1: Retrieve Items");
        System.out.println("2: Back to Main Menu");
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                retrieveItems();
                break;
            case 2:
                break; // Do nothing and return to the main menu
            default:
                LOGGER.info("Invalid option. Please choose a valid option.");
        }
    }

    // i've added new methods (retrieveUsers and retrieveItems) for retrieving user
    // and item data from the database.

    public void retrieveUsers() {
        List<User> userList = databaseAccess.retrieveUsers();// retrieves the user data from the database and returns it
                                                             // as a list of User objects.
        if (userList.isEmpty()) {// If the list is empty, it prints "No users found in the database." Otherwise,
                                 // it iterates through the list and prints the user data.
            LOGGER.info("No users found in the database.");//
        } else {
            System.out.println("User Data:");
            for (User user : userList) {
                LOGGER.info("ID: " + user.getId() + ", Username: " + user.getUsername() + ", Password: "
                        + user.getPassword());
            }
        }
    }

    public void retrieveItems() {
        List<Item> itemList = databaseAccess.retrieveItemData();
        if (itemList.isEmpty()) {
            LOGGER.info("No items found in the database.");
        } else {
            System.out.println("Item Data:");
            for (Item item : itemList) {
                LOGGER.info("Item Code: " + item.getItemCode() + ", Quantity: " + item.getQuantity()
                        + ", Unit Price: " + item.getUnitPrice());
            }
        }
    }

    // allows the user to add items to the shopping
    // cart by entering item codes, quantities, and unit prices.
    public void addItem() {

        System.out.print("Enter Item Code: ");
        String itemCodeEntered = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter Unit Price: ");
        double unitPrice = scanner.nextDouble();
        scanner.nextLine();

        // Create an Item object with the entered data
        Item item = new Item(itemCodeEntered, quantity, unitPrice);
        cart.add(item);

        databaseAccess.insertItem(item);
        System.out.println("Item added to cart.");

        // Log item addition
        String message = "Item added: Item Code - " + item.getItemCode() +
                ", Quantity - " + item.getQuantity() +
                ", Unit Price - " + item.getUnitPrice();
        LOGGER.info(message);
    }

    // Delete an item from the cart by specifying the item code by using remove
    // method from list
    public void deleteItem() {

        LOGGER.info("deleteItem method called.");
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Add items before attempting to delete.");
            return;
        }
        System.out.print("Enter Item Code to delete: ");
        String itemCodeToDelete = scanner.nextLine();

        // Search for the item in the cart using its item code
        for (Item item : cart) {
            if (item.getItemCode().equalsIgnoreCase(itemCodeToDelete)) {
                cart.remove(item); // Remove the item from the cart using List
                databaseAccess.deleteItem(itemCodeToDelete); // Remove the item from the database
                System.out.println("Item removed from cart and database.");
                String message = "Item deleted: Item Code - " + itemCodeToDelete;
                LOGGER.info(message); // Corrected LOGGER here
                return; // Exit the loop once the item is found and removed
            }
        }

        System.out.println("Item with code " + itemCodeToDelete + " not found in cart.");
        // Log item deletion
        String message = "Item not found  : Item Code - " + itemCodeToDelete;
        LOGGER.info(message);

    }

    // this method here calculates the total payment based on the items in the cart
    // and
    // handles the payment process, including providing change.
    public void makePayment() throws EmptyCartException, InsufficientPaymentException {
        try {
            if (cart.isEmpty()) {
                throw new EmptyCartException("No items in the cart. Add items before making a payment.");
            }

            System.out.println("Item Code   Quantity   Unit Price   Total Value");
            System.out.println("--------------------------------------------");
            double totalAmount = 0.0;

            for (Item item : cart) {
                System.out.println(item.getItemCode() + "   " + item.getQuantity() + "   " +
                        item.getUnitPrice() + "   " + item.getTotalValue());
                totalAmount += item.getTotalValue();
            }

            System.out.println("--------------------------------------------");
            System.out.println("Total: " + totalAmount);

            double amountGiven = getAmountFromUser();
            double changeAmount = handlePayment(totalAmount, amountGiven);

            Payment payment = new Payment(totalAmount, amountGiven, changeAmount);
            // Insert payment details into the database
            databaseAccess.insertPayment(payment);

            // Log user payment
            String message = "User payment made: Total Amount - " + totalAmount +
                    ", Amount Given - " + amountGiven +
                    ", Change Amount - " + changeAmount;
            LOGGER.info(message);

            // Return to displaying the main menu
            // displayMenu();
        } catch (EmptyCartException | InsufficientPaymentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace(); // prints full exception details
        }
    }

    private double getAmountFromUser() {
        System.out.print("Enter the amount given by the customer: ");
        double amountGiven = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        return amountGiven;
    }

    private double handlePayment(double totalAmount, double amountGiven) throws InsufficientPaymentException {
        if (amountGiven < totalAmount) {
            throw new InsufficientPaymentException("Less amount given. Please try a higher amount.");
        } else {
            // Calculate and display the change
            double changeAmount = amountGiven - totalAmount;
            System.out.println("Change: " + changeAmount);
            System.out.println("THANK YOU FOR SHOPPING WITH US");
            return changeAmount; // Return the change value
        }
    }

    // displays a receipt that shows the items in the cart,
    // their quantities, unit prices, and total values.
    public void displayReceipt() throws ReceiptPrintingException {

        LOGGER.info("displayReceipt method called.");
        if (cart.isEmpty()) {
            throw new ReceiptPrintingException("No items in the cart. Add items before displaying the receipt");
        } else {
            System.out.println("***************");
            System.out.println("RECEIPT");
            System.out.println("__________________");
            System.out.println("Item Code   Quantity   Unit Price   Total Value");
            System.out.println("--------------------------------------------");
            double totalAmount = 0.0;

            for (Item item : cart) {
                System.out.println(item.getItemCode() + "   " + item.getQuantity() + "   " +
                        item.getUnitPrice() + "   " + item.getTotalValue());
                totalAmount += item.getTotalValue();
            }

            System.out.println("--------------------------------------------");
            System.out.println("Total: " + totalAmount);
            System.out.println("__________________");

            // Log receipt display
            LOGGER.info("Receipt displayed.");

        }
    }

    private void setupLogger() throws IOException {
        FileHandler fileHandler = new FileHandler("log.txt", true);
        LOGGER.addHandler(fileHandler);
    }

}
