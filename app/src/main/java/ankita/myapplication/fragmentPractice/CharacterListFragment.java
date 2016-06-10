package ankita.myapplication.fragmentPractice;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import ankita.myapplication.R;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link CharacterListFragment.OnFragmentInteractionListener} interface to handle interaction
 * events.
 */
public class CharacterListFragment extends Fragment {

    int position;
    FragmentManager fragmentManager ;
    FragmentTransaction fragmentTransaction ;
    CharacterListFragment myListFragment;

    String [] Names = {"Iron Man", "Hulk", "Captain America","Spider Man"};
    ListView lv;
    private OnFragmentInteractionListener mListener;
    public CharacterListFragment(){

    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        if(savedInstanceState!=null)
          position = savedInstanceState.getInt ("position",0);
        super.onCreate (savedInstanceState);
        fragmentManager = getFragmentManager ();
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate (R.layout.fragment_character_list, container, false);
        lv = (ListView)view.findViewById (R.id.lvfragmentListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (getContext (),R.layout.list_view_item_layout,Names);
        lv.setAdapter (arrayAdapter);
        lv.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                  mListener.onFragmentInteraction(position);
//                Log.d ("Item Clicked ", position + "");
//                Bundle bundle = new Bundle ();
//                bundle.putInt ("position", position);
//                CharacterInformationFragment characterInformationFragment = new CharacterInformationFragment ();
//                characterInformationFragment.setArguments (bundle);
//                fragmentTransaction = fragmentManager.beginTransaction ();
//                fragmentTransaction.replace (R.id.fragmentDisplay, characterInformationFragment);
//                fragmentTransaction.addToBackStack (null);
//                fragmentTransaction.setTransition (fragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
//                fragmentTransaction.commit ();
            }
        });
        return view;
    }

    @Override
    public void onAttach (Context context) {

        super.onAttach (context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
        else {
            throw new RuntimeException (context.toString ()
                                                + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach () {

        super.onDetach ();
        mListener = null;
    }

    @Override
    public void onSaveInstanceState (Bundle outState) {
        Log.d ("cool", "B");
        super.onSaveInstanceState (outState);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction (int position);
    }

}
