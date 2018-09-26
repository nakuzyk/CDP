package kuzyk.task3.assistant;

import java.util.Calendar;
import java.util.GregorianCalendar;

import kuzyk.task3.StudentProgressReport;
import kuzyk.task3.type.Curriculum;
import kuzyk.task3.type.Student;

/**
 * The type Time. Class contain static methods for calculate time range
 */
public class Time {

    /** int Array contain holiday day in 2018 year */
    private static final int[] HOLIDAY = {1, 4, 5, 6, 7, 8, 53, 54, 67, 68, 123, 124, 130, 165, 309 };
    /** int Array contain holiday day in 2018 year */
    private static final int[] DAYOFF = { 37 };

    /**
     * Gets end date.
     *
     * @param startDate  the start date (when student start to learn curriculum
     * @param curriculum the curriculum
     * @return the end date ( when student must end curriculum)
     */
    static public Calendar getEndDate(Calendar startDate, Curriculum curriculum) {

        int amountWorkHours = curriculum.getSumHours();
        int currentHour = 0;
        Calendar tmpDate = (Calendar) startDate.clone();

        while (!(amountWorkHours == 0)) {
            tmpDate.add(Calendar.HOUR, 1);
            currentHour = tmpDate.get(Calendar.HOUR_OF_DAY);

            if ((currentHour > StudentProgressReport.STARTTIMEHOUR) && (currentHour <= StudentProgressReport.ENDTIMEHOUR) && (!Time.isHoliday(tmpDate))) {
                amountWorkHours--;
            }
        }
        return tmpDate;
    }

    /**
     * If date not start in work days and in work hours,
     * method find nearest work time.
     *
     * @param startDate the start date
     * @return the start date (only date in work time)
     */
    static public Calendar getStartDate(Calendar startDate) {

        Calendar tmpDate = (Calendar) startDate.clone();
        int currentHour = tmpDate.get(Calendar.HOUR_OF_DAY);

        while ((currentHour < StudentProgressReport.STARTTIMEHOUR) || (currentHour >= StudentProgressReport.ENDTIMEHOUR)
                || Time.isHoliday(tmpDate)) {
            tmpDate.add(Calendar.HOUR, 1);
            currentHour = tmpDate.get(Calendar.HOUR_OF_DAY);
        }
        return tmpDate;
    }

    /**
     * Method return count of work hours between two date - end date and current date.
     *
     * @param student     the student
     * @param currentTime the current time
     * @return the diff work time in hours
     */
    static public int getDiffWorkTimeInHours(Student student, Calendar currentTime) {

        Calendar tmpDate1 = new GregorianCalendar();
        Calendar tmpDate2 = new GregorianCalendar();

        if (timeProgrammPassed(student,currentTime)) {
            tmpDate1 = (Calendar) student.getEndDate().clone();
            tmpDate2 = (Calendar) currentTime.clone();
        } else {
            tmpDate1 = (Calendar) currentTime.clone();
            tmpDate2 = (Calendar) student.getEndDate().clone();
        }
        int workHoursBetween = 0;
        int currentHour = 0;

        while (tmpDate1.before(tmpDate2)) {

            tmpDate1.add(Calendar.HOUR, 1);
            currentHour = tmpDate1.get(Calendar.HOUR_OF_DAY);

            if ((currentHour > StudentProgressReport.STARTTIMEHOUR)
                    && (currentHour <= StudentProgressReport.ENDTIMEHOUR)
                    && (!Time.isHoliday(tmpDate1))) {
                workHoursBetween++;
            }
        }
        return workHoursBetween;
    }

    /**
     * Method return true if currenttime more than time of learning.
     *
     * @param student     the student
     * @param currentTime the current time
     * @return the boolean
     */
    static public boolean timeProgrammPassed(Student student, Calendar currentTime) {

        boolean timeProgrammPased = false;

        long endDateStudentMS =  student.getEndDate().getTimeInMillis();
        long currentDateMS = currentTime.getTimeInMillis();

        if (currentDateMS > endDateStudentMS) {
            timeProgrammPased = true;
        }
        return  timeProgrammPased;
    }

    static private boolean isHoliday(Calendar day) {

        for (int i = 0; i < Time.HOLIDAY.length; i++) {
            if (day.get(Calendar.DAY_OF_YEAR) == HOLIDAY[i]) {
                return false;
            }
        }
        for (int i = 0; i < Time.DAYOFF.length; i++) {
            if (day.get(Calendar.DAY_OF_YEAR) == DAYOFF[i]) {
                return false;
            }
        }
        if ((day.get(Calendar.DAY_OF_WEEK) == 7) || (day.get(Calendar.DAY_OF_WEEK) ==1)) {
            return true;
        }
        return false;
    }

}
