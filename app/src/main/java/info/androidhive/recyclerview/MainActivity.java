package info.androidhive.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Task> taskList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TaskAdapter tAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        tAdapter = new TaskAdapter(taskList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Task task = taskList.get(position);
                Toast.makeText(getApplicationContext(), task.getTitle() + " is finished!", Toast.LENGTH_SHORT).show();
                taskList.remove(task);
                tAdapter.notifyDataSetChanged();

            }


            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        dummyTaskData();


    }
////////////////// Plus Button Inflation /////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    ///////////////////////////////////////////////

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_plus_button:
                Intent i = new Intent(MainActivity.this, TaskDetails.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void dummyTaskData() {
        Task task = new Task("Finish Vector Calc HW", "Homework", "7:00 P.M.");
        taskList.add(task);

        task = new Task("Clean up dog shit", "Housework", "5:00 P.M.");
        taskList.add(task);

        task = new Task("Clean up dog shit", "Housework", "5:00 P.M.");
        taskList.add(task);

        task = new Task("Clean up dog shit", "Housework", "5:00 P.M.");
        taskList.add(task);

        task = new Task("Clean up dog shit", "Housework", "5:00 P.M.");
        taskList.add(task);

        task = new Task("Clean up dog shit", "Housework", "5:00 P.M.");
        taskList.add(task);

        task = new Task("Clean up dog shit", "Housework", "5:00 P.M.");
        taskList.add(task);

        task = new Task("Clean up dog shit", "Housework", "5:00 P.M.");
        taskList.add(task);

        task = new Task("Clean up dog shit", "Housework", "5:00 P.M.");
        taskList.add(task);

        task = new Task("Clean up dog shit", "Housework", "5:00 P.M.");
        taskList.add(task);

        task = new Task("Clean up dog shit", "Housework", "5:00 P.M.");
        taskList.add(task);

        task = new Task("Clean up dog shit", "Housework", "5:00 P.M.");
        taskList.add(task);


        tAdapter.notifyDataSetChanged();
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private MainActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final MainActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
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

}
