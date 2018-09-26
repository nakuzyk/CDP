package kuzyk.task3;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * The type Student progress report.
 *
 * @author Anastasiia_Kuzyk@epam.com
 */
public class StudentProgressReport {

    /**
     * In this hour start work time.
     */
    public static final int STARTTIMEHOUR = 10;
    /**
     * In this hour end work time.
     */
    public static final int ENDTIMEHOUR = 18;

    /**
     * How many days sum to current time for calculate Start time learning
     * Student1
     */
    public static final int START_DATE1 = -5;
    /**
     * How many days sum to current time for calculate Start time learning
     * Student2
     */
    public static final int START_DATE2 = -10;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     *             - 0 show Short Report
     *             - without parameters show Short Report
     *             - another show Long Report
     */
    public static void main(String[] args) {
        Calendar currentTime = new GregorianCalendar();
        if (args.length > 0) {
            AppRun.startApp(args[0],currentTime);
        } else {
            AppRun.startApp("", currentTime);
        }
    }


}
