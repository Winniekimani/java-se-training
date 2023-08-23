package com.systechafrika.variables;

import java.util.logging.Logger;

public class VariablesDemo {

    private static final Logger LOGGER = Logger.getLogger(VariablesDemo.class.getName());

    public static void main(String[] args) {
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

}
