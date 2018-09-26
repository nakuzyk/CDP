package kuzyk.exception;

import java.util.List;

/**
 * The type Negative numbers exception.
 */
public class NegativeNumbersException extends ValidatorException {

    private static final String EXCEPTION_NAME = "NegativeNumbersException";

    private List<Integer> negativeNumbers;

    /**
     * Instantiates a new Negative numbers exception.
     *
     * @param negativeNumbers the negative numbers
     */
    public NegativeNumbersException(List<Integer> negativeNumbers) {
        this.negativeNumbers = negativeNumbers;
    }

    /**
     * Gets exception name.
     *
     * @return the exception name
     */
    public static String getExceptionName() {
        return EXCEPTION_NAME;
    }

    @Override
    public String getMessage() {
        return EXCEPTION_NAME + negativeNumbers.toString();
    }
}
