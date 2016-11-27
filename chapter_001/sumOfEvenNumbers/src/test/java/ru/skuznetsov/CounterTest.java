package ru.skuznetsov;

import org.junit.Assert;
import org.junit.Test;
/**
* Test class of counter.
*/
public class CounterTest {
	/**
	* Test method.
	*/
    @Test
    public void ifNum2GraterThanNum1() {
		final int num1 = 1;
		final int num2 = 5;
		final int expected = 6;

        Counter counter = new Counter();
        int result = counter.add(num1, num2);
        Assert.assertEquals(expected, result);
    }
    /**
     * Test method.
     */
    @Test
    public void ifNum1GraterThanNum2() {
        final int num1 = 10;
        final int num2 = 5;
        final int expected = 14;

        Counter counter = new Counter();
        int result = counter.add(num1, num2);
        Assert.assertEquals(expected, result);
    }
}
