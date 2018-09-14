package kuzyk.task3.type;

import java.util.Calendar;

import  kuzyk.task3.assistant.Time;

/**
 * The type Student.
 */
public class Student {

    private String nameStudent;
    private Curriculum curriculumStudent;
    private Calendar startDate;
    private Calendar endDate;

    /**
     * Instantiates a new Student.
     *
     * @param nameStudent       the name student
     * @param curriculumStudent the curriculum student
     * @param startDate         the start date to learn curriculum
     */
    public Student(String nameStudent, Curriculum curriculumStudent, Calendar startDate) {
        this.nameStudent = nameStudent;
        this.curriculumStudent = curriculumStudent;
        this.startDate = Time.getStartDate(startDate);
        this.endDate = Time.getEndDate(startDate, curriculumStudent);
    }

    /**
     * Gets name student.
     *
     * @return the name student
     */
    public String getNameStudent() {
        return nameStudent;
    }

    /**
     * Sets name student.
     *
     * @param nameStudent the name student
     */
    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    /**
     * Gets curriculum student.
     *
     * @return the curriculum student
     */
    public Curriculum getCurriculumStudent() {
        return curriculumStudent;
    }

    /**
     * Sets curriculum student.
     *
     * @param curriculumStudent the curriculum student
     */
    public void setCurriculumStudent(Curriculum curriculumStudent) {
        this.curriculumStudent = curriculumStudent;
    }

    /**
     * Gets start date.
     *
     * @return the start date
     */
    public Calendar getStartDate() {
        return startDate;
    }

    /**
     * Gets end date.
     *
     * @return the end date
     */
    public Calendar getEndDate() {
        return endDate;
    }

    /**
     * Sets start date.
     *
     * @param startDate the start date
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return  "Student [nameStudent=" + nameStudent + ", curriculumStudent=" + curriculumStudent.getNameCurriculum()
                + ", startDate=" + startDate.get(Calendar.DAY_OF_YEAR)
                + ", endDate=" + endDate.get(Calendar.DAY_OF_YEAR) + "]";
    }
}


