package ankita.myapplication.ConnectivityManagerPractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by ankita on 11/6/16.
 */
public class NetworkReciever extends BroadcastReceiver {

     NetworkRecieverListner nrl;
    public NetworkReciever(NetworkRecieverListner nrl){
        this.nrl=nrl;
    }
    @Override
    public void onReceive (Context context, Intent intent) {
        ConnectivityManager conn =  (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conn.getActiveNetworkInfo();
        nrl.NetworkRecieverCallback (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI);
    }

    public interface NetworkRecieverListner{
        public void NetworkRecieverCallback(boolean wifi);
    }
}
