package kuzyk;

/**
 * The type Substraction.
 */
public class Substraction implements Operation {

    @Override
    public double calculateResult(double left, double right){
        return left - right;
    }
}
