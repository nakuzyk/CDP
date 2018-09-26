package kuzyk;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Division test.
 */
public class DivisionTest {
    private Division division;

    /**
     * Before.
     */
    @Before
    public void before() {
        division = new Division();
    }

    /**
     * Calculate result test.
     */
    @Test
    public void calculateResultTest() {
        double expected = 4;
        Assert.assertEquals(expected, division.calculateResult(16.0, 4.0), 0.001);
    }

    /**
     * Calculate result test 2.
     */
    @Test
    public void calculateResultTest2() {
        Double expected = Double.POSITIVE_INFINITY;
        Assert.assertEquals(expected, division.calculateResult(16.0, 0.0), 0.001);
    }
}

