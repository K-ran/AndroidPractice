package ankita.myapplication.navigationDrawerPractice;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ankita.myapplication.R;

public class PracticeNavigationDrawer extends AppCompatActivity {

    private String[] mPlanetTitles;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;
    private CharSequence mTitle;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        mActivityTitle="Planets";
        setContentView (R.layout.activity_practice_navigation_drawer);
        mPlanetTitles = getResources().getStringArray(R.array.planets_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        getSupportActionBar().setDisplayHomeAsUpEnabled (true);
        getSupportActionBar().setHomeButtonEnabled (true);
        setupDrawer ();
        // Set the adapter for the list view
        mDrawerList.setAdapter (new ArrayAdapter<String> (this,
                                                          R.layout.list_view_item_layout, mPlanetTitles));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener (new DrawerItemClickListener ());

        Bundle bundle = new Bundle ();
        bundle.putString ("name", mPlanetTitles[0]);
        PlanetFragment fragment=  new PlanetFragment ();
        fragment.setArguments (bundle);
        getSupportFragmentManager ().beginTransaction ().add (R.id.content_frame,fragment).commit ();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }



    }

    private void selectItem(int position) {
        // Highlight the selected item, update the title, and close the drawer

        Bundle bundle = new Bundle ();
        bundle.putString ("name", mPlanetTitles[position]);
        PlanetFragment fragment=  new PlanetFragment ();
        fragment.setArguments (bundle);
        getSupportFragmentManager ().beginTransaction ().add (R.id.content_frame,fragment).commit ();

        mDrawerList.setItemChecked(position, true);
        setTitle(mPlanetTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar ().setTitle (mTitle);
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                                                  R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Menu");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed (view);
                if(getSupportActionBar ().getTitle ().equals ("Menu"))
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener (mDrawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected (item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
}
