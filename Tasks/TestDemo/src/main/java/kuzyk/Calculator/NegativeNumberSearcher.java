package kuzyk.Calculator;

import kuzyk.exception.ValidatorException;
import kuzyk.exception.NegativeNumbersException;

import java.util.LinkedList;
import java.util.List;

/**
 * The type Negative number searcher.
 */
class NegativeNumberSearcher implements ForbiddenNumberSearcher {

    @Override
    public void validate(final List<Integer> numbers) throws ValidatorException {
        List<Integer> negativeNumbers = getNegativeNumbers(numbers);
        if (negativeNumbers.size() > 0) {
            throw new NegativeNumbersException(negativeNumbers);
        }
    }

    private List<Integer> getNegativeNumbers(List<Integer> numbers) {
        List<Integer> negativeNumbers = new LinkedList<Integer>();
        for (Integer num : numbers) {
            if (num < 0) {
                negativeNumbers.add(num);
            }
        }
        return negativeNumbers;
    }

}

