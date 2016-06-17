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


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {


    String TAG = "USER ADAPTER";

    private List<User> usersList;

    public UserAdapter(List<User> usersList) {
        Log.d(TAG, "In UserAdapter method, constructing users");
        Log.d(TAG, "usersList size is: " + usersList.size());

        this.usersList = usersList;
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    @Override
    public void onBindViewHolder(UserViewHolder userViewHolder, int i) {
        Log.d(TAG, "in userAdapter onBindViewHolder method");

        /// make a bunch of fake users

        User user = usersList.get(i);
        String points = UserActivity.calculatePoints(user);

        Log.d(TAG, "Points are " + points);

        userViewHolder.userName.setText(user.getName());
        userViewHolder.userPoints.setText(points);

    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.d(TAG, "in UserAdapter onCreateViewHolder method");

        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.user_list_row, viewGroup, false);
        return new UserViewHolder(itemView);
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        protected TextView userName;
        protected TextView userPoints;

        public UserViewHolder(View v) {
            super(v);
            Log.d("USER ADAPTER", "in UserViewHolder initialization method");
            userName = (TextView) v.findViewById(R.id.userName);
            Log.d("USER ADAPTER", "" + userName.getText());
            userPoints = (TextView) v.findViewById(R.id.points);
            Log.d("USER ADAPTER", "" + userPoints.getText());

        }
    }


}