package tools;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Date {
    private static String day;
    private static String date;
    private static String time;

    private static LocalDate dayObj=LocalDate.now();
    private static LocalDateTime dateObj=LocalDateTime.now();
    private static LocalTime timeObj=LocalTime.now();

    private static DateTimeFormatter DAY=DateTimeFormatter.ofPattern("E");
    private static DateTimeFormatter DATE=DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static DateTimeFormatter TIME=DateTimeFormatter.ofPattern("HH:mm:ss");

    private static void update() {
        day = dayObj.format(DAY);
        date = dateObj.format(DATE);
        time = timeObj.format(TIME);
    }

    public static String getDay() {
        update();
        return day;
    }

    public static  String getDate() {
        update();
        return date;
    }

    public static String getTime() {
        update();
        return time;
    }
}
