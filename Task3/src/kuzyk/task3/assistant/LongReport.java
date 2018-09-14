package kuzyk.task3.assistant;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.ResourceBundle;

import kuzyk.task3.StudentProgressReport;
import kuzyk.task3.type.Student;
import kuzyk.task3.type.Course;

/**
 * The type Long report.
 */
public class LongReport {

    private static int MIN_WIDE_REPORT = 32;
    private static int LENGTH_WORD_CURRENT_DATE = 15;
    private static int LENGTH_HOURSES_COURSE = 4;
    private static int LENGTH_NUMBER_COURSE = 3;

    /**
     * Print long report.
     *
     * @param students    the students
     * @param currentTime the current time
     * @param rb          the Resource Bundle
     */
    public static void printLongReport(Student[] students, Calendar currentTime, ResourceBundle rb) {

        int wideReport = getWideReport(students);
        String line = getLine(wideReport);

        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);

        for (Student currentStudent : students) {

            int minWideSecondColum = wideReport - LENGTH_WORD_CURRENT_DATE;
            String lineFormater = "%-" + LENGTH_WORD_CURRENT_DATE + "s %" + minWideSecondColum + "s\n";

            fmt.format(line + "\n");
            fmt.format(lineFormater, rb.getString("student"), currentStudent.getNameStudent());
            fmt.format(lineFormater, rb.getString("CURRICULUM"), currentStudent.getCurriculumStudent().getNameCurriculum());
            fmt.format(lineFormater, rb.getString("startdate"), getDateToString(currentStudent.getStartDate()));

            fmt.format(line + "\n");

            int i = 1;
            lineFormater = "%-" + (wideReport - LENGTH_HOURSES_COURSE - LENGTH_NUMBER_COURSE) + "s %"
                    + LENGTH_HOURSES_COURSE + "s\n";

            for (Course currentCourse : currentStudent.getCurriculumStudent().getCoursesInCurriculum()) {
                fmt.format(i + ". " + lineFormater, currentCourse.getNameCourse(), currentCourse.getDurationHours());
                i++;
            }
            fmt.format(line + "\n");
            fmt.format(rb.getString("TOTAL") + currentStudent.getCurriculumStudent().getSumHours() + "\n");

            if (Time.timeProgrammPassed(currentStudent, currentTime)) {
                fmt.format(rb.getString("completeL"));
            } else {
                fmt.format(rb.getString("notcompleteL"));
            }

            int workhours = Time.getDiffWorkTimeInHours(currentStudent, currentTime);

            int days = workhours / (StudentProgressReport.ENDTIMEHOUR - StudentProgressReport.STARTTIMEHOUR);
            int hours = workhours % (StudentProgressReport.ENDTIMEHOUR - StudentProgressReport.STARTTIMEHOUR);

            fmt.format(" " + days + rb.getString("days") + ", "+ hours + rb. getString("hours") + "\n\n");

            System.out.println(sb.toString());
            sb.setLength(0);
        }
        fmt.close();
    }

    private static  String getDateToString(Calendar time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String tmp = dateFormat.format(time.getTime());
        return tmp;
    }

    private static int getWideReport(Student[] students) {
        int wideReport = MIN_WIDE_REPORT;
        int tmpWideReport = 0;

        for (Student currentStudent : students) {

            int lengthNameStudent = currentStudent.getNameStudent().length();
            int lengthCurriculumStudent = currentStudent.getCurriculumStudent().getNameCurriculum().length();

            if (lengthNameStudent > lengthCurriculumStudent) {
                tmpWideReport = lengthNameStudent;
            } else {
                tmpWideReport = lengthCurriculumStudent;
            }

            if ((tmpWideReport + LENGTH_WORD_CURRENT_DATE) > wideReport) {
                wideReport = tmpWideReport + LENGTH_WORD_CURRENT_DATE;
            }
        }
        return wideReport;
    }

    private static String getLine(int wideReport) {

        StringBuilder line = new StringBuilder(wideReport);
        for (int i = 0; i <=wideReport; i++) {
            line.append("-");
        }
        return line.toString();
    }
}
