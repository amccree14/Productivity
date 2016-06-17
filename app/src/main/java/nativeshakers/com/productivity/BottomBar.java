package nativeshakers.com.productivity;

//https://github.com/roughike/BottomBar/blob/master/README.md (REFRENCE URL)
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarBadge;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.roughike.bottombar.OnTabClickListener;


class Bottom_Bar extends AppCompatActivity {
    private BottomBar mBottomBar;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottombar);

        // Instead of attach(), use attachShy():
        mBottomBar = BottomBar.attachShy((CoordinatorLayout) findViewById(R.id.myCoordinator),
                findViewById(R.id.myScrollingContent), savedInstanceState);
        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItems(R.menu.bottombar_menu);
        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottomBarItemOne) {
                    // The user selected item number one.
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottomBarItemOne) {
                    // The user reselected item number one, scroll your content to top.
                }
            }
        });

        // Setting colors for different tabs when there's more than three of them.
        // You can set colors for tabs in three different ways as shown below.
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(1, 0xFF5D4037);
        mBottomBar.mapColorForTab(2, "#7B1FA2");

    }

        @Override
        protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);


// Make a Badge for the first tab, with red background color and a value of "13".
        BottomBarBadge unreadMessages = mBottomBar.makeBadgeForTabAt(0, "#FF0000", 13);

// Control the badge's visibility
        unreadMessages.show();
        unreadMessages.hide();

// Change the displayed count for this badge.
        unreadMessages.setCount(4);

// Change the show / hide animation duration.
        unreadMessages.setAnimationDuration(200);

// If you want the badge be shown always after unselecting the tab that contains it.
        unreadMessages.setAutoShowAfterUnSelection(true);

// If you don't want this badge to be hidden after selecting the tab contains it.
        unreadMessages.setAutoShowAfterUnSelection(false);


// Disable the left bar on tablets and behave exactly the same on mobile and tablets instead.
        mBottomBar.noTabletGoodness();

// Show all titles even when there's more than three tabs.
        mBottomBar.useFixedMode();

// Use the dark theme.
        mBottomBar.useDarkTheme();

// Set the color for the active tab. Ignored on mobile when there are more than three tabs.
        mBottomBar.setActiveTabColor("#009688");

// Use custom text appearance in tab titles.
        mBottomBar.setTextAppearance(R.style.MyTextAppearance);

// Use custom typeface that's located at the "/src/main/assets" directory. If using with
// custom text appearance, set the text appearance first.
        mBottomBar.setTypeFace("MyFont.ttf");


        mBottomBar.setItems(
                new BottomBarTab(R.drawable.ic_leaderboard, "LeaderBoard"),
                new BottomBarTab(R.drawable.ic_mytasks, "MyTasks"),
                new BottomBarTab(R.drawable.ic_logout, "LogOut")
        );


// Listen for tab changes
        mBottomBar.setOnTabClickListener(new OnTabClickListener() {
            @Override
            public void onTabSelected(int position) {
                // The user selected a tab at the specified position
            }

            @Override
            public void onTabReSelected(int position) {
                // The user reselected a tab at the specified position!
            }
        });

    }
    }

