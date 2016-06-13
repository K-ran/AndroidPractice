package ankita.myapplication.tabsPractice;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ankita.myapplication.R;
import ankita.myapplication.fragmentPractice.CharacterListFragment;

public class PracticeTabs extends AppCompatActivity implements TabFragment1.OnFragmentInteractionListener{

    MyFragmentAdapter adapter;
    ViewPager viewPager;
    ActionBar actionBar;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_tabs_practice);
        actionBar  = getSupportActionBar ();
        adapter =new  MyFragmentAdapter(getSupportFragmentManager ());
        actionBar.setNavigationMode (ActionBar.NAVIGATION_MODE_TABS);
        viewPager = (ViewPager)findViewById (R.id.pager);
        viewPager.setAdapter (adapter);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {

            @Override
            public void onTabSelected (ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
                viewPager.setCurrentItem (tab.getPosition ());
            }

            @Override
            public void onTabUnselected (ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected (ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }
        };

        // Add 3 tabs, specifying the tab's text and TabListener
        for (int i = 0; i < adapter.getCount (); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText("Tab " + (i + 1))
                            .setTabListener(tabListener));
        }

        viewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between pages, select the
                        // corresponding tab.
                        getSupportActionBar().setSelectedNavigationItem(position);
                    }
                });
    }

    @Override
    public void onFragmentInteraction (Uri uri) {

    }
}
