package com.systechafrika.part2.inheritance.animals;

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }

    public String printName() {
        return "Dog";
    }

}
