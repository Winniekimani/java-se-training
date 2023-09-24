package com.systechafrika.part2.abstractclasses;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);

    }

    @Override
    public void makeSound() {
        System.out.println("wolf");
    }

}
