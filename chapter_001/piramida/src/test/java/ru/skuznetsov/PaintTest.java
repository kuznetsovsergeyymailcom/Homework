package ru.skuznetsov;
import org.junit.Assert;
import org.junit.Test;
/**
 * Created by Sergey on 27.11.2016.
 */
public class PaintTest {
    /**
     * Test method verify builded pyramid with expected.
     * */
    @Test
    public void ifHeightGraterThanZeroCreatePiramida() {
        final int height = 6;
        Paint paint = new Paint();
        paint.initPiramida(height);
        Assert.assertEquals("     ^ \n    ^ ^ \n   ^ ^ ^ \n  ^ ^ ^ ^ \n ^ ^ ^ ^ ^ \n^ ^ ^ ^ ^ ^ \n", paint.toString());
    }
    /**
     * Test method verify builded pyramid with expected.
     * */
    @Test
    public void ifHeightGraterThanZeroCreatePiramidaWithOneChar() {
        final int height = 1;
        Paint paint = new Paint();
        paint.initPiramida(height);
        Assert.assertEquals("^ \n", paint.toString());
    }
    /**
     * Test method check throws IllegalArgumentException then height less than zero.
     * */
    @Test(expected = IllegalArgumentException.class)
    public void ifHeightLessThanZeroThenThrowsException() {
        final int height = -10;
        Paint paint = new Paint();
        paint.initPiramida(height);
    }
}
