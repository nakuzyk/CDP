package kuzyk.Calculator;

/**
 * The type Less than validation rule.
 */
public class LessThanValidationRule implements NumberValidator.ValidationRule {
    private final int value;

    /**
     * Instantiates a new Less than validation rule.
     *
     * @param value the value
     */
    LessThanValidationRule(int value) {
        this.value = value;
    }

    @Override
    public boolean isValid(Integer number) {
        return number < value;
    }
}
