package kuzyk;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Addition test.
 */
public class AdditionTest {

    private Addition addition;

    /**
     * Before.
     */
    @Before
    public void before() {
        addition = new Addition();
    }

    /**
     * Calculate result test.
     */
    @Test
    public void calculateResultTest() {
        double expected = 9;
        Assert.assertEquals(expected, addition.calculateResult(4.0, 5.0), 0.001);
    }
}

