package kuzyk.Calculator;

import java.util.List;
import java.util.Collection;
import  java.util.LinkedList;

/**
 * The type Number validator.
 */
public class NumberValidator {

    private Collection<ValidationRule> rules;

    /**
     * Instantiates a new Number validator.
     *
     * @param rules the rules
     */
    NumberValidator(Collection<ValidationRule> rules) {
        this.rules = rules;
    }

    /**
     * Remove not valid numbers list.
     *
     * @param numbers the numbers
     * @return the list
     */
    public List<Integer> removeNotValidNumbers(List<Integer> numbers) {
        List<Integer> result = new LinkedList<Integer>();
        for (Integer num : numbers) {
            if (isValid(num)) {
                result.add(num);
            }
        }
        return result;
    }

    private boolean isValid(Integer num) {
        boolean res = true;
        for (ValidationRule rule : rules) {
            if (!rule.isValid(num)) {
                res = false;
                break;
            }
        }
        return res;
    }

    /**
     * The interface Validation rule.
     */
    interface ValidationRule {
        /**
         * Is valid boolean.
         *
         * @param number the number
         * @return the boolean
         */
        boolean isValid(Integer number);
    }
}
