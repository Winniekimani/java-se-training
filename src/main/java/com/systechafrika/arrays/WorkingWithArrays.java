package com.systechafrika.arrays;

import java.util.logging.Logger;

public class WorkingWithArrays {

    private static final Logger LOGGER = Logger.getLogger(WorkingWithArrays.class.getName());

    public void singleDimensionalArray() {
        int[] numbers = { 45, 7, 9, 25 };
        for (int i = 0; i < numbers.length; i++) {

            LOGGER.info("" + numbers[i]);
        }

        String[] fruits = { "mango", "bananas", "apples", "beans" };
        LOGGER.info(fruits[0]);
        LOGGER.info(fruits[2]);

    }

    public void multiDimensionalArray() {

        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // length of multi dimension array we count the number of elements in the parent
        // array
        int length = matrix.length;
        LOGGER.info("Length of multi dimension array: " + length);

    }

    public static void main(String[] args) {
        WorkingWithArrays a = new WorkingWithArrays();
        a.singleDimensionalArray();
        a.multiDimensionalArray();

    }

}
