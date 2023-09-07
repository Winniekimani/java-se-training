package com.systechafrika.part2.classes;

import java.util.logging.Logger;

public class Intern {

    private static final Logger LOGGER = Logger.getLogger(Intern.class.getName());
    String name;
    String phoneNumber;
    String email;

    public void attendClass() {

        LOGGER.info("attend class");
    }

    public void doAssignment() {
        LOGGER.info("do assignment ");
    }

}
