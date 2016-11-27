package ru.skuznetsov;

/**
 * Created by Sergey on 27.11.2016.
 */
public class Turn {
    /**
     * Method takes an array as argument and expand it.
     * @param array - array for expanding
     * */
    public void back(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("null on argument");
        }
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}
