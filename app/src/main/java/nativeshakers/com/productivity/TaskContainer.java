package nativeshakers.com.productivity;

/**
 * Created by earlybirdcamp on 6/17/16.
 */
import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import nativeshakers.com.productivity.Task;

public class TaskContainer {
    private static TaskContainer sTaskReminder;

    private List<Task> mReminders;

    public static TaskContainer get(Context context) {
        if (sTaskReminder == null) {
            sTaskReminder = new TaskContainer(context);
        }
        return sTaskReminder;
    }

    private TaskContainer(Context context) {
        mReminders = new ArrayList<>();
    }

    public List<Task> getReminders() {
        return mReminders;
    };

}
