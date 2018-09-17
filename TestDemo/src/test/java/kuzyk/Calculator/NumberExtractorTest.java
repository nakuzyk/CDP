package kuzyk.Calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.LinkedList;

/**
 * The type Number extractor test.
 */
public class NumberExtractorTest {

    private static final String NO_NUMBERS = "qwer";
    private static final String NUMBERS_WITH_DIFFERENT_DELIMITERS = "\n| 1,2,3,pouusdf4%5%6";

    private NumberExtractor numberExtractor;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        initializeNumberExtractor();
    }

    /**
     * Should return an empty collection if the param is null.
     */
    @Test
    public void shouldReturnAnEmptyCollectionIfTheParamIsNull() {
        List<Integer> result = numberExtractor.extract(null);
        List<Integer> expectedResult = new LinkedList<Integer>();
        assertEquals(expectedResult, result);
    }

    /**
     * Should return an empty collection if the param is empty.
     */
    @Test
    public void shouldReturnAnEmptyCollectionIfTheParamIsEmpty() {
        List<Integer> result = numberExtractor.extract("");
        List<Integer> expectedResult = new LinkedList<Integer>();
        assertEquals(expectedResult, result);
    }

    /**
     * Should return an empty collection of numbers if there is no numbers inside the string.
     */
    @Test
    public void shouldReturnAnEmptyCollectionOfNumbersIfThereIsNoNumbersInsideTheString() {
        List<Integer> result = numberExtractor.extract(NO_NUMBERS);
        List<Integer> expectedResult = new LinkedList<Integer>();
        assertEquals(expectedResult, result);
    }

    /**
     * Should return a collection with the numbers extracted.
     */
    @Test
    public void shouldReturnACollectionWithTheNumbersExtracted() {
        List<Integer> result = numberExtractor.extract(NUMBERS_WITH_DIFFERENT_DELIMITERS);
        List<Integer> expectedResult = generateListOfNumbers(1,2,3,4,5,6);
        assertEquals(expectedResult, result);
    }

    private void initializeNumberExtractor() {
        numberExtractor = new NumberExtractor();
    }

    private List<Integer> generateListOfNumbers(Integer... nums) {
        List<Integer> result = new LinkedList<Integer>();
        for (Integer num : nums) {
            result.add(num);
        }
        return result;
    }

}