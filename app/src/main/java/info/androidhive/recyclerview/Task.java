package info.androidhive.recyclerview;


public class Task {
    private String title, category, time;

    public Task() {
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
        this.category = category;
    }
}
