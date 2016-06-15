package nativeshakers.com.productivity;

import java.util.HashMap;

/**
 * Created by earlybirdcamp on 6/14/16.
 */
public class Task {
    String text;
    String category;

    public enum Category {
        SCHOOLWORK, HOUSEWORK, PERSONAL, OTHER
    }
    // Task t = new Task("Wash dishes",Task.CATEGORY);

    public Task() {
        this.text = "Not Set";
        this.category = "Not Set";
    }

    public Task(String text, String category){
        this.text = text;
        this.category = category;
    }

    public int getScore(){
        switch(this.category){
            case "SCHOOLWORK":
                return 10;
            case "HOUSEWORK":
                return 20;
            case "PERSONAL":
                return 30;
            case "OTHER":
                return 40;
            default:
                return 0;
        }
    }
}
