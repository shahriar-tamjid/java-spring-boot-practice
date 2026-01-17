package org.example;

class Dog extends Pet implements PetBehavior {
    // Constructor
    public Dog(String name, int age, String breed) {
        super(name, age, breed);
    }

    // Override makeSound() to print "Woof!" (specific to dogs)
    @Override
    public String makeSound() {
        return "Woof!";
    }

    // Implement feed() to print "Feeding the dog"
    @Override
    public void feed() {
        System.out.println("Feeding the dog.");
    }

    // Implement play() to print "Playing with the dog"
    @Override
    public void play() {
        System.out.println("Playing with the dog.");
    }

    // Override toString() to return dog's name, age, and breed
    @Override
    public String toString() {
        return "Dog [Name: " + getName() + ", Age: " + getAge() + ", Breed: " + getBreed() + "]";
    }
}