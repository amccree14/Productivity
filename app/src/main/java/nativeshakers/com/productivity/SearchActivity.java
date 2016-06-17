package nativeshakers.com.productivity;

/**
 * Created by earlybirdcamp on 6/17/16.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SearchFragment.newInstance())
                    .commit();
        }
    }
}
