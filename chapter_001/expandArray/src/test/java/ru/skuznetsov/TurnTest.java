package ru.skuznetsov;
import org.junit.Test;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;

/**
 * Created by Sergey on 27.11.2016.
 */
public class TurnTest {
    /**
     * Test method check result of expanding of array.
     * */
    @Test
    public void ifGivesArrayReturnTurnedArray() {
        final int num1 = 1;
        final int num2 = 5;
        final int num3 = 4;
        final int num4 = 8;
        final int num5 = 9;
        final int num6 = 6;
        final int num7 = 3;
        final int num8 = 6;

        Turn turn = new Turn();
        int[] array = new int[]{num1, num2, num3, num4, num5, num6, num7, num8};
        turn.back(array);

        MatcherAssert.assertThat(array, Is.is(new int[]{num8, num7, num6, num5, num4, num3, num2, num1}));
    }
    /**
     * Test method check throwing of exception then gives null on argument.
     * */
    @Test(expected = IllegalArgumentException.class)
    public void ifGivesNullExpectingException() {
        Turn turn = new Turn();
        turn.back(null);
    }
}
