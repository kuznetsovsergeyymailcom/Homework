
package ru.skuznetsov.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
* Tests of calculator class.
*/
public class CalculatorTest {

	/**
	* First number + second compare result with expected number.
	*/
    @Test
    public void firstAddSecondCheckResult() {
		final double num1 = 12.00;
		final double num2 = 34.00;
		final double expected = 46.00;
		final double prec = 0.01;

		Calculator calc = new Calculator();
		calc.add(num1, num2);
		double result = calc.getResult();
		assertEquals(expected, result, prec);
    }
	/**
	* First number - second compare result with expected number.
	*/
    @Test
    public void firstSubstractSecondCheckResult() {
		final double num1 = 12.00;
		final double num2 = 34.00;
		final double expected = -22.00;
		final double prec = 0.01;

		Calculator calc = new Calculator();
		calc.substruct(num1, num2);
		double result = calc.getResult();
		assertEquals(expected, result, prec);
    }
	/**
	* First number / second compare result with expected number.
	*/
    @Test
    public void firstDivideSecondCheckResult() {
		final double num1 = 56.00;
		final double num2 = 8.00;
		final double expected = 7.00;
		final double prec = 0.01;

		Calculator calc = new Calculator();
		calc.div(num1, num2);
		double result = calc.getResult();
		assertEquals(expected, result, prec);
    }
	/**
	* First number * second compare result with expected number.
	*/
    @Test
    public void firstMultiplySecondCheckResult() {
		final double num1 = 12.00;
		final double num2 = 3.00;
		final double expected = 36.00;
		final double prec = 0.01;

		Calculator calc = new Calculator();
		calc.multiple(num1, num2);
		double result = calc.getResult();
		assertEquals(expected, result, prec);
    }

    /**
     * Check throw illegal argumtn exception (dividing by zero).
     */
    @Test(expected = IllegalArgumentException.class)
	public void firstDivideSecondCheckResultExpectError() {
		final double num1 = 56.00;
		final double num2 = 0.00;

		Calculator calc = new Calculator();
		calc.div(num1, num2);
		double result = calc.getResult();
    }
}
