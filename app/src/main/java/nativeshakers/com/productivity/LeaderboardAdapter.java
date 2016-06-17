package nativeshakers.com.productivity;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;


public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {

    String TAG = "LEADERBOARD ADAPTER";

    private List<User> usersList;

    public LeaderboardAdapter(List<User> usersList) {
        Log.d(TAG, "In LeaderboardAdapter method, constructing users");
        Log.d(TAG, "usersList size is: " + usersList.size());

        this.usersList = usersList;
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    @Override
    public void onBindViewHolder(LeaderboardViewHolder leaderboardViewHolder, int i) {
        Log.d(TAG, "in LeaderboardAdapter onBindViewHolder method");

        /// make a bunch of fake users

        User user = usersList.get(i);
        Integer pts = user.getScore();

        Log.d(TAG, "Points are " + pts);

        leaderboardViewHolder.userName.setText(user.getName());
        leaderboardViewHolder.userPoints.setText("" + pts);

    }

    @Override
    public LeaderboardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.d(TAG, "in LeaderboardAdapter onCreateViewHolder method");

        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.leaderboard_list_row, viewGroup, false);

        return new LeaderboardViewHolder(itemView);
    }

    public static class LeaderboardViewHolder extends RecyclerView.ViewHolder {

        protected TextView userName;
        protected TextView userPoints;

        public LeaderboardViewHolder(View v) {
            super(v);
            Log.d("LEADERBOARD ADAPTER", "in LeaderboardViewHolder initialization method");
            userName = (TextView) v.findViewById(R.id.userName);
            Log.d("LEADERBOARD ADAPTER", "" + userName.getText());
            userPoints = (TextView) v.findViewById(R.id.points);
            Log.d("LEADERBOARD ADAPTER", "" + userPoints.getText());

        }
    }


}