package ru.skuznetsov;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
* Class contains tests for comparing process.
*/
public class MaxTest {
	/**
	* Test method compare 2 numbers and find larger.
	*/
    @Test
    public void getMaxNumberFromTwoNumbers() {
		final int num1 = 3;
		final int num2 = 5;
		final int expected = 5;

        Max max = new Max();
        int largerNumber = max.max(num1, num2);

        assertEquals(expected, largerNumber);
    }
}
