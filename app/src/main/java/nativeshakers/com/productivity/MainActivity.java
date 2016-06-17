package nativeshakers.com.productivity;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

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
        mappName = (TextView)findViewById(R.id.appName);
        mwelcomeMessage = (TextView)findViewById(R.id.welcomeMessage);
        mcreateAccount = (Button)findViewById(R.id.createAccount);
        mlogin = (Button)findViewById(R.id.login);
        mdemo = (Button)findViewById(R.id.demo);
        mRef = new Firebase("https://nsproductivity.firebaseio.com/appName");


    }
}
