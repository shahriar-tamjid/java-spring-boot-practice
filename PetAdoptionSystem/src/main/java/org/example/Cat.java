package org.example;

class Cat extends Pet implements PetBehavior {
    // Constructor
    public Cat(String name, int age, String breed) {
        super(name, age, breed);
    }

    // Override makeSound() to print "Meow!" (specific to cats)
    @Override
    public String makeSound() {
        return "Meow!";
    }

    // Implement feed() to print "Feeding the cat"
    @Override
    public void feed() {
        System.out.println("Feeding the cat.");
    }

    // Implement play() to print "Playing with the cat"
    @Override
    public void play() {
        System.out.println("Playing with the cat.");
    }

    // Override toString() to return cat's name, age, and breed
    @Override
    public String toString() {
        return "Cat [Name: " + getName() + ", Age: " + getAge() + ", Breed: " + getBreed() + "]";
    }
}
