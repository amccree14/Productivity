package nativeshakers.com.productivity;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import android.widget.Toast;

public class SearchForFriends extends AppCompatActivity {
    String TAG = "SEARCH FOR FRIENDS";
    SearchView search;
    RelativeLayout rl;

    public String searchFriends(String s) {
        Log.d(TAG, s);

        return "";

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_menu);

        search = new SearchView(SearchForFriends.this);
        rl = (RelativeLayout) findViewById(R.id.searchMenuId);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                (int) LayoutParams.WRAP_CONTENT, (int) LayoutParams.WRAP_CONTENT);
        params.setMargins(40, 30, 0, 0);
        search.setQueryHint("SearchView");
        search.setLayoutParams(params);
        rl.addView(search);

        //***setOnQueryTextFocusChangeListener***
        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                Toast.makeText(getBaseContext(), String.valueOf(hasFocus),
                        Toast.LENGTH_SHORT).show();
            }
        });

        //***setOnQueryTextListener***

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchFriends(s);
                search.onActionViewCollapsed();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextChange(String query) {
        // Here is where we are going to implement our filter logic
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
}