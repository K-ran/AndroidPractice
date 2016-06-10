package ankita.myapplication.fragmentPractice;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ankita.myapplication.R;

public class PracticeFragment extends AppCompatActivity implements CharacterListFragment.OnFragmentInteractionListener{

    FragmentManager fragmentManager ;
    FragmentTransaction fragmentTransaction ;
    CharacterListFragment myListFragment;
    CharacterInformationFragment characterInformationFragment;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        if(savedInstanceState!=null)
            Log.d ("cool", " Activity Called again");
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_fragment);
        myListFragment = new CharacterListFragment ();
        fragmentManager = getSupportFragmentManager ();
    }

    @Override
    public void onFragmentInteraction (int position) {
        Log.d("Item Clicked ", position + "");
        Bundle bundle = new Bundle ();
        bundle.putInt ("position", position);
        characterInformationFragment = new CharacterInformationFragment ();
        characterInformationFragment.setArguments(bundle);
            fragmentTransaction = fragmentManager.beginTransaction ();
            fragmentTransaction.replace (R.id.fragmentDisplay, characterInformationFragment);
            fragmentTransaction.addToBackStack (null);
            fragmentTransaction.setTransition (fragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            fragmentTransaction.commit ();
    }

    @Override
    public void onSaveInstanceState (Bundle outState, PersistableBundle outPersistentState) {
        Log.d("cool","A");
        super.onSaveInstanceState (outState, outPersistentState);
    }
}
