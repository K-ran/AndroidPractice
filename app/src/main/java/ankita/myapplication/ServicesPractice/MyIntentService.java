package ankita.myapplication.ServicesPractice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in a service on a
 * separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {

    public MyIntentService () {

        super ("MyIntentService");
    }

    @Override
    protected void onHandleIntent (Intent intent) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }
        Log.e ("Intent Services", "I did something");
    }

    @Override
    public void onDestroy () {
        Toast.makeText (getApplicationContext (), "Thread did something", Toast.LENGTH_SHORT).show();
        super.onDestroy ();
    }
}
