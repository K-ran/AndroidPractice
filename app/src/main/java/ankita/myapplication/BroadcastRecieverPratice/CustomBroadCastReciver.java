package ankita.myapplication.BroadcastRecieverPratice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ankita on 6/6/16.
 */
public class CustomBroadCastReciver extends BroadcastReceiver {
    @Override
    public void onReceive (Context context, Intent intent) {
        Toast.makeText(context, "Intent Detected: " + intent.getStringExtra ("data"), Toast.LENGTH_LONG).show();
    }
}
