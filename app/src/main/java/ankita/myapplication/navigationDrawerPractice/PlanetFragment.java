package ankita.myapplication.navigationDrawerPractice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ankita.myapplication.R;

public class PlanetFragment extends Fragment {
    public PlanetFragment () {
        super ();
    }

    @Override
    public View onCreateView (LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_planet, container, false);
        TextView tv = (TextView)view.findViewById (R.id.tvPlanetInfo);
        tv.setText ("Information on "+getArguments ().getString ("name"));
        return view;
    }
}
