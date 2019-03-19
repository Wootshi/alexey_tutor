package org.automation.java;

import org.junit.Test;
import org.testng.Assert;

public class SquareTests {
    @Test
    public void testArea() {
        Square s = new Square(5);
        Assert.assertEquals(s.squareArea(), 25.0);
    }
}