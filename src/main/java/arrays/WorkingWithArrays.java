package arrays;

import java.util.logging.Logger;

public class WorkingWithArrays {

    private static final Logger LOGGER = Logger.getLogger(WorkingWithArrays.class.getName());

    public void singleDimensionalArray() {
        int[] numbers = { 45, 7, 9, 25 };
        for (int i = 0; i < numbers.length; i++) {

            LOGGER.info("" + numbers[i]);
        }

    }

    public void multiDimensionalArray() {
    }

    public static void main(String[] args) {
        WorkingWithArrays a = new WorkingWithArrays();
        a.singleDimensionalArray();

    }

}
