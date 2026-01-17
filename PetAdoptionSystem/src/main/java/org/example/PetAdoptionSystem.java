package org.example;

// Part 2: Implementation & Testing
// 1. PetAdoptionSystem Class (Main Application)
public class PetAdoptionSystem {
    public static void main(String[] args) {
        System.out.println("===== Pet Adoption System =====\n");

        // Create a Dog object and a Cat object with different names, ages, and breeds
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat = new Cat("Whiskers", 2, "Persian");

        // Create an Owner object which will adopt both the Dog and Cat objects
        Owner owner = new Owner("John Smith", "123 Main Street, Dhaka");

        System.out.println("Owner Details:");
        System.out.println("Name: " + owner.getName());
        System.out.println("Address: " + owner.getAddress());
        System.out.println("Pets Adopted: " + owner.getPetsAdopted());
        System.out.println();

        // Adopt both pets
        System.out.println("Adopting Pets:");
        owner.adoptPet(dog);
        owner.adoptPet(cat);
        System.out.println("Total Pets Adopted: " + owner.getPetsAdopted());
        System.out.println();

        // For each pet, call the makeSound() method
        System.out.println("Pet Sounds:");
        System.out.println(dog.getName() + " says: " + dog.makeSound());
        System.out.println(cat.getName() + " says: " + cat.makeSound());
        System.out.println();

        // Test feed() and play() methods
        System.out.println("Interacting with Pets:");
        dog.feed();
        dog.play();
        cat.feed();
        cat.play();
        System.out.println();

        // Print out the details of the owner and the pets using toString()
        System.out.println("===== Final Details =====");
        System.out.println("Owner: " + owner.getName());
        System.out.println("Address: " + owner.getAddress());
        System.out.println("Total Pets Adopted: " + owner.getPetsAdopted());
        System.out.println("\nPet Details:");
        System.out.println(dog.toString());
        System.out.println(cat.toString());
    }
}
