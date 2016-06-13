package ankita.myapplication.tabsPractice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ankita on 13/6/16.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    public MyFragmentAdapter (FragmentManager fm) {
        super (fm);
    }

    @Override
    public Fragment getItem (int position) {
        TabFragment1 fragment = new TabFragment1 ();
        Bundle bundle =new Bundle ();
        bundle.putInt ("position",position+1);
        fragment.setArguments (bundle);
        return fragment;
    }
    @Override
    public int getCount () {
        return 10;
    }

    @Override
    public CharSequence getPageTitle (int position) {
        return "Tab " + (position+1);
    }
}
