import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Division implements Operation {

    final static Logger logger = LogManager.getLogger(Division.class);

    @Override
    public double calculateResult(double left, double right) {

        logger.info("result: " + left/right);
        logger.debug("divide method invoked: " + left + " / " + right);
        if (right == 0) {
            logger.warn("rigth = 0; exception may occur");
        }
        return left / right;
    }
}

