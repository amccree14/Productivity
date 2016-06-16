package nativeshakers.com.productivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by earlybirdcamp on 6/15/16.
 */
public class Leaderboard {

    List<String> users;

    public Leaderboard(){
        users = new ArrayList<String>();
    }

    public void addLeaderboardItem(String newUserId){
        users.add(newUserId);
    }

    public List<String> getLeaderboardUsers(){
        return this.users;
    }

}
