package courses;

public class Course {
    private String type;
    private String initial;
    private String title;
    private double credit;
    private String require;
    private String description;
    private String grade;

    public Course(String initial, double credit, String grade) {
        this.initial = initial;
        this.credit = credit;
        this.grade = grade;
    }

    public Course(String initial, String title, double credit) {
        this.initial = initial;
        this.title = title;
        this.credit = credit;
    }

    public Course(String initial, String title, double credit, String grade) {
        this.initial = initial;
        this.title = title;
        this.credit = credit;
        this.grade = grade;
    }

    public Course(String initial, String title, String grade) {
        this.initial = initial;
        this.title = title;
        this.grade = grade;
    }

    public Course(String initial, String title, double credit, String require, String decription) {
        this.initial = initial;
        this.title = title;
        this.credit = credit;
        this.require = require;
        this.description = decription;
    }

    public Course(String type, String initial, String title, double credit, String require, String decription) {
        this.type = type;
        this.initial = initial;
        this.title = title;
        this.credit = credit;
        this.require = require;
        this.description = decription;
    }

    public Course(String type, String initial, String title, double credit, String grade, String require, String decription) {
        this.type = type;
        this.initial = initial;
        this.title = title;
        this.credit = credit;
        this.require = require;
        this.description = decription;
        this.grade = grade;
    }

    public String getType() {
        return type;
    }

    public String getInitial() {
        return initial;
    }

    public String getTitle() {
        return title;
    }

    public double getCredit() {
        return credit;
    }

    public String getRequire() {
        return require;
    }

    public String getDescription() {
        return description;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return ("Course Name: " + getTitle() + "\nInitial: " + getInitial() + "\nCourse Type: " + getType() + "\nCredit: " + getCredit() + "\nGrade: " + getGrade() + "\nPre-requisites: " + getRequire() + "\n\nDescription:\n" + getDescription());
    }
}
