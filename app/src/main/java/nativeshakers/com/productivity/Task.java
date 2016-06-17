package nativeshakers.com.productivity;

import java.util.HashMap;

/**
 * Created by earlybirdcamp on 6/14/16.
 */
public class Task {
<<<<<<< HEAD
    String title;
    String time;
    String category;
    boolean completed;

    public enum Category {
        SCHOOLWORK, HOUSEWORK, PERSONAL, OTHER
    }

    public Task(String title, String category, String time) {
        this.title = title;
        this.category = category;
        this.time= time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
=======
    private String title, category, time;

    public Task() {
    }

    public Task(String title, String category, String time) {
        this.title = title;
>>>>>>> master
        this.category = category;
        this.time= time;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
