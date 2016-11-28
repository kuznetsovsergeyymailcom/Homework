package ru.skuznetsov;

/**
 * Created by Sergey on 27.11.2016.
 */
public class Rotator {
    /**
     * Method contains algoritm of rotating an array.
     * @param array - array to be rotated.
     * */
    public void rotate(int[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("Null on argument");
        }
        int lenght = array.length;

        for (int i = 0; i < lenght / 2; i++) {
            for (int j = i; j < lenght - i - 1; j++) {
                int tmp = array[i][j];
                array[i][j] = array[j][lenght - i - 1];
                array[j][lenght - i - 1] = array[lenght - i - 1][lenght - j - 1];
                array[lenght - i - 1][lenght - j - 1] = array[lenght - j - 1][i];
                array[lenght - j - 1][i] = tmp;
            }
        }
    }
}
