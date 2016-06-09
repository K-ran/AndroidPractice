package ankita.myapplication.fragmentPractice;


import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ankita.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterInformationFragment extends Fragment {

    int position=0;
    String [] info={
            "This is the information on Iron Man",
            "This is the information on Hulk",
            "This is the information on Captain",
            "This is the information on Spider Man",
    };

    public CharacterInformationFragment () {
        // Required empty public constructor
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate (R.layout.fragment_character_information, container, false);
        if(savedInstanceState!=null)
            position = savedInstanceState.getInt ("position",0);
        else
            position = getArguments ().getInt ("position",0)
                    ;
        setRetainInstance (true) ;
        TextView tv = (TextView)v.findViewById (R.id.tvFragmentDisctiption);
        tv.setText (info[position]);
        return v;
    }

    @Override
    public void onDestroy () {
        Log.d ("cool"," I am going to crash");

        super.onDestroy ();
    }

    @Override
    public void onSaveInstanceState (Bundle outState) {
        Log.d ("cool", "C");
        outState.putInt ("position",position);
        super.onSaveInstanceState (outState);
    }
}
