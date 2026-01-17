package org.example;

import java.util.Scanner;

class SimpleGeometryCalculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=== Simple Geometry Calculator ===");

        double length = getPositiveInput("Enter the length of the rectangle: ");
        double width = getPositiveInput("Enter the width of the rectangle: ");

        double area = calculate(length, width, "AREA");
        double perimeter = calculate(length, width, "PERIMETER");

        displayResult(length, width, area, perimeter);

        scanner.close();
    }

    // Method for validated user input
    static double getPositiveInput(String message) {
        double value;

        while (true) {
            System.out.print(message);
            value = scanner.nextDouble();

            if (value > 0) {
                break;
            } else {
                System.out.println("⚠ Invalid input! Please enter a positive number.");
            }
        }
        return value;
    }

    // Single calculation method
    static double calculate(double length, double width, String type) {
        if (type.equals("AREA")) {
            return length * width;
        } else if (type.equals("PERIMETER")) {
            return 2 * (length + width);
        }
        return 0;
    }

    // Display output method
    static void displayResult(double length, double width, double area, double perimeter) {
        System.out.println("\n--- Calculation Result ---");
        System.out.printf("Length      : %.2f\n", length);
        System.out.printf("Width       : %.2f\n", width);
        System.out.printf("Area        : %.2f\n", area);
        System.out.printf("Perimeter   : %.2f\n", perimeter);
    }
}
