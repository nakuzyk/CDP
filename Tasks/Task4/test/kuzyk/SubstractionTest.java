package kuzyk;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Substraction test.
 */
public class SubstractionTest {

    private Substraction substraction;

    /**
     * Before.
     */
    @Before
    public void before() {
        substraction = new Substraction();
    }

    /**
     * Calculate result test.
     */
    @Test
    public void calculateResultTest() {
        double expected = 7;
        Assert.assertEquals(expected, substraction.calculateResult(20.0, 13.0), 0.001);
    }


}
