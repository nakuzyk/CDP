package kuzyk.task3.assistant;

import java.util.Calendar;
import java.util.ResourceBundle;

import kuzyk.task3.StudentProgressReport;
import kuzyk.task3.type.Student;

/**
 * The type Short report.
 */
public class ShortReport {

    /**
     * Print short report.
     *
     * @param students    the students
     * @param currentTime the current time
     * @param rb          the Resource Bundle
     */
    public static void printShortReport(Student [] students, Calendar currentTime, ResourceBundle rb) {

        for (Student currentStudent : students) {

            System.out.print(currentStudent.getNameStudent() + " (" + currentStudent.getCurriculumStudent().getNameCurriculum() + ") ");

            if (Time.timeProgrammPassed(currentStudent, currentTime)) {
                System.out.print(rb.getString("complete"));
            } else {
                System.out.print(rb.getString("notcomplete"));
            }
            int workhours = Time.getDiffWorkTimeInHours(currentStudent,currentTime);

            int days = workhours / (StudentProgressReport.ENDTIMEHOUR - StudentProgressReport.STARTTIMEHOUR);
            int hours = workhours % (StudentProgressReport.ENDTIMEHOUR - StudentProgressReport.STARTTIMEHOUR);

            System.out.println(days + rb.getString("days") + hours + rb.getString("hours"));
        }
    }
}
