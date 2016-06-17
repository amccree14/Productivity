package nativeshakers.com.productivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;


public class LeaderboardActivity extends AppCompatActivity {

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }


    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final List<User> data, final ClickListener clicklistener) {

            this.clicklistener = clicklistener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recycleView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clicklistener != null) {
                        clicklistener.onLongClick(child, recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clicklistener != null && gestureDetector.onTouchEvent(e)) {
                clicklistener.onClick(child, rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

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
     */
    public List<User> makeFakeUsers(List<User> usersList) {

        String[] taskCategoryChoices = {"SCHOOLWORK", "HOUSEWORK", "PERSONAL", "OTHER"};

        for (int i = 0; i < 5; i++) {
            String uuid = UUID.randomUUID().toString().substring(0, 5);
            User u = new User(uuid, "Alice" + i, "Alice" + i + "@twitter.com", Integer.toString(i));
            Log.d(TAG, "User " + i + "'s id is:" + u.getId());

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
        for (int i = 0; i < usersList.size(); i++) {
            Log.d(TAG, "" + usersList.get(i));
        }

        return usersList;
    }

    /**
     * Loops through the list of users and their tasks to calculate the user's points
     */
    public static String calculatePoints(User user) {
        Log.d(TAG, "Calculating user's " + user.getName() + "points");

        int overallScore = 0;

        List<Task> tasks = user.getTasks();
        for (int k = 0; k < tasks.size(); k++) {
            Task t = tasks.get(k);
            overallScore += t.getScore();
        }
        String res = Integer.toString(overallScore);
        user.setScore(overallScore);
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
        usersList = makeFakeUsers(usersList);
        Log.d(TAG, "in onCreate method, usersData list has: " + usersList.size());
        for(int i = 0; i< usersList.size(); i++){
            User u = usersList.get(i);
            int score = Integer.parseInt(LeaderboardActivity.calculatePoints(u));
            u.setScore(score);
        }
        Collections.sort(usersList, new userComparator());

        // specify an adapter (see also next example)
        mAdapter = new LeaderboardAdapter(usersList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        final List<User> finalUsersList = usersList;
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, usersList, new ClickListener() {

            @Override
            public void onClick(View view, final int position) {

                //Values are passing to activity & to fragment as well
                final User user = finalUsersList.get(position);

                Integer score = user.getScore();

                Toast.makeText(LeaderboardActivity.this, "Score is: " + score,
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(LeaderboardActivity.this, "Long press on position :" + position,
                        Toast.LENGTH_LONG).show();
            }
        }));

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "in LeaderboardAcrivity onStart method");
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
        Log.d(TAG, "Adapter has " + mAdapter.getItemCount() + " elements");
    }
}
