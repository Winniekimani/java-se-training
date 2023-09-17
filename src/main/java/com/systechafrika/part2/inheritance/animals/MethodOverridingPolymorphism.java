package com.systechafrika.part2.inheritance.animals;

public class MethodOverridingPolymorphism {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal anyAnimal = new Animal();
        dog.makeSound();// dog barks
        cat.makeSound();// cat meows
        anyAnimal.makeSound();// animals make sound

        Animal dog2 = new Animal();
        dog2.makeSound();// animals make sound
    }
}
