package com.systechafrika.part1.variables;

import java.util.logging.Logger;

public class VariablesDemo {

    private static final Logger LOGGER = Logger.getLogger(VariablesDemo.class.getName());

    public void constantVariables() {
        // integer variables
        // ?type variableName=value
        int score = 0;
        LOGGER.info("score value is" + score);

        // constant variables
        final double PI = 3.14159;
        double radius = 7.0;
        double area = PI * radius * radius;
        LOGGER.info("the area of the circle is " + area);

    }

    private void integerTypes() {

        LOGGER.info("integer Minimum" + Integer.MIN_VALUE);
        LOGGER.info("integer Maximum " + Integer.MAX_VALUE);

        LOGGER.info("long Min" + Long.MIN_VALUE);
        LOGGER.info("long Maximum " + Long.MAX_VALUE);

        // byte,short,int,long
        // ?wrapper classes
        byte aPrimitive = 23;
        Byte aWrapper = 23;// byte wrapper classes start with capital

        LOGGER.info("byte primitive" + aPrimitive);
        LOGGER.info("Byte Wrapper " + aWrapper);

        int a = aWrapper.intValue();
        LOGGER.info("integer value from byte wrapper " + a);

        // short
        short s = 23;
        Short aShort = 23;

        // int
        int c = 23;
        Integer aInt = 23;

        // long
        long d = 23;
        Long aLong = 23L;

    }

    private void floatingTypes() {
        float floatRate = 2.567890F;
        double doubleRate = 2.567890;
        LOGGER.info("Float value:" + floatRate);
        LOGGER.info("Double value:" + doubleRate);

        // float
        float price = 0.345F;
        Float priceFloat = 0.345F;

        // double
        double cPrice = 90.45;
        Double avgDouble = 90.45;
    }

    private void characterTypes() {
        char grade = 'A';
        LOGGER.info("character value:" + grade);
    }

    private void booleanTypes() {
        boolean isPromoted = true;
        boolean isProcessed = false;
        LOGGER.info("true value:" + isPromoted);
        LOGGER.info("false value:" + isProcessed);
    }

    public static void main(String[] args) {
        VariablesDemo a = new VariablesDemo();
        a.constantVariables();
        a.booleanTypes();
        a.characterTypes();
        a.floatingTypes();
        a.integerTypes();

    }

}
