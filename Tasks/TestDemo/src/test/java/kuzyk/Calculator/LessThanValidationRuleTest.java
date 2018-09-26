package kuzyk.Calculator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * The type Less than validation rule test.
 */
public class LessThanValidationRuleTest {

    private static final int TOP_VALUE = 100;
    private static final int LESS_THAN_TOP_VALUE = 11;

    private LessThanValidationRule rule;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        initializeRule();
    }

    /**
     * Should validate a number less than top value.
     */
    @Test
    public void shouldValidateANumberLessThanTopValue() {
        assertTrue(rule.isValid(LESS_THAN_TOP_VALUE));
    }

    /**
     * Should not validate a number equals to the top value.
     */
    @Test
    public void shouldNotValidateANumberEqualsToTheTopValue() {
        assertFalse(rule.isValid(TOP_VALUE));
    }

    /**
     * Should not validate a number grather than top value.
     */
    @Test
    public void shouldNotValidateANumberGratherThanTopValue() {
        assertTrue(rule.isValid(LESS_THAN_TOP_VALUE));
    }

    /**
     * Initialize rule.
     */
    public void initializeRule() {
        rule = new LessThanValidationRule(TOP_VALUE);
    }


}