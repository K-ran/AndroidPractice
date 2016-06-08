package ankita.myapplication.fragmentPractice;

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
    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_fragment);
        myListFragment = new CharacterListFragment ();
        fragmentManager = getSupportFragmentManager ();
    }

    @Override
    public void onFragmentInteraction (int position) {
        Log.d ("Item Clicked ", position + "");
        Bundle bundle = new Bundle ();
        bundle.putInt ("position", position);
        CharacterInformationFragment characterInformationFragment = new CharacterInformationFragment ();
        characterInformationFragment.setArguments (bundle);
        Fragment fragment = (Fragment)getSupportFragmentManager ().findFragmentById (R.id.fragmentDisplay2);
        if(fragment==null) {
            Log.d ("Hi fragment B not d"," hi ");
            fragmentTransaction = fragmentManager.beginTransaction ();
            fragmentTransaction.replace (R.id.fragmentDisplay, characterInformationFragment);
            fragmentTransaction.addToBackStack (null);
            fragmentTransaction.setTransition (fragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            fragmentTransaction.commit ();
        }
        else{
            Log.d ("Hi fragment B Loaded"," hi ");
            fragmentTransaction = fragmentManager.beginTransaction ();
            fragmentTransaction.replace (R.id.fragmentDisplay2, characterInformationFragment);
            fragmentTransaction.setTransition (fragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            fragmentTransaction.commit ();
        }
    }
}
