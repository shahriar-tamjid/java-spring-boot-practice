package org.example;

// 5. The Owner Class
class Owner {
    // All fields are private
    private String name;
    private String address;
    private int petsAdopted;

    // Constructor
    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
        this.petsAdopted = 0;
    }

    // Method to adopt a pet
    public void adoptPet(Pet pet) {
        petsAdopted++;
        System.out.println("You have adopted " + pet.getName() + "!");
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPetsAdopted() {
        return petsAdopted;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}