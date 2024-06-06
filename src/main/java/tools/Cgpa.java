package tools;

import courses.Course;


public class Cgpa {
    public static double gradeToPoint(String grade) {
        grade = grade.toUpperCase();
        switch (grade) {
            case "A":
                return 4.0;
            case "A-":
                return 3.7;
            case "B+":
                return 3.3;
            case "B":
                return 3.0;
            case "B-":
                return 2.7;
            case "C+":
                return 2.3;
            case "C":
                return 2.0;
            case "C-":
                return 1.7;
            case "D+":
                return 1.3;
            case "D":
                return 1;

            default:
                return 0;
        }
    }

    public static double calculate(Course[] courses) {
        double credits = 0;
        double points = 0;
        for (Course course : courses) {
            if (course != null) {
                credits += course.getCredit();
                points += course.getCredit() * gradeToPoint(course.getGrade());
            }
        }
        double cgpa = points / credits;
        return Math.round(cgpa * 100.0) / 100.0;
    }

    public static boolean isValidGrade(String input) {
        input = input.toUpperCase();
        String[] grades = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F"};
        for (String grade : grades) {
            if (grade.equals(input)) {
                return true;
            }
        }
        return false;
    }
}