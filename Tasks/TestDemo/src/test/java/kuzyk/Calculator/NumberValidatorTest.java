package kuzyk.Calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * The type Number validator test.
 */
public class NumberValidatorTest {
    private NumberValidator numberValidator;
    private NumberValidator.ValidationRule fakeValidationRuleDiscardTwo;
    private NumberValidator.ValidationRule fakeValidationRuleDiscardFour;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        fakeValidationRuleDiscardTwo = new NumberValidator.ValidationRule() {
            @Override
            public boolean isValid(Integer number) {
                return !number.equals(2);
            }
        };
        fakeValidationRuleDiscardFour = new NumberValidator.ValidationRule() {
            @Override
            public boolean isValid(Integer number) {
                return !number.equals(4);
            }
        };
        List<NumberValidator.ValidationRule> rules = new ArrayList<NumberValidator.ValidationRule>();
        rules.add(fakeValidationRuleDiscardFour);
        rules.add(fakeValidationRuleDiscardTwo);
        numberValidator = new NumberValidator(rules);
    }

    /**
     * Should not remove any number.
     */
    @Test
    public void shouldNotRemoveAnyNumber() {
        List<Integer> numbers = generateNumbersList(1, 3, 6, 7, 0);
        List<Integer> result = numberValidator.removeNotValidNumbers(numbers);
        assertEquals(numbers, result);
    }

    /**
     * Should remove two and four.
     */
    @Test
    public void shouldRemoveTwoAndFour() {
        List<Integer> numbers = generateNumbersList(1, 2, 3, 4);
        List<Integer> result = numberValidator.removeNotValidNumbers(numbers);
        Integer intObj = 2;
        Integer anotherIntObj = 4;
        numbers.remove(intObj);
        numbers.remove(anotherIntObj);
        assertEquals(numbers, result);
    }

    private List<Integer> generateNumbersList(Integer... numbers) {
        List<Integer> result = new LinkedList<Integer>();
        for (Integer num : numbers) {
            result.add(num);
        }
        return result;
    }
}