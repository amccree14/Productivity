package nativeshakers.com.productivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;


public class LeaderboardActivity extends AppCompatActivity {
    static String TAG = "LEADERBOARD ACTIVITY";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Task> userList = new ArrayList<>();
    private RecyclerView recyclerView;


    // HELPER
    public static String getRandom(String[] array) {
        // used to get a random category during task creation
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static String getRandomTime() {
        // outputs a random time
        final Random random = new Random();
        final int millisInDay = 24 * 60 * 60 * 1000;
        Time time = new Time((long) random.nextInt(millisInDay));
        return time.toString();
    }
    //HELPERS

    /**
     * makes 5 fake users with 5 tasks each
     *
     */
    public List<User> makeFakeUsers(List<User> usersList) {

        String[] taskCategoryChoices = {"SCHOOLWORK", "HOUSEWORK", "PERSONAL", "OTHER"};

        for (int i = 0; i < 5; i++) {
            String uuid = UUID.randomUUID().toString().substring(0, 5);
            User u = new User(uuid, "Alice" + i, "Alice" + i + "@twitter.com", Integer.toString(i));
            Log.d(TAG, "User " + i +"'s id is:" + u.getId());

            for (int k = 0; k < 5; k++) {

                String categoryT = getRandom(taskCategoryChoices);
                String uuidT = UUID.randomUUID().toString().substring(0, 5);
                Log.d(TAG, "Task uuid = " + uuidT);

                Task t = new Task(uuidT, categoryT, getRandomTime());
                u.addTask(t);
            }
            usersList.add(u);
        }
        Log.d(TAG, "Making fake users");
        Log.d(TAG, "" + usersList.size());
        Log.d(TAG, "Users are:");
        for(int i=0;i<usersList.size();i++){
            Log.d(TAG, "" + usersList.get(i));
        }

        return usersList;
    }

    /**
     * Loops through the list of users and their tasks to calculate the user's points
     */
    public static String calculatePoints(User user) {
        Log.d(TAG, "Calculating user's " +user.getName() +  "points");

        int overallScore = 0;

        List<Task> tasks = user.getTasks();
        for (int k = 0; k < tasks.size(); k++) {
            Task t = tasks.get(k);
            overallScore += t.getScore();
        }
        String res = Integer.toString(overallScore);
        return res;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard_main);
        Log.d(TAG, "in onCreate method");

        mRecyclerView = (RecyclerView) findViewById(R.id.leaderboard_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // create an array of users to be passed into the adapter
        // and populate it with fake users
        List<User> usersList = new ArrayList<User>();
        List<User> usersData= makeFakeUsers(usersList);
        Log.d(TAG, "in onCreate method, usersData list has: "+ usersData.size());

        // specify an adapter (see also next example)
        mAdapter = new LeaderboardAdapter(usersData);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "in onStart method");

    }
}
