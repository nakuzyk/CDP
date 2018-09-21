import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Multiplication implements Operation {

    final static Logger logger = LogManager.getLogger(Multiplication.class);
    @Override
    public double calculateResult(double left, double right) {
        logger.info("result: " + left * right);
        logger.debug("mult method invoked: " + left + " * " + right);
        return left * right;
    }
}
