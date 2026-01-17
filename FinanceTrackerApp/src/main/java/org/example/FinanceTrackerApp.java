package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

// 2. The FinanceTrackerApp Class (Main Application)
public class FinanceTrackerApp {
    private ArrayList<Transaction> transactions;
    private Scanner scanner;

    public FinanceTrackerApp() {
        transactions = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Create (Add) Transaction
    private void createTransaction() {
        System.out.println("\n===== ADD NEW TRANSACTION =====");

        // Get and validate ID
        System.out.print("Enter Transaction ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("Error: ID cannot be empty!");
            return;
        }

        // Check for duplicate ID
        for (Transaction t : transactions) {
            if (t.getId().equals(id)) {
                System.out.println("Error: Transaction with this ID already exists!");
                return;
            }
        }

        // Get and validate type
        String type;
        while (true) {
            System.out.print("Enter Type (INCOME/EXPENSE): ");
            type = scanner.nextLine().trim().toUpperCase();
            if (type.equals("INCOME") || type.equals("EXPENSE")) {
                break;
            } else {
                System.out.println("Error: Type must be either 'INCOME' or 'EXPENSE'. Please try again.");
            }
        }

        // Get and validate amount
        double amount;
        while (true) {
            System.out.print("Enter Amount: ");
            try {
                amount = Double.parseDouble(scanner.nextLine().trim());
                if (amount > 0) {
                    break;
                } else {
                    System.out.println("Error: Amount must be positive. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid amount. Please enter a valid number.");
            }
        }

        // Get description
        System.out.print("Enter Description: ");
        String description = scanner.nextLine().trim();
        if (description.isEmpty()) {
            System.out.println("Error: Description cannot be empty!");
            return;
        }

        // Get and validate date
        String date;
        while (true) {
            System.out.print("Enter Date (YYYY-MM-DD) or press Enter for today's date: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                // Use today's date
                date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
                break;
            } else {
                // Validate date format
                try {
                    LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
                    date = input;
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
                }
            }
        }

        // Create and add transaction
        Transaction transaction = new Transaction(id, type, amount, description, date);
        transactions.add(transaction);
        System.out.println("✓ Transaction added successfully!");
    }

    // Read (View All) Transactions
    private void viewAllTransactions() {
        System.out.println("\n===== ALL TRANSACTIONS =====");
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
        System.out.println("============================");
    }

    // Update Transaction
    private void updateTransaction() {
        System.out.println("\n===== UPDATE TRANSACTION =====");
        System.out.print("Enter Transaction ID to update: ");
        String id = scanner.nextLine().trim();

        Transaction transaction = findTransactionById(id);
        if (transaction == null) {
            System.out.println("Error: Transaction not found!");
            return;
        }

        System.out.println("Current Details: " + transaction);
        System.out.println("\nNote: ID field cannot be updated.");

        // Update type
        while (true) {
            System.out.print("Enter new Type (INCOME/EXPENSE) or press Enter to keep current: ");
            String type = scanner.nextLine().trim().toUpperCase();
            if (type.isEmpty()) {
                break;
            } else if (type.equals("INCOME") || type.equals("EXPENSE")) {
                transaction.setType(type);
                break;
            } else {
                System.out.println("Error: Type must be either 'INCOME' or 'EXPENSE'.");
            }
        }

        // Update amount
        while (true) {
            System.out.print("Enter new Amount or press Enter to keep current: ");
            String amountInput = scanner.nextLine().trim();
            if (amountInput.isEmpty()) {
                break;
            }
            try {
                double amount = Double.parseDouble(amountInput);
                if (amount > 0) {
                    transaction.setAmount(amount);
                    break;
                } else {
                    System.out.println("Error: Amount must be positive.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid amount.");
            }
        }

        // Update description
        System.out.print("Enter new Description or press Enter to keep current: ");
        String description = scanner.nextLine().trim();
        if (!description.isEmpty()) {
            transaction.setDescription(description);
        }

        // Update date
        while (true) {
            System.out.print("Enter new Date (YYYY-MM-DD) or press Enter to keep current: ");
            String dateInput = scanner.nextLine().trim();
            if (dateInput.isEmpty()) {
                break;
            }
            try {
                LocalDate.parse(dateInput, DateTimeFormatter.ISO_LOCAL_DATE);
                transaction.setDate(dateInput);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        System.out.println("✓ Transaction updated successfully!");
    }

    // Delete Transaction
    private void deleteTransaction() {
        System.out.println("\n===== DELETE TRANSACTION =====");
        System.out.print("Enter Transaction ID to delete: ");
        String id = scanner.nextLine().trim();

        Transaction transaction = findTransactionById(id);
        if (transaction == null) {
            System.out.println("Error: Transaction not found!");
            return;
        }

        System.out.println("Transaction to delete: " + transaction);
        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("yes") || confirm.equals("y")) {
            transactions.remove(transaction);
            System.out.println("✓ Transaction deleted successfully!");
        } else {
            System.out.println("Delete operation cancelled.");
        }
    }

    // Calculate Balance
    private void calculateBalance() {
        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction t : transactions) {
            if (t.getType().equals("INCOME")) {
                totalIncome += t.getAmount();
            } else if (t.getType().equals("EXPENSE")) {
                totalExpense += t.getAmount();
            }
        }

        double balance = totalIncome - totalExpense;

        System.out.println("\n===== FINANCIAL SUMMARY =====");
        System.out.printf("Total Income:  %.2f\n", totalIncome);
        System.out.printf("Total Expense: %.2f\n", totalExpense);
        System.out.printf("Current Balance: %.2f\n", balance);
        System.out.println("=============================");
    }

    // Helper method to find transaction by ID
    private Transaction findTransactionById(String id) {
        for (Transaction t : transactions) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    // Display menu
    private void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   PERSONAL FINANCE TRACKER             ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1. Add Transaction                     ║");
        System.out.println("║ 2. View All Transactions               ║");
        System.out.println("║ 3. Update Transaction                  ║");
        System.out.println("║ 4. Delete Transaction                  ║");
        System.out.println("║ 5. Calculate Balance                   ║");
        System.out.println("║ 6. Exit                                ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("Enter your choice: ");
    }

    // Main application loop
    public void run() {
        while (true) {
            displayMenu();
            String choiceInput = scanner.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a number between 1 and 6.");
                continue;
            }

            switch (choice) {
                case 1:
                    createTransaction();
                    break;
                case 2:
                    viewAllTransactions();
                    break;
                case 3:
                    updateTransaction();
                    break;
                case 4:
                    deleteTransaction();
                    break;
                case 5:
                    calculateBalance();
                    break;
                case 6:
                    System.out.println("\nThank you for using Personal Finance Tracker!");
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Error: Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        FinanceTrackerApp app = new FinanceTrackerApp();
        app.run();
    }
}
