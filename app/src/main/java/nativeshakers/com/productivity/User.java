/**
 * Created by earlybirdcamp on 6/15/16.
 */
package nativeshakers.com.productivity;

import com.firebase.client.Firebase;

import java.util.ArrayList;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;

    private ArrayList<Task> newTasks;
    //private String Tasks;

    public User() {
        newTasks = new ArrayList<Task>();
        Task task1 = new Task("task 1", "blah", "now");
        Task task2 = new Task("task 2", "blah", "now");
        Task task3 = new Task("task 3", "blah", "now");
        newTasks.add(task1);
        newTasks.add(task2);
        newTasks.add(task3);

    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Task> getNewTasks() {
        return newTasks;
    }
    public void setNewTasks(ArrayList<Task> newTasks) {
        this.newTasks = newTasks;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void saveUser() {
        Firebase myFirebaseRef = new Firebase("https://nsproductivity.firebaseio.com/");
        myFirebaseRef = myFirebaseRef.child("users").child(getId());
        myFirebaseRef.setValue(this);
    }
}
