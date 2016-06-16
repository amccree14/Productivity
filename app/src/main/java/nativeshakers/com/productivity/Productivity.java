package nativeshakers.com.productivity;

import com.firebase.client.Firebase;

/**
 * Created by earlybirdcamp on 6/14/16.
 */
public class Productivity extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}