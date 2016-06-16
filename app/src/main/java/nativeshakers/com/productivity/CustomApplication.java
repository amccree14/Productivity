/**
 * Created by earlybirdcamp on 6/15/16.
 */
package nativeshakers.com.productivity;

import com.firebase.client.Firebase;

public class CustomApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}