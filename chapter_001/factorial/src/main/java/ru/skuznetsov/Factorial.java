package ru.skuznetsov;

/**
 * Class factorial, contains method necessary for factorial calculation.
 * @author skuznetsov
 */
public class Factorial {
	/**
	* Method with computing factorial from 0 to specified number.
	* @param limit - specified number for factorial calculation.
	* @return factorial
	*/
    public int getFactorial(int limit) {
		int fact = 1;
        for (int i = limit; i > 0; i--) {
            fact *= i;
        }

        return fact;
    }
}
