package ru.skuznetsov;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sergey on 28.11.2016.
 */
public class SubCheckerTest {
    /**
     * Test method check is string contains specified sub string.
     * */
    @Test
    public void checkIsStringContainsSubString() {
        SubChecker checker = new SubChecker();
        String str = "HolidayNewYear";
        String sub = "day";

        Assert.assertTrue(checker.contains(str, sub));
    }
    /**
     * Test method check is string not contains specified sub string.
     * */
    @Test
    public void checkIsStringContainsSubStringToFalse() {
        SubChecker checker = new SubChecker();
        String str = "HolidayNewYear";
        String sub = "da23y";

        Assert.assertFalse(checker.contains(str, sub));
    }
}
