package com.systechafrika.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystechRestaurant {

    final String DEFAULT_PASSWORD = "Admin123";
    final int MAX_LOGIN_ATTEMPTS = 3;

    private Scanner scanner = new Scanner(System.in);
    private int loginAttempts = 0;
    private boolean loggedIn = false;
    private List<MenuItem> menuItems = new ArrayList<>();
    private List<MenuItem> orderItems = new ArrayList<>();

    public void manageRestaurant() {
        login();
        loadMenu();

        while (loggedIn) {
            showMenu();
            int choice = takeCustomerSelection();

            switch (choice) {
                case 1:
                    // Handle choice 1 (Chai)
                    MenuItem chaiItem = menuItems.get(0); // Chai is the first item
                    orderItems.add(chaiItem);
                    break;
                case 2:
                    // Handle choice 2 (Andazi)
                    MenuItem andaziItem = menuItems.get(1); // Andazi is the second item
                    orderItems.add(andaziItem);
                    break;
                case 3:
                    // Handle choice 3 (Tosti)
                    MenuItem tostiItem = menuItems.get(2); // Tosti is the third item
                    orderItems.add(tostiItem);
                    break;
                case 4:
                    // Handle choice 4 (Ndengu and Accomplishment
                    MenuItem ndenguItem = menuItems.get(3); // Ndengu and Accomplishments is the fourth item
                    orderItems.add(ndenguItem);
                    break;
                case 5:
                    // Handle choice 5 (Beans and Accomplishments)
                    MenuItem beansItem = menuItems.get(4); // Beans and Accomplishments is the fifth item
                    orderItems.add(beansItem);
                    break;
                case 6:
                    // Handle choice 6 (Pilau Veg)
                    MenuItem pilauItem = menuItems.get(5); // Pilau Veg is the sixth item
                    orderItems.add(pilauItem);
                    break;
                case 7:
                    // Handle choice 7 (Quit)
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }

            if (choice >= 1 && choice <= 6) {
                takeCustomerOrder();
            }
        }

        System.out.println("Thank you for using SYSTEch Point of Sale system!");
    }

    public void login() {
        while (loginAttempts < MAX_LOGIN_ATTEMPTS) {
            System.out.print("Enter password to log in: ");
            String enteredPassword = scanner.nextLine();

            if (enteredPassword.equals(DEFAULT_PASSWORD)) {
                System.out.println("Successful login!");
                loggedIn = true;
                break;
            } else {
                loginAttempts++;
                System.out.println("Incorrect password. Attempts left: " + (MAX_LOGIN_ATTEMPTS - loginAttempts));
            }

            if (loginAttempts == MAX_LOGIN_ATTEMPTS) {
                System.out.println("You have exceeded the maximum login attempts. Exiting.");
                System.exit(1);
            }
        }
    }

    private void loadMenu() {
        // Initialize the menu items
        menuItems.add(new MenuItem(1, "Chai", 15.0));
        menuItems.add(new MenuItem(2, "Andazi", 10.0));
        menuItems.add(new MenuItem(3, "Tosti", 12.0));
        menuItems.add(new MenuItem(4, "Ndengu and Accomplishments", 15.0));
        menuItems.add(new MenuItem(5, "Beans and Accomplishments", 10.0));
        menuItems.add(new MenuItem(6, "Pilau Veg", 12.0));
    }

    public void showMenu() {
        // Display the restaurant menu
        System.out.println("______________________________");
        System.out.println("****SYSTECH RESTAURANT*******");

        System.out.println("DRINKS");
        System.out.println("____________________\n");
        System.out.println("1. CHAI----------------------------------15");
        System.out.println("2. ANDAZI--------------------------------10");
        System.out.println("3. TOSTI---------------------------------12");

        System.out.println("MEALS");
        System.out.println("____________________\n");
        System.out.println("4. NDENGU AND ACCOMPLISHMENTS------------70");
        System.out.println("5. BEANS AND ACCOMPLISHMENTS-------------70");
        System.out.println("6. PILAU VEG-----------------------------90");

        System.out.println("7. QUIT");
    }

    private int takeCustomerSelection() {
        // Get the user's selection
        System.out.print("Choose an option: ");
        int selection = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return selection;
    }

    private void takeCustomerOrder() {
        while (true) {
            System.out.print("Do you want to enter another meal or drink option (Y/N): ");
            String choice = scanner.nextLine();

            // The equalsIgnoreCase compares two strings for equality while ignoring
            // their case (uppercase or lowercase).
            if (choice.equalsIgnoreCase("N")) {
                showPaymentOptions();
                break;
            } else if (choice.equalsIgnoreCase("Y")) {
                showMenu();
                int subChoice = takeCustomerSelection();
                if (subChoice >= 1 && subChoice <= 6) {
                    addToOrder(subChoice);
                } else {
                    System.out.println("Invalid choice. Please choose a valid option.");
                }
            } else {
                System.out.println("Invalid choice. Please choose 'Y' or 'N'.");
            }
        }
    }

    private void addToOrder(int menuItemNumber) {
        // Handle the selected menu item
        MenuItem selectedMenuItem = null;

        // Find the selected menu item based on the menuItemNumber
        for (MenuItem item : menuItems) {
            if (item.getItemId() == menuItemNumber) {
                selectedMenuItem = item;
                break;
            }
        }

        if (selectedMenuItem != null) {
            orderItems.add(selectedMenuItem);
            System.out.println("Added " + selectedMenuItem.getItemName() + " to your order.");
        } else {
            System.out.println("Invalid menu item number.");
            return; // Exit the method if the menu item is invalid
            // dddkdkqdwdwdid
        }
    }

    private void showPaymentOptions() {
        while (true) {
            System.out.print("PROCEED TO PAYMENT (Y/N): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                processPayment();
                break;
            } else if (choice.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Invalid choice. Please choose 'Y' or 'N'.");
            }
        }
    }

    private void processPayment() {
        // Handle payment and display the balance
        System.out.println("Pay now for:");

        double total = 0.0;
        for (MenuItem item : orderItems) {
            System.out.println(item.getItemName() + "----------------------" + item.getItemPrice());
            total += item.getItemPrice();
        }

        System.out.println("Total: " + total);
        System.out.print("Enter amount to pay: ");
        double amountPaid = scanner.nextDouble();
        scanner.nextLine(); // Generate newline character

        if (amountPaid < total) {
            System.out.println("Insufficient payment. Please pay the full amount.");
        } else {
            double balance = amountPaid - total;
            System.out.println("Your balance is --------------------" + balance);
            orderItems.clear(); // Clear the order items
        }
    }

    private void exitProgram() {
        // Quit the program
        System.out.println("Thank you for being our loyal customer!");
        System.exit(0);
    }

    public static void main(String[] args) {
        SystechRestaurant app = new SystechRestaurant();
        app.manageRestaurant();
    }
}
