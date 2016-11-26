package ru.skuznetsov.calculator;

/**
* Calculator class.
*/
public class Calculator {
	/**
	* result will cantain final value.
	*/
    private double result;
	/**
	* method makes sum of two params and assign result to result var.
	* @param first first number
	* @param second second number
	*/
    public void add(double first, double second) {
		result = first + second;
    }
	/**
	* method makes substruct of two params and assign result to result var.
	* @param first first number
	* @param second second number
	*/
    public void substruct(double first, double second) {
	result = first - second;
    }
	/**
	* method makes division of two params and assign result to result var.
	* @param first first number
	* @param second second number
	*/
    public void div(double first, double second) {
	if (second == 0) {
		throw new IllegalArgumentException("Second argument is zero");
	}

		result = first / second;
    }
	/**
	* method makes multiplication of two params and assign result to result var.
	* @param first first number
	* @param second second number
	*/
    public void multiple(double first, double second) {
		result = first * second;
    }
	/**
	* method returns result of operation.
	* @return result
	*/
    public double getResult() {
	return result;
    }

}
