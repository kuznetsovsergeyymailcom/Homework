package ru.skuznetsov;
import org.junit.Assert;
import org.junit.Test;
/**
 * Created by Sergey on 28.11.2016.
 */
public class RotatorTest {
    /**
     * Test method to check result or rotating method.
     **/
    @Test
    public void ifGivesArrayThenResultIsRotatedArray() {
        Rotator rotator = new Rotator();
        final int row = 5, col = 5, ar00 = 5, ar01 = 10, ar02 = 15, ar03 = 20, ar04 = 25, ar10 = 4, ar11 = 8, ar12 = 12, ar13 = 16, ar14 = 20;
        final int ar20 = 3, ar21 = 6, ar22 = 9, ar23 = 12, ar24 = 15, ar30 = 2, ar31 = 4, ar32 = 6, ar33 = 8, ar34 = 10;
        final int ar40 = 1, ar41 = 2, ar42 = 3, ar43 = 4, ar44 = 5;
        final int i0 = 0, i1 = 1, i2 = 2, i3 = 3, i4 = 4;
        int[][] array = new int[row][col];

        int[][] expectedArray = new int[row][col];
        expectedArray[i0][i0] = ar00;  expectedArray[i1][i0] = ar10;  expectedArray[i2][i0] = ar20; expectedArray[i3][i0] = ar30;  expectedArray[i4][i0] = ar40;
        expectedArray[i0][i1] = ar01; expectedArray[i1][i1] = ar11;  expectedArray[i2][i1] = ar21; expectedArray[i3][i1] = ar31; expectedArray[i4][i1] = ar41;
        expectedArray[i0][i2] = ar02; expectedArray[i1][i2] = ar12; expectedArray[i2][i2] = ar22; expectedArray[i3][i2] = ar32; expectedArray[i4][i2] = ar42;
        expectedArray[i0][i3] = ar03; expectedArray[i1][i3] = ar13; expectedArray[i2][i3] = ar23; expectedArray[i3][i3] = ar33; expectedArray[i4][i3] = ar43;
        expectedArray[i0][i4] = ar04; expectedArray[i1][i4] = ar14; expectedArray[i2][i4] = ar24; expectedArray[i3][i4] = ar34; expectedArray[i4][i4] = ar44;
        // define original array
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (i > 0 && j > 0) {
                    array[i - 1][j - 1] = i * j;
                }
            }
        }

        rotator.rotate(array);
        Assert.assertArrayEquals(array, expectedArray);
    }
    /**
     * Method check throws exception after added null argument into rotate method.
     * */
    @Test(expected = IllegalArgumentException.class)
    public void ifGivesNullToRotateMethodArgumentThenThrowsException() {
        Rotator rotator = new Rotator();
        rotator.rotate(null);
    }
}
