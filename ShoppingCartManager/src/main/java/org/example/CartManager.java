package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// CartManager class
public class CartManager {
    private List<CartItem> availableItems;
    private List<CartItem> cart;
    private Scanner scanner;

    public CartManager() {
        availableItems = new ArrayList<>();
        cart = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeItems();
    }

    // Initialize the 3 items
    private void initializeItems() {
        availableItems.add(new CartItem("Egg", 10, 0, false));
        availableItems.add(new CartItem("Milk", 20, 0, false));
        availableItems.add(new CartItem("Noodles", 30, 0, false));
    }

    // Add item to cart
    private void addItemToCart(int choice) {
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            return;
        }

        CartItem item = availableItems.get(choice - 1);

        if (item.isAddedToCart()) {
            System.out.println(item.getName() + " is already in the cart.");
        } else {
            item.setQuantity(1);
            item.setAddedToCart(true);
            cart.add(item);
            System.out.println(item.getName() + " added to cart successfully!");
        }
    }

    // Remove item from cart
    private void removeItemFromCart(int choice) {
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            return;
        }

        CartItem item = availableItems.get(choice - 1);

        if (!item.isAddedToCart()) {
            System.out.println("Cannot remove " + item.getName() + " - it's not in the cart yet!");
        } else {
            item.setQuantity(0);
            item.setAddedToCart(false);
            cart.remove(item);
            System.out.println(item.getName() + " removed from cart successfully!");
        }
    }

    // Increment quantity
    private void incrementQuantity(int choice) {
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            return;
        }

        CartItem item = availableItems.get(choice - 1);

        if (!item.isAddedToCart()) {
            System.out.println(item.getName() + " is not in the cart. Please add it first!");
        } else {
            item.incrementQuantity(1);
            System.out.println(item.getName() + " quantity increased to " + item.getQuantity());
        }
    }

    // Decrement quantity
    private void decrementQuantity(int choice) {
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            return;
        }

        CartItem item = availableItems.get(choice - 1);

        if (!item.isAddedToCart()) {
            System.out.println(item.getName() + " is not in the cart. Please add it first!");
        } else {
            item.decrementQuantity(1);
            System.out.println(item.getName() + " quantity decreased to " + item.getQuantity());
        }
    }

    // Print cart
    private void printCart() {
        System.out.println("\n========== SHOPPING CART ==========");
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty!");
        } else {
            for (CartItem item : cart) {
                System.out.println(item);
            }
        }
        System.out.println("===================================\n");
    }

    // Print total payable amount
    private void printTotalAmount() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getTotalPrice();
        }
        System.out.println("\n========== TOTAL PAYABLE AMOUNT ==========");
        System.out.printf("Total: %.2f Taka\n", total);
        System.out.println("==========================================\n");
    }

    // Display menu
    private void displayMenu() {
        System.out.println("\n===== E-COMMERCE SHOPPING CART MANAGER =====");
        System.out.println("Available Items:");
        System.out.println("1. Egg (10 Taka)");
        System.out.println("2. Milk (20 Taka)");
        System.out.println("3. Noodles (30 Taka)");
        System.out.println("\nOperations:");
        System.out.println("Add item: Enter 1, 2, or 3");
        System.out.println("Remove item: Enter -1, -2, or -3");
        System.out.println("Increment quantity: Enter 5");
        System.out.println("Decrement quantity: Enter 6");
        System.out.println("View cart: Enter 7");
        System.out.println("View total: Enter 8");
        System.out.println("Exit: Enter 0");
        System.out.println("============================================");
    }

    // Main method
    public static void main(String[] args) {
        CartManager manager = new CartManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            manager.displayMenu();
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Thank you for shopping! Goodbye!");
                break;
            } else if (choice >= 1 && choice <= 3) {
                manager.addItemToCart(choice);
            } else if (choice >= -3 && choice <= -1) {
                manager.removeItemFromCart(Math.abs(choice));
            } else if (choice == 5) {
                System.out.print("Enter item number to increment (1/2/3): ");
                int item = scanner.nextInt();
                manager.incrementQuantity(item);
            } else if (choice == 6) {
                System.out.print("Enter item number to decrement (1/2/3): ");
                int item = scanner.nextInt();
                manager.decrementQuantity(item);
            } else if (choice == 7) {
                manager.printCart();
            } else if (choice == 8) {
                manager.printTotalAmount();
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}