package user;

import java.util.Objects;

public class Task {
    public String title;
    public String details;
    public String date;
    public boolean isCompleted;
    public int rand;

    public Task(String title, String details, String date, boolean isCompleted) {
        this.title = title;
        this.details = details;
        this.date = date;
        this.isCompleted = isCompleted;
//        Random ran = new Random();
//        rand = ran.nextInt(0, 999999999);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return isCompleted == task.isCompleted  && Objects.equals(title, task.title) && Objects.equals(details, task.details) && Objects.equals(date, task.date);
    }
}
