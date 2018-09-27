import java.util.InputMismatchException;


/**
 * The type No operation found.
 */
public class NoOperationFound implements Operation {
    private char sign;

    /**
     * Instantiates a new No operation found.
     *
     * @param sign the sign
     */
    NoOperationFound(char sign){
        this.sign = sign;
    }

    @Override
    public double calculateResult(double left, double right) {
        throw new InputMismatchException("Invalid operator sign: " + sign);
    }
}
