package com.systechafrika;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    // ?Reference =>App
    App app = new App();

    @Test
    void add() {

        // when
        int result = app.add(2, 3);
        // then
        int expected = 5;
        // verify that result=expected
        Assertions.assertEquals(result, expected, "the sum of 2+3 should be 5");
    }

    @Test
    void divide() {
        // when
        int result1 = app.divide(8, 4);
        // then
        int expected2 = 2;
        // verify that result=expected
        Assertions.assertEquals(result1, expected2);
    }

}
