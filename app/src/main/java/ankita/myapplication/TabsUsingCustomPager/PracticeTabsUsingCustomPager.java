package ankita.myapplication.TabsUsingCustomPager;

import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import ankita.myapplication.R;

public class PracticeTabsUsingCustomPager extends AppCompatActivity implements TabFragment2.OnFragmentInteractionListener{
    // https://github.com/ogaclejapan/SmartTabLayout

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_tabs_using_custom_pager);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter (
                getSupportFragmentManager(), FragmentPagerItems.with (this)
                .add ("TAB 1", TabFragment2.class)
                .add ("TAB 2", TabFragment2.class)
                .add("TAB 3", TabFragment2.class)
                .add("TAB 4", TabFragment2.class)
                .add("TAB 5", TabFragment2.class)
                .add("TAB 6", TabFragment2.class)
                .create ());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager (viewPager);
    }

    @Override
    public void onFragmentInteraction (Uri uri) {

    }
}
