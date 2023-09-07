package com.systechafrika.atmsimulator;

import java.util.Scanner;

public class ATMApplicationMhusika {
    Scanner scanner = new Scanner(System.in);

    final double INITIAL_BALANCE = 1000.00;
    final double WITHDRAWAL_CHARGES = 0.02;
    final String DEFAULT_PASSWORD = "Admin123";

    double runningBalance = INITIAL_BALANCE;

    public static void main(String[] args) {
        ATMApplicationMhusika app = new ATMApplicationMhusika();
        boolean loggedIn = app.login();
        if (loggedIn) {
            System.out.println("Logged in successfully");
            // ? show menu
            boolean keepShowingMenu = true;
            while (keepShowingMenu) { // while(true)
                app.displayMenu();

                try {
                    System.out.println("Choose your option");
                    int option = app.scanner.nextInt();

                    // if(option == 1) {
                    // app.checkBalance();
                    // }else if (option == 2) {
                    // app.performDeposit();
                    // }else if(option == 3) {
                    // app.performWithdrawal();
                    // } else if(option == 4) {
                    // app.performTransfer();
                    // } else if (option == 5) {
                    // keepShowingMenu = false;
                    // } else {
                    // System.out.println("Invalid option... try again");
                    // }

                    switch (option) {
                        case 1:
                            app.checkBalance();
                            break;
                        case 2:
                            app.performDeposit();
                            break;
                        case 3:
                            app.performWithdrawal();
                            break;
                        case 4:
                            app.performTransfer();
                            break;
                        case 5:
                            keepShowingMenu = false;
                            break;
                        default:
                            System.out.println("Invalid option... try again");
                            break;
                    }

                } catch (Exception e) {

                    app.scanner.nextLine(); // ? this is to clear the \n character that is retained when using scanner
                                            // with nextInt
                    System.out.println("Invalid option - Integers only... try again");
                    // app.scanner.nextLine();
                }

            }

        } else {
            System.out.println("Naximum attemps failed");
        }

    }

    public boolean login() {
        // ? try three times, exit if not logged in
        int loginEnteries = 1;
        boolean loggedIn = false;
        while (loginEnteries <= 3) {
            System.out.println("Enter password");
            String userPassword = scanner.nextLine();
            if (userPassword.equals(DEFAULT_PASSWORD)) {

                // show menu
                loggedIn = true;
                break;
            }
            System.out.println("Wrong password");
            loginEnteries++;
        }
        return loggedIn;

    }

    public void displayMenu() {
        System.out.println("************************************\n");
        System.out.println("************* ATM SIMULATOR   ******\n");
        System.out.println("''''''''''''''''''''''''''''''''''''\n");

        System.out.println("************* ATM SERVICES    ********\n");
        System.out.println("____________________________________\n");
        System.out.println("1: Check Balance");
        System.out.println("2: Deposit");
        System.out.println("3: Withdraw");
        System.out.println("4: Transfer Cash");
        System.out.println("5: Quit");
        System.out.println("''''''''''''''''''''''''''''''''''''\n");

        // System.out.print("Choose your option: ");

    }

    public void checkBalance() {
        System.out.println("Your balance is: " + runningBalance);

    }

    public void performDeposit() {
        // ? get the amount deposit
        double amountToDeposit = scanner.nextDouble();

        // ? add the amount to the balance
        runningBalance += amountToDeposit; // runningBalance = runningBalance + amountToDeposit

    }

    public void performWithdrawal() {
        // ? get the amount to withdraw
        // ? calculate the amount to withdraw + charges
        // ? check if running balance is sufficient.

    }

    public void performTransfer() {
        // ? get the amount to transfer
        // ? subtract amount from the balance.

    }

    public void printReceipt() {
        // ? print the infromation about the transaction.

    }

}
