package nativeshakers.com.productivity;

/**
 * Created by earlybirdcamp on 6/16/16.
 */
import android.content.Intent;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TaskDetails extends AppCompatActivity{

    public Button addTask;
    public Spinner categories;
    public TimePicker timePicker;
    public EditText title;
    public Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Add Tasks");

        addTask = (Button) findViewById(R.id.btnSubmit);
        categories = (Spinner) findViewById(R.id.spinner1);
        timePicker = (TimePicker) findViewById(R.id.timePicker1);
        title = (EditText) findViewById(R.id.editText);

        task = new Task();
        task.setCategory(categories.getSelectedItem().toString());

        String time = new String();
        time = "" + timePicker.getHour() + ":" + timePicker.getMinute();
        task.setTime(time);

        task.setTitle(title.getText().toString());

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1);

        if (addTask != null) {
            addTask.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    task = new Task();
                    task.setCategory(categories.getSelectedItem().toString());

                    String time = new String();
                    time = "" + timePicker.getHour() + ":" + timePicker.getMinute();
                    task.setTime(time);

                    task.setTitle(title.getText().toString());

                    final List<String> taskDetails = Arrays.asList(task.getTitle(),task.getCategory(),task.getTime());

                    //Firebase.setAndroidContext(this);
                    addTask.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            new Firebase("https://nsproductivity.firebaseio.com/newTasks/")
                                    .push()
                                    .child("newTasks")
                                    .setValue(taskDetails);

                            Toast.makeText(getApplicationContext(), "You added a new task", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
                }
            });
        }

    }
}
