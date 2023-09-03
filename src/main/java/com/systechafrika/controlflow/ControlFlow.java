package com.systechafrika.controlflow;

import java.util.logging.Logger;

public class ControlFlow {

    private static final Logger LOGGER = Logger.getLogger(ControlFlow.class.getName());

    public void ifElseStatement() {

        int maths = 70;
        char grade;
        if (maths >= 70) {
            grade = 'A';

        } else if (maths <= 69 && maths >= 50) {
            grade = 'B';
        } else if (maths <= 49 && maths >= 30) {
            grade = 'D';
        } else {
            grade = 'E';
            LOGGER.info("student grade" + grade);
        }

    }

    public void switchStatement() {

        String day = "Friday";

        switch (day) {
            case "Monday":
                LOGGER.info("working day");
                break;
            case "Tuesday":
                LOGGER.info("tuesday");
                break;
            case "Thursday":
                LOGGER.info("thursday");
                break;
            case "Friday":
                LOGGER.info("Tupige sherehe");
                break;
        }
    }

    public static void main(String[] args) {
        ControlFlow a = new ControlFlow();
        a.ifElseStatement();
        a.switchStatement();

    }

}
