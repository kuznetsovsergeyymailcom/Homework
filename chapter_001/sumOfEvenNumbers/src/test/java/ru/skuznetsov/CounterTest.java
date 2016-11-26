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
    public void calculateEvenNumbersOnRange() {
		final int num1 = 1;
		final int num2 = 5;
		final int expected = 6;

        Counter counter = new Counter();
        int result = counter.add(num1, num2);
        Assert.assertEquals(expected, result);
    }

}
