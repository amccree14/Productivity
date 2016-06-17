package nativeshakers.com.productivity;


import java.util.Comparator;

public class userComparator implements Comparator<User> {

    public int compare(User o1, User o2) {
        if (o1.getScore() > o2.getScore()) {
            return 1;
        }
        return -1;
    }

}