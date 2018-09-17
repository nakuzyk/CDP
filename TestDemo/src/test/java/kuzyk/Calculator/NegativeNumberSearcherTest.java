package kuzyk.Calculator;

import kuzyk.exception.NegativeNumbersException;

import org.junit.Test;
import org.junit.Before;
import kuzyk.exception.ValidatorException;

import java.util.LinkedList;
import java.util.List;

/**
 * The type Negative number searcher test.
 */
public class NegativeNumberSearcherTest {

    private static final int POSITIVE_VALUE = 100;
    private static final int ZERO = 0;
    private static final int NEGATIVE_VALUE = -11;

    private NegativeNumberSearcher validator;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        initializeRule();
    }

    /**
     * Should validate positive numbers.
     *
     * @throws ValidatorException the validator exception
     */
    @Test
    public void shouldValidatePositiveNumbers() throws ValidatorException {
        List<Integer> positiveNumbers = generateIntegerList(POSITIVE_VALUE);
        validator.validate(positiveNumbers);
    }

    /**
     * Should validate zero.
     *
     * @throws ValidatorException the validator exception
     */
    @Test
    public void shouldValidateZero() throws ValidatorException {
        List<Integer> positiveNumbers = generateIntegerList(ZERO);
    }

    /**
     * Should not validate negative numbers.
     *
     * @throws ValidatorException the validator exception
     */
    @Test(expected = NegativeNumbersException.class)
    public void shouldNotValidateNegativeNumbers() throws ValidatorException {
        List<Integer> positiveNumbers = generateIntegerList(NEGATIVE_VALUE);
        validator.validate(positiveNumbers);
    }
    private void initializeRule() {
        validator = new NegativeNumberSearcher();
    }

    private List<Integer> generateIntegerList(int num) {
        List<Integer> nums = new LinkedList<Integer>();
        nums.add(num);
        return nums;
    }
}