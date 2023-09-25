package com.systechafrika.pos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.systechafrika.pos.customexceptions.EmptyCartException;
import com.systechafrika.pos.customexceptions.InsufficientPaymentException;
import com.systechafrika.pos.customexceptions.InvalidOptionException;
import com.systechafrika.pos.customexceptions.MaxLoginAttemptsExceededException;
import com.systechafrika.pos.customexceptions.ReceiptPrintingException;

public class SystechPosSystem {

    final String DEFAULT_PASSWORD = "Admin123";
    final int MAX_LOGIN_ATTEMPTS = 3;

    private Scanner scanner;
    private ArrayList<Item> cart;

    // Constructor
    public SystechPosSystem() {
        scanner = new Scanner(System.in);
        cart = new ArrayList<>();// creating an empty cart
    }

    public static void main(String[] args) {

        SystechPosSystem a = new SystechPosSystem();
        a.login();

    }

    // handles user login
    public void login() {
        int loginAttempts = 0;

        while (loginAttempts < MAX_LOGIN_ATTEMPTS) {
            System.out.print("Enter password to log in: ");
            String enteredPassword = scanner.nextLine();

            if (enteredPassword.equals(DEFAULT_PASSWORD)) {
                System.out.println("Successful login!");
                break;
            } else {
                loginAttempts++;
                System.out.println("Incorrect password. Attempts left: " + (MAX_LOGIN_ATTEMPTS - loginAttempts));
            }

            if (loginAttempts == MAX_LOGIN_ATTEMPTS) {
                try {
                    throw new MaxLoginAttemptsExceededException("Maximum login attempts exceeded. Exiting.");
                } catch (MaxLoginAttemptsExceededException e) {
                    System.out.println(e.getMessage());
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
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            try {
                if (option < 1 || option > 4) {
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
                    // Make payment
                    try {
                        makePayment();
                    } catch (EmptyCartException | InsufficientPaymentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    // Display receipt
                    try {
                        displayReceipt();
                    } catch (ReceiptPrintingException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
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
        System.out.println("2:MAKE PAYMENT");
        System.out.println("3: DISPLAY RECEIPT");
        System.out.println("4: EXIT");
        System.out.println("*********************");

        System.out.print("Choose your option: ");

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

        // this code takes user input for an item's code, quantity, and
        // unit price, creates an Item object with this information,and
        // adds it to the shopping cart
        Item items = new Item(itemCodeEntered, quantity, unitPrice);
        cart.add(items);
        System.out.println("Item added to cart.");
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

            handlePayment(totalAmount, amountGiven);

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

    // Helper method to handle payment logic
    private void handlePayment(double totalAmount, double amountGiven) throws InsufficientPaymentException {
        if (amountGiven < totalAmount) {
            throw new InsufficientPaymentException("Less amount given. Please try a higher amount.");
        } else {
            // Calculate and display the change
            double change = amountGiven - totalAmount;
            System.out.println("Change: " + change);
            System.out.println("THANK YOU FOR SHOPPING WITH US");
        }
    }

    // displays a receipt that shows the items in the cart,
    // their quantities, unit prices, and total values.
    public void displayReceipt() throws ReceiptPrintingException {

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

        }
    }

}
