/**
 *
 */
package ru.skuznetsov.calculator;

/**
 * @author Sergey
 *
 */
public class Calculator {

    public double result;

    void add(double first, double second) {
	result = first + second;
    }

    void substruct(double first, double second) {
	result = first - second;
    }

    void div(double first, double second) {
	if (second == 0)
	    throw new IllegalArgumentException("Second argument is zero");
	result = first / second;
    }

    void multiple(double first, double second) {
	result = first * second;
    }

    double getResult() {
	return result;
    }

}
