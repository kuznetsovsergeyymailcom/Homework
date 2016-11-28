package ru.skuznetsov;

import java.util.Arrays;

/**
 * Created by Sergey on 28.11.2016.
 */
public class DublicatesRemover {
    /**
     * Method mission is remove dublicates from array with string elements.
     * @param array - original array, probably with dublicates
     * @return array withot dublicates
     * */
    public String[] removeDublicates(String[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Null on arguments");
        }
        int uniqueCount = array.length;
        for (int i = 0; i < uniqueCount; i++) {
            for (int j = i + 1; j < uniqueCount; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[uniqueCount - 1];
                    uniqueCount--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, uniqueCount);
    }
}
