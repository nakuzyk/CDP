package kuzyk.task3.type;

/**
 * The type Curriculum.
 */
public class Curriculum {

    private String nameCurriculum;
    private Course coursesInCurriculum[];
    private int sumHours;

    /**
     * Instantiates a new Curriculum.
     *
     * @param nameCurriculum the name curriculum
     * @param courses        the courses which must contain in current Curriculum
     */
    public Curriculum(String nameCurriculum, Course... courses) {
        this.nameCurriculum = nameCurriculum;
        this.sumHours = 0;
        int i = courses.length;
        this.coursesInCurriculum = new Course[i];
        for (int j = 0; j < i; j++) {
            this.coursesInCurriculum[j] = new Course(courses[j].getNameCourse(), courses[j].getDurationHours());
            this.sumHours = this.sumHours + courses[j].getDurationHours();
        }
    }

    /**
     * Gets sum hours.
     *
     * @return the sum hours
     */
    public int getSumHours() {
        return sumHours;
    }

    /**
     * Gets name curriculum.
     *
     * @return the name curriculum
     */
    public String getNameCurriculum() {
        return nameCurriculum;
    }

    /**
     * Sets name curriculum.
     *
     * @param nameCurriculum the name curriculum
     */
    public void setNameCurriculum(String nameCurriculum) {
        this.nameCurriculum = nameCurriculum;
    }

    /**
     * Get courses in curriculum course [ ].
     *
     * @return the course [ ]
     */
    public Course[] getCoursesInCurriculum() {
        return coursesInCurriculum;
    }
}
