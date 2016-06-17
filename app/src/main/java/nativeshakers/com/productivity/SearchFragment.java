package nativeshakers.com.productivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener {

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final List<String> data, final ClickListener clicklistener) {

            this.clicklistener = clicklistener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recycleView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clicklistener != null) {
                        clicklistener.onLongClick(child, recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clicklistener != null && gestureDetector.onTouchEvent(e)) {
                clicklistener.onClick(child, rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }


    String TAG = "SEARCH FRAGMENT";

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    private final ArrayList<String> users = CreateFakeData.createFakeFriendsFunction();

    private final String[] USERS = users.toArray(new String[users.size()]);
    ;

    private static final String[] MOVIES = new String[]{
            "The Woman in Black: Angel of Death",
            "20 Once Again",
            "Taken 3",
            "Tevar",
            "I",
            "Blackhat",
            "Spare Parts",
            "The Wedding Ringer",
            "Ex Machina",
            "Mortdecai",
            "Strange Magic",
            "The Boy Next Door",
            "The SpongeBob Movie: Sponge Out of Water",
            "Kingsman: The Secret Service",
            "Boonie Bears: Mystical Winter",
            "Project Almanac",
            "Running Man",
            "Wild Card",
            "It Follows",
            "C'est si bon",
            "Yennai Arindhaal",
            "Shaun the Sheep Movie",
            "Jupiter Ascending",
            "Old Fashioned",
            "Somewhere Only We Know",
            "Fifty Shades of Grey",
            "Dragon Blade",
            "Zhong Kui: Snow Girl and the Dark Crystal",
            "Badlapur",
            "Hot Tub Time Machine 2",
            "McFarland, USA",
            "The Duff",
            "The Second Best Exotic Marigold Hotel",
            "A la mala",
            "Focus",
            "The Lazarus Effect",
            "Chappie",
            "Faults",
            "Road Hard",
            "Unfinished Business",
            "Cinderella",
            "NH10",
            "Run All Night",
            "X+Y",
            "Furious 7",
            "Danny Collins",
            "Do You Believe?",
            "Jalaibee",
            "The Divergent Series: Insurgent",
            "The Gunman",
            "Get Hard",
            "Home"
    };

    private RecyclerView mRecyclerView;
    private SearchAdapter mAdapter;
    private List<SearchModel> mModels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "in onCreateView");
        final View view = inflater.inflate(R.layout.fragment_search, container, false); //search_item is fragment_main

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView); // like RecyclerVew in fragment_main

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        Log.d(TAG, "in onViewCreated");

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mModels = new ArrayList<>();

        for (String user : USERS) {
            mModels.add(new SearchModel(user));
        }

        mAdapter = new SearchAdapter(getActivity(), mModels);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(),
                mRecyclerView, users, new ClickListener() {

            @Override
            public void onClick(View view, final int position) {

                //Values are passing to activity & to fragment as well
                final String user = users.get(position);

                Toast.makeText(getActivity().getApplicationContext(), "User is: " + user,
                        Toast.LENGTH_SHORT).show();
//                Toast.makeText(getActivity().getApplicationContext(), "BLAH",Toast.LENGTH_SHORT).show();
                Log.d("SEARCH FRAGMENT CLASS", user + "was clicked");
            }

            @Override
            public void onLongClick(View view, int position) {
                final String user = users.get(position);

                Log.d("SEARCH FRAGMENT CLASS", user + "was clicked");

                Toast.makeText(getActivity().getApplicationContext(), "Long press on position :" + position,
                        Toast.LENGTH_LONG).show();
            }
        }));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.d(TAG, "in onCreateOptionsMenu");

        inflater.inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextChange(String query) {
        Log.d(TAG, "in onQueryTextChange");

        final List<SearchModel> filteredModelList = filter(mModels, query);
        mAdapter.animateTo(filteredModelList);
        mRecyclerView.scrollToPosition(0);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private List<SearchModel> filter(List<SearchModel> models, String query) {
        query = query.toLowerCase();

        final List<SearchModel> filteredModelList = new ArrayList<>();
        for (SearchModel model : models) {
            final String text = model.getText().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}