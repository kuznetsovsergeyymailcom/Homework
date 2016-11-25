package ru.skuznetsov;

import org.junit.Assert;
import org.junit.Test;

public class CounterTest {

    @Test
    public void calculateEvenNumbersOnRange(){
        Counter counter = new Counter();
        int result = counter.add(1,5);
        Assert.assertEquals(6,result);
    }

}
