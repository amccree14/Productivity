package nativeshakers.com.productivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by earlybirdcamp on 6/14/16.
 */
public class User {
    String name;
    String firstName;
    String lastName;
    String id;
    String email;
    String password;
    List<String> friends;
    List<String> tasks;

    public User() {
        this.id = "Not Set";
        this.email = "Not Set";
        this.name = "Not Set";
        this.firstName = "Not Set";
        this.lastName = "Not Set";
        this.password = "Not Set";
        this.friends = new ArrayList<String>();
        this.tasks = new ArrayList<String>();

    }

    public User(String id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.firstName = "Not Set";
        this.lastName = "Not Set";
        this.password = password;
        this.friends = new ArrayList<String>();
        this.tasks = new ArrayList<String>();

    }

    public void addFriends(String email){
        this.friends.add(email);
    }
    public void addTasks(Task task){
        this.friends.add(email);
    }

    public void printPerson() {
        System.out.println(name);
    }

    public List<String> getFriends() {
        return friends;
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }



}
