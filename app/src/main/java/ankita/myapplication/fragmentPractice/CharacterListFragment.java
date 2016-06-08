package ankita.myapplication.fragmentPractice;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

    String [] Names = {"Iron Man", "Hulk", "Captain America","Spider Man"};
    ListView lv;
    private OnFragmentInteractionListener mListener;
    public CharacterListFragment(){
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
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

                mListener.onFragmentInteraction (position);
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

    /**
     * This interface must be implemented by activities that contain this fragment to allow an
     * interaction in this fragment to be communicated to the activity and potentially other
     * fragments contained in that activity.
     * <p/>
     * See the Android Training lesson <a href= "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction (int position);
    }

}
