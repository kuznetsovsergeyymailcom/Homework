package ru.skuznetsov;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MaxTest {

    @Test
    public void getMaxNumberFromTwoNumbers(){
        Max max = new Max();
        int largerNumber = max.max(3,5);

        assertEquals(5,largerNumber);
    }
    
}
