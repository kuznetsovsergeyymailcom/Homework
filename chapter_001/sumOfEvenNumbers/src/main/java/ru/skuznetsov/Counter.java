package ru.skuznetsov;
/**
* Class som info about class.
*/
public class Counter {
	/**
	* Method calculates the sum of even numbers in ramge.
	* @param start - first number on range
	* @param finish - last number on range
	* @return sum of numbers in range.
	*/
    public int add(int start, int finish) {

      int counter = 0;
        if (start < finish) {

            for (int i = start; i < finish; i++) {
                if (i % 2 == 0) {
					counter += i;
				}
            }

         return counter;
        } else if (start > finish) {

            for (int i = finish; i < start; i++) {
                if (i % 2 == 0) {
					counter += i;
				}
            }
         return counter;

        } else {
         return 0;
        }
    }
}
