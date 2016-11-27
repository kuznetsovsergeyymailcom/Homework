package ru.skuznetsov;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sergey on 26.11.2016.
 */
public class FactorialTest {

    /**
     * Test method, its calculate factorial from number and equals it with expected number.
     * */
    @Test
    public void checkFactorialResult() {
        final int number = 5;
        final double delta = 0.01;
		final int expected = 120;

        Factorial factorial = new Factorial();
        int fact  = factorial.getFactorial(number);
        Assert.assertEquals(expected, fact, delta);
    }
}
