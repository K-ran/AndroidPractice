package ankita.myapplication.ConnectivityManagerPractice;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import ankita.myapplication.R;

public class PracticeConnectivityManager extends AppCompatActivity implements NetworkReciever.NetworkRecieverListner{

    public static String DEBUG_TAG="cool";
    public static boolean MOBILE_DATA_Setting=false;
    ImageView iv;
    NetworkReciever networkReciever;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_connectivity_manager);
        iv=(ImageView)findViewById (R.id.ivConnectivityManager);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences (this);
        MOBILE_DATA_Setting = sharedPreferences.getBoolean ("useMobile",false);
        Log.d (DEBUG_TAG, "Mobile data current: " + MOBILE_DATA_Setting);
        networkReciever= new NetworkReciever (this);
        IntentFilter intentFilter = new IntentFilter ("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver (networkReciever,intentFilter);
    }

    public void openSettings(View view){
        Intent intent = new Intent (this,MySettings.class);
        startActivity (intent);
    }

    public boolean isMobileDataAvailable(){
        ConnectivityManager connMgr = (ConnectivityManager)
        getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getNetworkInfo (ConnectivityManager.TYPE_WIFI);
        boolean isWifiConn = networkInfo.isConnected();
        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobileConn = networkInfo.isConnected();
        Log.d (DEBUG_TAG, "Wifi connected: " + isWifiConn);
        Log.d (DEBUG_TAG, "Mobile connected: " + isMobileConn);
        return isMobileConn;
    }

    @Override
    protected void onResume () {
        setVisibility (isMobileDataAvailable ());
        super.onResume ();
    }

    void setVisibility(boolean mobileData){
        if(MOBILE_DATA_Setting==true && mobileData)
            iv.setVisibility (View.VISIBLE);
        else
            iv.setVisibility (View.INVISIBLE);
    }

    @Override
    public void NetworkRecieverCallback (boolean wifi) {
        setVisibility (wifi);
        Log.d (DEBUG_TAG,"Mobile data changed");
    }

    @Override
    protected void onDestroy () {
        unregisterReceiver (networkReciever);
        super.onDestroy ();
    }
}
