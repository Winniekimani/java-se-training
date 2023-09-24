package com.systechafrika.part1.stringandstringbuilder;

import java.util.logging.Logger;

public class StringClassDemo {
    private static final Logger LOGGER = Logger.getLogger(StringClassDemo.class.getName());

    public static void main(String[] args) {
        // ?strings are immutable,once created they cannot be modified
        // ?unless they are modified again

        // String message = "hello";
        // no effect
        // message.concat("world");
        // has effect by reassigning
        // message = message.concat(" winnie");
        // LOGGER.info(message);

        String firstName = "John";
        String lastName = "Doe";

        // Concatenating strings using the + operator
        String fullName = firstName + " " + lastName;

        // String manipulation methods
        LOGGER.info("Full Name: " + fullName);// prints John Doe
        LOGGER.info("Length: " + fullName.length());// prints 8(counts even the space)
        LOGGER.info("Uppercase: " + fullName.toUpperCase());// prints JOHN DOE
        LOGGER.info("Lowercase: " + fullName.toLowerCase());// jon doe

        // Checking if a string contains a specific substring
        boolean containsJohn = fullName.contains("John");
        LOGGER.info("Contains 'John': " + containsJohn);// Will print true because it contains john
    }

}
