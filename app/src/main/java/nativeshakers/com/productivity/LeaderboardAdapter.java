package nativeshakers.com.productivity;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.Time;
import java.util.List;
import java.util.Random;
import java.util.UUID;


public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {
    String TAG = "LEADERBOARD ADAPTER";

    private List<User> usersList;

    public LeaderboardAdapter(List<User> usersList) {
        Log.d(TAG, "In LeaderboardAdapter method, constructing users");
        Log.d(TAG, "usersList size is: "+ usersList.size());

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
        String points = LeaderboardActivity.calculatePoints(user);

        Log.d(TAG, "Points are "+points);

        leaderboardViewHolder.userName.setText(user.getName());
        leaderboardViewHolder.userPoints.setText(points);

    }

    @Override
    public LeaderboardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.d(TAG, "in LeaderboardAdapter onCreateViewHolder method");

        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.leaderboard_content_main, viewGroup, false);

        return new LeaderboardViewHolder(itemView);
    }


    public static class LeaderboardViewHolder extends RecyclerView.ViewHolder {

        protected TextView userName;
        protected TextView userPoints;
        CardView cv;

        public LeaderboardViewHolder(View v) {
            super(v);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            userName = (TextView) v.findViewById(R.id.userName);
            userPoints = (TextView) v.findViewById(R.id.points);
        }
    }
}