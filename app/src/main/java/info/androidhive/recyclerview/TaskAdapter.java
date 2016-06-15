package info.androidhive.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private List<Task> tasksList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, time, category;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            category = (TextView) view.findViewById(R.id.category);
            time = (TextView) view.findViewById(R.id.time);
        }
    }


    public TaskAdapter(List<Task> tasksList) {
        this.tasksList = tasksList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Task movie = tasksList.get(position);
        holder.title.setText(movie.getTitle());
        holder.category.setText(movie.getCategory());
        holder.time.setText(movie.getTime());
    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }
}
