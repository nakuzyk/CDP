package kuzyk.Calculator;

import static org.junit.Assert.assertEquals;

import kuzyk.exception.NegativeNumbersException;
import kuzyk.exception.ValidatorException;
import org.junit.Before;
import org.junit.Test;

/**
 * The type String calculator test.
 */
public class StringCalculatorTest {

    private static final String EMPTY_SET_OF_NUMBERS = "";
    private static final String ONE_NUMBER_ONE_DIGIT_STRING = "1";
    private static final String ONE_NUMBER_STRING = "11";
    private static final String NUMBER_STRING_SUM_ELEVEN = "1,2,3,5";
    private static final String NUMBER_STRING_SUM_SIX_SEPARATOR_NEW_LINE = "1\n2,3";
    private static final String NUMBERS_STRING_SUM_SEVEN_DIFFERENT_SEPARATOR = "//;\n1;2p4";
    private static final String NUMBERS_STRING_WITH_NEGATIVE_VALUES = "//;\n1;2p-4";
    private static final String NUMBERS_STRING_SUM_TWO_WITH_MORE_THAN_THOUSAND = "2,1000";
    private static final String NUMBERS_STRING_SUM_SEVEN_DIFFERENT_SEPARATORS_CONSECUTIVES = "[*][%]\\n1*2%4";

    private StringCalculator stringCalculator;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    /**
     * Should return zero if the argument is empty.
     *
     * @throws ValidatorException the validator exception
     */
    @Test
    public void shouldReturnZeroIfTheArgumentIsEmpty() throws ValidatorException {
        int result = stringCalculator.add(EMPTY_SET_OF_NUMBERS);

        assertEquals(0, result);
    }

    /**
     * Should return the same value if the argument contains only one number with one digit.
     *
     * @throws ValidatorException the validator exception
     */
    @Test
    public void shouldReturnTheSameValueIfTheArgumentContainsOnlyOneNumberWithOneDigit() throws ValidatorException {
        int result = stringCalculator.add(ONE_NUMBER_ONE_DIGIT_STRING);

        int expectedResult = Integer.parseInt(ONE_NUMBER_ONE_DIGIT_STRING);
        assertEquals(expectedResult, result);
    }

    /**
     * Should return the same value id the argument contains only one number with more than one digit.
     *
     * @throws ValidatorException the validator exception
     */
    @Test
    public void shouldReturnTheSameValueIdTheArgumentContainsOnlyOneNumberWithMoreThanOneDigit() throws ValidatorException {
        int result = stringCalculator.add(ONE_NUMBER_STRING);

        int expectedResult = Integer.parseInt(ONE_NUMBER_STRING);
        assertEquals(expectedResult, result);
    }

    /**
     * Should return the sum of an unknown amount of numbers.
     *
     * @throws ValidatorException the validator exception
     */
    @Test
    public void shouldReturnTheSumOfAnUnknownAmountOfNumbers() throws ValidatorException {
        int result = stringCalculator.add(NUMBER_STRING_SUM_ELEVEN);

        assertEquals(11, result);
    }

    /**
     * Should return the sum of an unknown amount of numbers separated with new line characters.
     *
     * @throws ValidatorException the validator exception
     */
    @Test
    public void shouldReturnTheSumOfAnUnknownAmountOfNumbersSeparatedWithNewLineCharacters() throws ValidatorException {
        int result = stringCalculator.add(NUMBER_STRING_SUM_SIX_SEPARATOR_NEW_LINE);

        assertEquals(6, result);
    }

    /**
     * Should return the sum of an unknown amout of numbers seprated with different delimiters.
     *
     * @throws ValidatorException the validator exception
     */
    @Test
    public void shouldReturnTheSumOfAnUnknownAmoutOfNumbersSepratedWithDifferentDelimiters() throws ValidatorException {
        int result = stringCalculator.add(NUMBERS_STRING_SUM_SEVEN_DIFFERENT_SEPARATOR);

        assertEquals(7,result);
    }

    /**
     * Should throw negative numbers not supported exception.
     *
     * @throws ValidatorException the validator exception
     */
    @Test(expected = NegativeNumbersException.class)
    public void  shouldThrowNegativeNumbersNotSupportedException() throws ValidatorException {
        stringCalculator.add(NUMBERS_STRING_WITH_NEGATIVE_VALUES);
    }

    /**
     * Should ignore numbers grather than one thousand.
     *
     * @throws ValidatorException the validator exception
     */
    @Test
    public void shouldIgnoreNumbersGratherThanOneThousand() throws ValidatorException {
        int result = stringCalculator.add(NUMBERS_STRING_SUM_TWO_WITH_MORE_THAN_THOUSAND);

        assertEquals(2,result);
    }

    /**
     * Should allow different delimiters with more than one char and more than one consecutive.
     *
     * @throws ValidatorException the validator exception
     */
    @Test
    public void shouldAllowDifferentDelimitersWithMoreThanOneCharAndMoreThanOneConsecutive() throws ValidatorException {
        int result = stringCalculator.add(NUMBERS_STRING_SUM_SEVEN_DIFFERENT_SEPARATORS_CONSECUTIVES);

        assertEquals(7,result);
    }

}