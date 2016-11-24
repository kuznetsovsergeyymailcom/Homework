/**
 *
 */
package ru.skuznetsov.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Sergey
 *
 */
public class CalculatorTest {

    @Test
    public void FirstAddSecondCheckResult() {
	Calculator calc = new Calculator();
	calc.add(12.00, 34.00);
	double result = calc.getResult();
	assertEquals(46, result, 0);
    }

    @Test
    public void FirstSubstractSecondCheckResult() {
	Calculator calc = new Calculator();
	calc.substruct(12.00, 34.00);
	double result = calc.getResult();
	assertEquals(-22, result, 0);
    }

    @Test
    public void FirstDivideSecondCheckResult() {
	Calculator calc = new Calculator();
	calc.div(56.00, 8.00);
	double result = calc.getResult();
	assertEquals(7, result, 0);
    }

    @Test
    public void FirstMultiplySecondCheckResult() {
	Calculator calc = new Calculator();
	calc.multiple(12.00, 3.00);
	double result = calc.getResult();
	assertEquals(36, result, 0);
    }

    /**
     * Check throw illegal argumtn exception (dividing by zero)
     */
    @Test(expected = IllegalArgumentException.class)
    public void FirstDivideSecondCheckResultExpectError() {
	Calculator calc = new Calculator();
	calc.div(56.00, 0.00);
	double result = calc.getResult();
    }
}
