package ankita.myapplication.ConnectivityManagerPractice;

import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import ankita.myapplication.R;

public class MySettings extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        addPreferencesFromResource (R.xml.settings);
     }

    public MySettings () {

        super ();
    }

    @Override
    protected void onResume () {
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener (this);
        super.onResume ();
    }

    @Override
    protected void onPause () {
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause ();
    }

    @Override
    public void onSharedPreferenceChanged (SharedPreferences sharedPreferences, String key) {
        if(key.equals ("useMobile")) {
            Toast.makeText (MySettings.this, "Use Mobile Set: " + sharedPreferences.getBoolean (key, false), Toast.LENGTH_SHORT).show ();
            PracticeConnectivityManager.MOBILE_DATA_Setting=sharedPreferences.getBoolean (key, false);
        }
    }

}
