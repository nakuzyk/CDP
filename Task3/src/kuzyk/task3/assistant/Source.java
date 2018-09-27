package kuzyk.task3.assistant;

import java.util.Calendar;
import java.util.GregorianCalendar;

import kuzyk.task3.StudentProgressReport;
import kuzyk.task3.type.Course;
import kuzyk.task3.type.Curriculum;
import kuzyk.task3.type.Student;

/**
 * The type Source.
 */
public class Source {

    /**
     * Initialize student [ ].
     *
     * @param currentTime the current time
     * @return the student [ ]
     */
    public static Student[] initialize(Calendar currentTime) {

        Course courses[] = new Course[] { new Course("Технология Java Servlets", 16),
        new Course("Struts Framework", 24), new Course("Обзор технологий Java", 8),
        new Course("Библиотека JFC/Swing", 16), new Course("Технология JDBC", 16)};

        Curriculum j2eeDeveloper = new Curriculum("J2EE Developer", courses[0], courses[1]);
        Curriculum javaDeveloper = new Curriculum("Java Developer", courses[2], courses[3], courses[4]);

        currentTime.set(Calendar.MILLISECOND, 0);
        currentTime.set(Calendar.SECOND, 0);
        currentTime.set(Calendar.MINUTE, 0);

        Calendar startTime1 = new GregorianCalendar();
        Calendar startTime2 = new GregorianCalendar();
        startTime1 = (Calendar) currentTime.clone();
        startTime2 = (Calendar) currentTime.clone();

        startTime1.add(Calendar.DATE, StudentProgressReport.START_DATE1);
        startTime2.add(Calendar.DATE,StudentProgressReport.START_DATE2);

        Student students[] = new Student[] { new Student("Ivanov Ivan", javaDeveloper, startTime1),
                                            new Student("Petrov Petr", j2eeDeveloper, startTime2)};
        return students;
    }
}
