package com.systechafrika.stringandstringbuilder;

import java.util.logging.Logger;

public class StringClassDemo {
    private static final Logger LOGGER = Logger.getLogger(StringClassDemo.class.getName());

    public static void main(String[] args) {
        // ?strings are immutable,once created they cannot be modified
        // ?unless they are modified again

        String message = "hello";
        message.concat("world");
        LOGGER.info(message);
    }

}
