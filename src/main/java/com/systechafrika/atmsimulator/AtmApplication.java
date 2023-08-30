package com.systechafrika.atmsimulator;

import java.util.Scanner;

public class AtmApplication {

    public static void main(String[] args) {

        String defaultPassword = "Admin123";
        double balance = 1000.0, deposit, withdraw;
        int loginAttempts = 3;
        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false; // to track successful login

        while (loginAttempts > 0) {
            if (!loggedIn) {
                System.out.print("Enter password to login:");
                String passwordGiven = scanner.nextLine();
                if (passwordGiven.equals(defaultPassword)) {
                    loggedIn = true;
                    System.out.println("Login successful");
                    System.out.println(" ");
                } else {
                    loginAttempts--;
                    if (loginAttempts > 0) {
                        System.out.println("Incorrect password. You have " + loginAttempts + " attempts left");
                    } else {
                        System.out.println("You have exceeded the maximum number of login attempts.");
                        break; // Exit loop if max login attempts are reached
                    }
                }
            }

            if (loggedIn) {
                while (true) {// Loop to keep showing menu after each operation
                    System.out.println("***************");
                    System.out.println("ATM SIMULATOR");
                    System.out.println("\"\"\"\"\"\"\"\"\"\"\"\"\"");
                    System.out.println("ATM SERVICES");
                    System.out.println("_________________");
                    System.out.println("1.Check Balance\n2.Deposit\n3.Withdraw\n4.Transfer Cash\n5.Quit\n");
                    System.out.println("\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"");
                    System.out.print("\nChoose your option: ");

                    int option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            System.out.println("Your balance is " + balance);
                            break;
                        case 2:
                            System.out.println("Please enter the amount you want to deposit ");
                            deposit = scanner.nextDouble();
                            // adding to the total balance
                            balance = balance + deposit;
                            System.out.println(
                                    "Your Money has been successfully deposited.Your new balance is:" + balance);

                            break;
                        case 3:
                            System.out.println("Please enter the amount you want to withdraw ");
                            withdraw = scanner.nextDouble();
                            double withdrawFee = 0.02 * withdraw;// 2% withdrawal fee
                            // balance need to be greater than the withdrawn amount
                            if (balance >= withdraw + withdrawFee) // for successful transaction
                            {
                                balance = balance - (withdraw + withdrawFee);
                                System.out.println("Withdrawal successful! Your new balance is " + balance);
                            } else // not enough balance
                            {
                                System.out.println("Insufficient Balance.Available balance is " + balance);
                            }
                            break;
                        case 4:
                            System.out.println("Transfer Cash option selected.");
                            break;

                        case 5:
                            System.out.println("Successfully EXIT.");
                            System.exit(0);
                        default:
                            System.err.println("Please input a valid option");
                            break;
                    }
                }
            }
        }

        scanner.close();
    }
}