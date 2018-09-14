package kuzyk.task3.type;

/**
 * The type Course.
 */
public class Course {

    private String nameCourse;
    private int durationHours;

    /**
     * Instantiates a new Course.
     *
     * @param nameCourse    the name course
     * @param durationHours the duration hours
     */
    public Course(String nameCourse, int durationHours) {
        this.nameCourse = nameCourse;
        this.durationHours = durationHours;
    }

    /**
     * Gets name course.
     *
     * @return the name course
     */
    public String getNameCourse() {
        return nameCourse;
    }

    /**
     * Sets name course.
     *
     * @param nameCourse the name course
     */
    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    /**
     * Gets duration hours.
     *
     * @return the duration hours
     */
    public int getDurationHours() {
        return durationHours;
    }

    /**
     * Sets duration hours.
     *
     * @param durationHours the duration hours
     */
    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    @Override
    public String toString() {
        return  "Course [nameCourse=" + nameCourse + ", durationHours=" + durationHours + "]";
    }
}
