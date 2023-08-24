package com.systechafrika;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // ?default
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
    public void assertNotEqualsTest() {
        App app = new App();
        // when
        int actual = app.add(2, 5);// should be 7
        int unexpected = 6;

        Assertions.assertNotEquals(unexpected, actual, "6 and 7 should not be the same");

    }

    // Check that an object is not null
    @Test
    public void assertNotNullTest() {
        String str5 = "abc";
        Assertions.assertNotNull(str5);// this case will run because the str is not null

    }

    // Check that an object is null
    @Test
    public void assertNullTest() {
        String str5 = null;
        Assertions.assertNull(str5);
    }

    // Check whether two arrays are equal to each other.
    @Test
    public void assertArrayEqualTest() {

        // int[] expectedArray = { 1, 2, 3 };
        // int[] actualArray = { 1, 4, 3 };

        // here our test will fail because we are expected to have [2] in index
        // 1(ouractuaarray) but
        // we have [4]
        // Assertions.assertArrayEquals(expectedArray, actualArray);

        int[] expectedArray = { 1, 2, 3 };
        int[] actualArray = { 1, 2, 3 };

        // here our test will run because array elements are the same
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    // Check that a condition is true
    @Test
    public void assertTrueTest() {
        int val1 = 5;
        int val2 = 25;

        Assertions.assertTrue(val2 > val1);

    }

    // Check that a condition is false
    @Test
    public void assertFalseTest() {
        int val1 = 5;
        int val2 = 25;

        Assertions.assertFalse(val2 < val1);

    }

    @Test
    public void assertSameTest() {
        int val1 = 5;
        int val2 = 5;

        Assertions.assertSame(val1, val2);

    }

    @Test
    public void assertNotSameTest() {
        int val1 = 5;
        int val2 = 25;

        Assertions.assertNotSame(val1, val2);

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
