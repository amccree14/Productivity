package nativeshakers.com.productivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class MainActivity extends Activity {
    String TAG = "MAIN ACTIVITY";

    TextView mappName;
    TextView mwelcomeMessage;
    Button mcreateAccount;
    Button mlogin;
    Button mdemo;
    Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {

        super.onStart();
        Log.d(TAG, "in onStart method");

        mappName = (TextView)findViewById(R.id.appName);
        mwelcomeMessage = (TextView)findViewById(R.id.welcomeMessage);
        mcreateAccount = (Button)findViewById(R.id.createAccount);
        mlogin = (Button)findViewById(R.id.login);
        mdemo = (Button)findViewById(R.id.demo);
        mRef = new Firebase("https://nsproductivity.firebaseio.com/appName");
    }
}