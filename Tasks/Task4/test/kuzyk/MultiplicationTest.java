package kuzyk;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Multiplication test.
 */
public class MultiplicationTest {
    private Multiplication multiplication;

    /**
     * Before.
     */
    @Before
    public void before() {
        multiplication = new Multiplication();
    }

    /**
     * Calculate result test.
     */
    @Test
    public void calculateResultTest() {
        double expected = 70;
        Assert.assertEquals(expected, multiplication.calculateResult(7.0, 10.0), 0.001);
    }
}
