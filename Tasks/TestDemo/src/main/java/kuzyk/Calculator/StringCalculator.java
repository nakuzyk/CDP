package kuzyk.Calculator;

import kuzyk.exception.ValidatorException;


import java.util.List;
import java.util.LinkedList;
import java.util.Collection;

/**
 * The type String calculator.
 */
public class StringCalculator {

    private static final int VALIDATION_TOP_NUMBER = 1000;

    private NumberExtractor numberExtractor;
    private ForbiddenNumberSearcher negativeNumberSearcher;
    private NumberValidator numberValidator;

    /**
     * Instantiates a new String calculator.
     */
    public StringCalculator() {
        initializeNumberExtractor();
        initializeNegativeNumberValidator();
        initializeNumbersValidator();
    }

    /**
     * Parse an string and sum all the numeric values removing the non numeric characters.
     *
     * @param numbers to analyze and sum.
     * @return the sum value with some restrictions described in the project documentation.
     * @throws ValidatorException the validator exception
     */
    public int add(final String numbers) throws ValidatorException {
        List<Integer> numbersList = extractNumbers(numbers);
        checkIfThereAreNegativeNumbers(numbersList);
        numbersList = validateNumbers(numbersList);
        return sumNumbers(numbersList);
    }

    private void initializeNumbersValidator() {
        NumberValidator.ValidationRule rule = new LessThanValidationRule(VALIDATION_TOP_NUMBER);
        Collection<NumberValidator.ValidationRule> rules = new LinkedList<NumberValidator.ValidationRule>();
        rules.add(rule);
        this.numberValidator = new NumberValidator(rules);
    }

    private void initializeNegativeNumberValidator() {
        this.negativeNumberSearcher = new NegativeNumberSearcher();
    }

    private void initializeNumberExtractor() {
        this.numberExtractor = new NumberExtractor();
    }


    private List<Integer> extractNumbers(final String numbers) {
        return numberExtractor.extract(numbers);
    }

    private void checkIfThereAreNegativeNumbers(final List<Integer> numbersList) throws ValidatorException {
        negativeNumberSearcher.validate(numbersList);
    }

    private List<Integer> validateNumbers(final List<Integer> numbersList) {
        return numberValidator.removeNotValidNumbers(numbersList);
    }

    private int sumNumbers(List<Integer> numberList) {
        int sum = 0;
        for (Integer num : numberList) {
            sum += num;
        }
        return sum;
    }

}