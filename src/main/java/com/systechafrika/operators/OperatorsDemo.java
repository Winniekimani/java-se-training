package com.systechafrika.operators;

import java.util.logging.Logger;

import com.systechafrika.variables.VariablesDemo;

public class OperatorsDemo {
    private static final Logger LOGGER = Logger.getLogger(OperatorsDemo.class.getName());

    private void arithmeticOperators() {

        int a = 10;
        int b = 5;

        // addition operator
        int sum = a + b;
        LOGGER.info("the total sum of a and b is " + sum);

        // subtraction operator
        int difference = a - b;
        LOGGER.info("the difference of a and b is " + difference);

        // multiplication operator
        int multiplication = a * b;
        LOGGER.info("the multiplication of a and b is " + multiplication);

        // division operator
        int division = a / b;
        LOGGER.info("a divided by b is  " + division);

        // modulus operator
        int modulo = a % b;
        LOGGER.info("the modulo of a and b  is  " + modulo);

    }

    public static void main(String[] args) {
        OperatorsDemo a = new OperatorsDemo();
        a.arithmeticOperators();

    }

}
