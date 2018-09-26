package kuzyk.Calculator;

import kuzyk.exception.ValidatorException;

import java.util.List;

/**
 * The interface Forbidden number searcher.
 */
public interface ForbiddenNumberSearcher {

    /**
     * Validate.
     *
     * @param numbers the numbers
     * @throws ValidatorException the validator exception
     */
    void validate(List<Integer> numbers) throws ValidatorException;
}
