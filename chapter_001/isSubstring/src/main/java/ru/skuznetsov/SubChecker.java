package ru.skuznetsov;

import java.util.Arrays;

/**
 * Created by Sergey on 28.11.2016.
 */
public class SubChecker {
    /**
     * Method contains algoritm wich one check is string contains substring.
     * @param original - string with full text
     * @param sub - substring
     * @return boolean result is string contains substring
     * */
    public static boolean contains(String original, String sub) {

        char[] charsOfMainString = original.toCharArray();
        char[] charsOfSubString = sub.toCharArray();
        int subLenght = charsOfSubString.length;

        for (int i = 0; i < charsOfMainString.length; i++) {
            if (charsOfSubString[0] == charsOfMainString[i]) {

                char[] temp =  copyOfRange(charsOfMainString, i, subLenght);
                if (Arrays.equals(charsOfSubString, temp)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Method makes copy range of array.
     * @param array - original array
     * @param from - start index
     * @param lenght - final index
     * @return array with chars
     * */
    private static char[] copyOfRange(char[] array, int from, int lenght) {
        char[] temp = new char[lenght];
        int i = from;
        int j = 0;
        while (i < lenght + from) {
            temp[j] = array[i];
            i++;
            j++;
        }
        return temp;
    }
}
