package ankita.myapplication.fragmentPractice;


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
        int position;
        try {
            position = getArguments ().getInt ("position");
        }
        catch (NullPointerException e){
            Log.e ("Exception :"," Position NUll");
        }
        finally {
            position=0;
        }
        TextView tv = (TextView)v.findViewById (R.id.tvFragmentDisctiption);
        tv.setText (info[position]);
        return v;
    }

}
