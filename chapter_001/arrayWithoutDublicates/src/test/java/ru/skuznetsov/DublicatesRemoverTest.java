package ru.skuznetsov;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sergey on 28.11.2016.
 */
public class DublicatesRemoverTest {
    /**
     * Test method contains algoritm of removing dublicates from array.
     * */
    @Test
    public void ifRemoverTakesArrayWithDublicatesThenReturnsArrayWithoutDublicates() {
       DublicatesRemover remover = new DublicatesRemover();
       String[] array = new String[]{"Hello", "World", "Hi", "Man", "Hi", "Hello", "Hello", "World"};
       String[] expectedArray = new String[]{"Hello", "World", "Hi", "Man"};
       String[] arrayWithoutDublicates = remover.removeDublicates(array);

        Assert.assertArrayEquals(expectedArray, arrayWithoutDublicates);

    }
    /**
     * Test method contains algoritm of removing dublicates from array.
     * */
    @Test(expected = IllegalArgumentException.class)
    public void ifRemoverTakesNullOnArgumentThenThrowsException() {
        DublicatesRemover remover = new DublicatesRemover();
        remover.removeDublicates(null);
    }
}
