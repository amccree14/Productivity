/**
 * Created by earlybirdcamp on 6/15/16.
 */
package nativeshakers.com.productivity;

import com.firebase.client.Firebase;

import java.util.ArrayList;

public class User {
<<<<<<< HEAD
    String name;
    String firstName;
    String lastName;
    String id;
    String email;
    Integer score;
    String password;
    List<String> friends;
    List<Task> tasks;

    public User() {
        this.id = "Not Set";
        this.email = "Not Set";
        this.name = "Not Set";
        this.firstName = "Not Set";
        this.lastName = "Not Set";
        this.password = "Not Set";
        this.score = 0;
        this.friends = new ArrayList<String>();
        this.tasks = new ArrayList<Task>();
    }


    public User(String id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.firstName = "Not Set";
        this.lastName = "Not Set";
        this.password = password;
        this.friends = new ArrayList<String>();
        this.tasks = new ArrayList<Task>();

    }

    public void setScore(int score){
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void addFriends(String email) {
        this.friends.add(email);
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void printPerson() {
        System.out.println(name);
=======
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
>>>>>>> master
    }
    public void setEmail(String email) {
        this.email = email;
    }

<<<<<<< HEAD
    public List<Task> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
=======
    public ArrayList<Task> getNewTasks() {
        return newTasks;
    }
    public void setNewTasks(ArrayList<Task> newTasks) {
        this.newTasks = newTasks;
>>>>>>> master
    }

    public String tasksToString(){
        String tasks = "";
        for(int i=0; i<this.tasks.size(); i++){
            tasks += this.tasks.get(i).getTitle() + " ";
        }
        return tasks;
    }

<<<<<<< HEAD
    public String toString(){
        return "id is: " + this.id + ",name is: " + this.name + ",email is: "
                + this.email + ",tasks are: " + this.tasksToString();
=======
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
>>>>>>> master
    }

    public void saveUser() {
        Firebase myFirebaseRef = new Firebase("https://nsproductivity.firebaseio.com/");
        myFirebaseRef = myFirebaseRef.child("users").child(getId());
        myFirebaseRef.setValue(this);
    }
}
