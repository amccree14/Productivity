package info.androidhive.recyclerview;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import info.androidhive.recyclerview.Task;

public class TaskContainer {

    private static  TaskContainer sTaskReminder;

    private List<Task> mReminders;

    public static TaskContainer get(Context context) {
        if (sTaskReminder== null) {
            sTaskReminder = new TaskContainer(context);
        }
        return sTaskReminder;
    }

    private TaskContainer(Context context) {
        mReminders = new ArrayList<>();

        }


    public List<Task> getReminders(){
        return mReminders;
    }

//    public Task getReminder(UUID id) {
//        for (Task reminder : mReminders) {
//            if (reminder.getId().equals(id)) {
//                return reminder;
//            }
//        }
//        return null;
//    }
}