package com.systechafrika.part1.stringandstringbuilder;

import java.util.logging.Logger;

public class StringBuilderClassDemo {
    private static final Logger LOGGER = Logger.getLogger(StringBuilderClassDemo.class.getName());

    public static void main(String[] args) {
        // StringBuilder sb = new StringBuilder(100);
        // String str = "";

        // boolean equals = str.equals(sb.toString());
        // LOGGER.info("" + equals);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Hello, ");
        stringBuilder.append("world!");

        // Appending integers
        int num = 42;
        stringBuilder.append(" The answer is ").append(num);// The answer is 42

        // Inserting a substring at a specific position
        stringBuilder.insert(13, "awesome ");// Inserts the substring "awesome " at
        // index 13 in the StringBuilder.
        // So, the StringBuilder now becomes " The answer is awesome 42".

        // Replacing a substring
        // Replaces the characters in the range from index 7 to index 12 with the string
        // "Java"

        stringBuilder.replace(7, 12, "Java");// now becomes "The Java is awesome 42"

        // Deleting a substring
        stringBuilder.delete(0, 7);// Deletes the characters in the range from index
        // 0
        // to index 6. This removes " The Java" from the StringBuilder, leaving "is
        // awesome 42".

        // Converting StringBuilder to a String
        String finalString = stringBuilder.toString();
        LOGGER.info("Modified String: " + finalString);

    }
}
