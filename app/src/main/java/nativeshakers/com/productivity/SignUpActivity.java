/**
 * Created by earlybirdcamp on 6/15/16.
 */
package nativeshakers.com.productivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.firebase.client.Firebase;

public class SignUpActivity extends AppCompatActivity{
    private Firebase myFirebaseRef;
    private User user;
    private EditText name;
    private EditText email;
    private EditText password;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //Create a reference for the Firebase databse
        myFirebaseRef = new Firebase("https://nsproductivity.firebaseio.com/");

    }

    @Override
    protected void onStart() {
        super.onStart();
        name = (EditText) findViewById(R.id.edit_text_username);
        email = (EditText) findViewById(R.id.edit_text_new_email);
        password = (EditText) findViewById(R.id.edit_text_new_password);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar_sign_up);
    }

    protected void setUpUser(){
        user = new User();
        user.setName(name.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());

    }

}
