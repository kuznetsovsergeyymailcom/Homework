package ru.skuznetsov;
/**
* Class contains methods for calculation of largest number.
*/
public class Max {

	/**
	* Method compare two number and define largest of them.
	* @param first - first number
	* @param second - second number
	* @return larget number
	*/
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }
	/**
	* Method compare 3 number and define largest of them.
	* @param first - first number
	* @param second - second number
	* @param third - third number
	* @return largest number
	*/
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}
