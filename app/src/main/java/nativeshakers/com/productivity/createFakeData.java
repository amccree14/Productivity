package nativeshakers.com.productivity;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by earlybirdcamp on 6/16/16.
 */

public class createFakeData extends User {
    ArrayList<String> peopleNames = new ArrayList<String>();

    public ArrayList<String> createFakeFriendsFunction() {
        peopleNames.add("Andrew McCree");
        peopleNames.add("Anna Goncharova");
        peopleNames.add("Christina Le");
        peopleNames.add("Cindy Onyekwelu");
        peopleNames.add("Darren Young");
        peopleNames.add("Edwin Hernandez");
        peopleNames.add("Hoang Nguyen");
        peopleNames.add("Kafilah Muhammad");
        peopleNames.add("Darren Young");
        peopleNames.add("Kamoya Ikhofua");
        peopleNames.add("Kanisha Richardson");
        peopleNames.add("Lizzie Siegle");
        peopleNames.add("Tuan Caraballo");
        peopleNames.add("Yonas Kbrom");
        peopleNames.add("Bear Douglas");
        return peopleNames;
    }

    public List<User> returnUserArrayOfFriends(ArrayList<String> peopleNames) {
        List<User> friends = new ArrayList<User>();

        for (int i = 0; i < peopleNames.size(); i++) {
            // String id, String email, String name, String password
            String uuidT = UUID.randomUUID().toString().substring(0, 5);
            String firstName = peopleNames.get(i).split(" ")[0];
            Log.d("createFakeFriends", firstName);
            User u = new User(uuidT, firstName + "@twitter.com", peopleNames.get(i), "password" + i);
            friends.add(u);
        }

        return friends;
    }

    public List<User> createFakeTasks(List<User> users) {

        for (int i = 0; i < 5; i++) {
            User u = users.get(i);

            for (int k = 0; k < 5; k++) {

                String categoryT = LeaderboardActivity.getRandom(LeaderboardActivity.taskCategoryChoices);
                String uuidT = UUID.randomUUID().toString().substring(0, 5);

                Task t = new Task(uuidT, categoryT, LeaderboardActivity.getRandomTime());
                u.addTask(t);
            }
        }

        return users;
    }


}
