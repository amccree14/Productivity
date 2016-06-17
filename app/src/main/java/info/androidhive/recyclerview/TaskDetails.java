package info.androidhive.recyclerview;


import android.content.Intent;
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

import java.util.List;


public class TaskDetails extends AppCompatActivity {

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
        time = "" + timePicker.getCurrentHour() + "" + timePicker.getCurrentMinute();
        task.setTime(time);

        task.setTitle(title.getText().toString());



        if (addTask != null) {
            addTask.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    task = new Task();
                    task.setCategory(categories.getSelectedItem().toString());

                    String time = new String();
                    time = "" + timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();
                    task.setTime(time);

                    task.setTitle(title.getText().toString());


                    TaskContainer reminderContainer = TaskContainer.get(getApplicationContext());
                    List<Task> reminders = reminderContainer.getReminders();
                    reminders.add(task);


//                    Intent i = new Intent(TaskDetails.this, MainActivity.class);
//                    i.putExtra("category", categories.getSelectedItem().toString());
//                    startActivityForResult(i, RESULT_OK);
                    finish();
                }
            });
        }




    }




}






