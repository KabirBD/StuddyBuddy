package courses;

public class Course {
    private String type;
    private String initial;
    private String title;
    private double credit;
    private String require;
    private String decription;
    private double grade;

    public Course(String initial, String title, double credit, String require, String decription) {

        this.initial = initial;
        this.title = title;
        this.credit = credit;
        this.require = require;
        this.decription = decription;
    }

    public Course(String type, String initial, String title, double credit, String require, String decription) {
        this.type = type;
        this.initial = initial;
        this.title = title;
        this.credit = credit;
        this.require = require;
        this.decription = decription;
    }

    public Course(String type, String initial, String title, double credit, String require, String decription, double grade) {
        this.type = type;
        this.initial = initial;
        this.title = title;
        this.credit = credit;
        this.require = require;
        this.decription = decription;
        this.grade = grade;
    }

    public String getType() {return type;}

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

    public String getDecription() {
        return decription;
    }

    public double getGrade() { return grade; }

    @Override
    public String toString() {
        return ("Course Name: "+getTitle()+"\nInitial: "+getInitial()+"\nCourse Type: "+getType()+"\nCredit: "+getCredit()+"\nPre-requisites: "+getRequire()+"\n\nDescription:\n"+getDecription());
    }

// other methods might me added later
}
