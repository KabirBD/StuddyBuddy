package user;

import courses.Course;

public class UserData {
    private int semester;
    private String trail;
    private Course[] CompletedCourse;
    private Course[] EnrolledCourse;

    public UserData(int semester, String trail, Course[] completedCourse, Course[] enrolledCourse) {
        this.semester = semester;
        this.trail = trail;
        CompletedCourse = completedCourse;
        EnrolledCourse = enrolledCourse;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getTrail() {
        return trail;
    }

    public void setTrail(String trail) {
        this.trail = trail;
    }

    public Course[] getCompletedCourse() {
        return CompletedCourse;
    }

    public void setCompletedCourse(Course[] completedCourse) {
        CompletedCourse = completedCourse;
    }

    public Course[] getEnrolledCourse() {
        return EnrolledCourse;
    }

    public void setEnrolledCourse(Course[] enrolledCourse) {
        EnrolledCourse = enrolledCourse;
    }
}
