package kuzyk.Calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import  java.util.regex.Pattern;

/**
 * The type Number extractor.
 */
public class NumberExtractor {

    private static final String ONE_DIGIT_OR_MORE_REG_EX = "-?\\d+";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(ONE_DIGIT_OR_MORE_REG_EX);

    /**
     * Extract list.
     *
     * @param stringToAnalyze the string to analyze
     * @return the list
     */
    public List<Integer> extract(final String stringToAnalyze) {
        List<Integer> result = new LinkedList<Integer>();
        if (stringToAnalyze != null && !stringToAnalyze.isEmpty()) {
            result = getNumbersUsingRegEx(stringToAnalyze);
        }
        return result;
    }

    private List<Integer> getNumbersUsingRegEx(String string) {
        Matcher matcher = NUMBER_PATTERN.matcher(string);
        return extractNumbersFromMatches(matcher);
    }

    private List<Integer> extractNumbersFromMatches(Matcher matcher) {
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            numbers.add(number);
        }
        return numbers;
    }
}
