package org.example;

// 1. The Transaction Class
class Transaction {
    // Fields - all private for encapsulation
    private final String id;
    private String type;
    private double amount;
    private String description;
    private String date;

    // No Arguments Constructor
    public Transaction() {
        this.id = "";
        this.type = "";
        this.amount = 0.0;
        this.description = "";
        this.date = "";
    }

    // All Arguments Constructor
    public Transaction(String id, String type, double amount, String description, String date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    // Getters for all fields
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    // Setters for all fields except id (id is immutable)
    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Type: %s | Amount: %.2f | Description: %s | Date: %s",
                id, type, amount, description, date);
    }
}
