package org.example;

import java.util.Scanner;

public class Main {

    static void main() {

        double mainBalance = 1000.00;
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);

        while (isRunning) {

            System.out.println("""
                    Welcome to the Simple Console ATM!
                    Please select an option:
                    1. Check Balance
                    2. Deposit Funds
                    3. Withdraw Funds
                    4. Exit
                    """);
            System.out.print("Please, enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance is: " + mainBalance);
                    break;
                case 2:
                    System.out.print("Enter Amount: ");
                    double newFunds = sc.nextDouble();
                    mainBalance += newFunds;
                    System.out.println("New Balance: " + mainBalance);
                    break;
                case 3:
                    System.out.print("Enter Amount: ");
                    double withdrawFunds = sc.nextDouble();
                    double updatedBalance = mainBalance;
                    updatedBalance -= withdrawFunds;
                    if (updatedBalance < 0) {
                        System.out.println("You cannot withdraw more than your current balance");
                    } else {
                        mainBalance = updatedBalance;
                        System.out.println("New Balance: " + mainBalance);
                    }
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Thank you for using the ATM! Goodbye.");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

}
