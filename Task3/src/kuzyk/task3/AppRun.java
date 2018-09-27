package kuzyk.task3;

import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

import kuzyk.task3.assistant.LongReport;
import kuzyk.task3.assistant.ShortReport;
import kuzyk.task3.assistant.Source;
import kuzyk.task3.type.Student;

/**
 * The type App run.
 */
public class AppRun {

    /**
     * Start app.
     *
     * @param arg         the arg - arguments (0-4)
     * @param currentTime the current time time when start programm
     */
    public static void startApp(String arg, Calendar currentTime) {

        Student[] students = Source.initialize(currentTime);

        Locale.setDefault(new Locale("en", "EN"));
        Locale localeEN = new Locale("en", "EN");
        ResourceBundle rbEN = ResourceBundle.getBundle("kuzyk.task3.assistant.report", localeEN);
        Locale localeRU = new Locale("ru", "RU");
        ResourceBundle rbRU = ResourceBundle.getBundle("kuzyk.task3.assistant.report", localeRU);
//        Locale localeEN = new Locale("en", "EN");
//        ResourceBundle rbRU = ResourceBundle.getBundle("kuzyk.task3.assistant.report",localeRU);

        switch (arg) {

            case "0":
                ShortReport.printShortReport(students, currentTime, rbRU);
                break;
            case "":
                ShortReport.printShortReport(students, currentTime, rbRU);
                break;
            default:
                LongReport.printLongReport(students, currentTime, rbEN);
                break;

        }
    }
}
