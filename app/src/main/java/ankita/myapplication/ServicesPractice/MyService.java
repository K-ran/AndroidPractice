package ankita.myapplication.ServicesPractice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import ankita.myapplication.BroadcastRecieverPratice.CustomBroadCastReciver;

public class MyService extends Service {

    CustomBroadCastReciver reciver;
    public MyService () {
    }

    @Override
    public int onStartCommand (Intent intent, int flags, int startId) {
        reciver = new CustomBroadCastReciver ();
        IntentFilter intentFilter = new IntentFilter ();
        intentFilter.addAction ("CUSTOM_INTENT");
        registerReceiver (reciver, intentFilter);
        Toast.makeText (getApplicationContext (),"Service started",Toast.LENGTH_SHORT).show ();
        return START_STICKY;
    }

    @Override
    public void onDestroy () {
        super.onDestroy ();
        Toast.makeText (getApplicationContext (),"Service stoped",Toast.LENGTH_SHORT).show ();
        unregisterReceiver (reciver);
    }

    @Override
    public IBinder onBind (Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException ("Not yet implemented");
    }
}
