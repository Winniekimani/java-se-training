package com.systechafrika.operators;

import java.util.logging.Logger;

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

    public void assignmentOperators() {
        // simple assignment operator
        int a = 5;
        int sum;

        sum = a;

        // addition assignment operator
        sum += a;
        LOGGER.info("the result of the addition assignment is " + sum);

        // subtraction assignment operator
        sum -= a;
        LOGGER.info("the result of the subtraction assignment is " + sum);

        // multiplication assignment operator
        sum *= a;
        LOGGER.info("the result of the multiplication assignment is " + sum);

        // division assignment operator
        sum /= 1;
        LOGGER.info("the result of the division assignment is " + sum);

    }

    public void comparisonOperators() {
        int x = 5;
        int y = 3;
        // greater than operator
        LOGGER.info("x > y:" + (x > y)); // returns true, because 5 is higher than 3

        // less than operator
        LOGGER.info("x < y:" + (x < y)); // returns false, because 5 is not less than 3

        // Equal to operator
        LOGGER.info("x == y:" + (x == y)); // returns false,x is not equal to y

        // Greater than or equal to operator
        LOGGER.info("x >= y:" + (x >= y)); // returns true

        // less than or equal to operator
        LOGGER.info("x <= y:" + (x <= y)); // returns false

        // Not equal operator
        LOGGER.info("x != y:" + (x != y)); // returns true,x is not equal to y

    }

    public static void main(String[] args) {
        OperatorsDemo a = new OperatorsDemo();
        // a.arithmeticOperators();
        // a.assignmentOperators();
        a.comparisonOperators();

    }

}
