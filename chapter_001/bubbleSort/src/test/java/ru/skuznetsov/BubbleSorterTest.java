package ru.skuznetsov;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sergey on 27.11.2016.
 */
public class BubbleSorterTest {
    /**
     * Test method check resolt of sorting using bubble sort.
     * */
    @Test
    public void ifGivesNotSortedArrayThenVerifySortedResult() {
        final int num1 = 9;
        final int num2 = 4;
        final int num3 = 13;
        final int num4 = 5;
        final int num5 = 8;
        final int num6 = 6;
        final int num7 = 7;
        final int num8 = 23;
        final int num9 = 5;

        BubbleSorter sorter = new BubbleSorter();
        int[] array = new int[]{num1, num2, num3, num4, num5, num6, num7, num8, num9};
        sorter.sort(array);

        Assert.assertArrayEquals(new int[]{num2, num9, num9, num6, num7, num5, num1, num3, num8}, array);

    }
    /**
     * Test method check throws exception as reaction to null arg.
     * */
    @Test(expected = IllegalArgumentException.class)
    public void ifGiveNullThrowsException() {

        BubbleSorter sorter = new BubbleSorter();
        sorter.sort(null);

    }
}
