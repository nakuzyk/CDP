import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger(Main.class);
        Scanner sc = new Scanner(System.in);
        System.out.printf("Select the logging level\ne - Error\nw - Warn\ni - Info\nd - Debug");
        char c = sc.next().charAt(0);
        switch (c) {
            case 'e':
                Configurator.setRootLevel(Level.ERROR);
                break;
            case 'w':
                Configurator.setRootLevel(Level.WARN);
                break;
            case 'i':
                Configurator.setRootLevel(Level.INFO);
                break;
            case 'd':
                Configurator.setRootLevel(Level.DEBUG);
                break;
            default:
                Configurator.setRootLevel(Level.ALL);
        }

        try {

            Calculator2.start();
            logger.info("Calculator the start" );
        }
        catch(InputMismatchException e){
            logger.error(e.getMessage(), e);
            System.out.println("Invalid input");
        }
        catch(Exception e){
            logger.error(e.getMessage(), e);
            System.out.println("Something went wrong");
        }

    }
}
