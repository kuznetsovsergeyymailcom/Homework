package ru.skuznetsov;

/**
 * Created by Sergey on 27.11.2016.
 */
public class BubbleSorter {
    /**
     * Sorting method.
     * @param array - target array to sort
     * */
    public void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = array[j];
                if (temp > array[j + 1]) {
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
