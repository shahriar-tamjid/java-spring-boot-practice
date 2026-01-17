package org.example;


// CartItem class
class CartItem {
    private int productId;
    private String name;
    private double unitPrice;
    private int quantity;
    private boolean addedToCart;

    // Primary constructor with auto-generated random ID
    public CartItem(String name, double unitPrice, int quantity, boolean addedToCart) {
        this.productId = (int) (Math.random() * 10000) + 1;
        this.name = name;
        setUnitPrice(unitPrice); // Validation through setter
        this.quantity = quantity;
        this.addedToCart = addedToCart;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAddedToCart() {
        return addedToCart;
    }

    // Setters
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitPrice(double unitPrice) {
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price cannot be negative");
        }
        this.unitPrice = unitPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAddedToCart(boolean addedToCart) {
        this.addedToCart = addedToCart;
    }

    // Method to increment quantity
    public void incrementQuantity(int amount) {
        this.quantity += amount;
    }

    // Method to decrement quantity
    public void decrementQuantity(int amount) {
        if (this.quantity - amount < 1) {
            System.out.println("Quantity cannot be less than 1");
        } else {
            this.quantity -= amount;
        }
    }

    // Calculate total price for this item
    public double getTotalPrice() {
        return unitPrice * quantity;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Unit Price: %.2f | Quantity: %d | Total: %.2f",
                productId, name, unitPrice, quantity, getTotalPrice());
    }
}
