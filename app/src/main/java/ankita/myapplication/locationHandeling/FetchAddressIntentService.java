package ankita.myapplication.locationHandeling;

import android.app.IntentService;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;


import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

import ankita.myapplication.R;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in a service on a
 * separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class FetchAddressIntentService extends IntentService {
    public FetchAddressIntentService () {
        super ("FetchAddressIntentService");
    }

    @Override
    protected void onHandleIntent (Intent intent) {
        ResultReceiver mReceiver;
        Geocoder geocoder = new Geocoder (getApplicationContext ());
        String errorMessage = "No location found", message="";

        // Get the location passed to this service through an extra.
        LatLng location = intent.getParcelableExtra(
                Constants.LOCATION_DATA_EXTRA);
        mReceiver = intent.getParcelableExtra(
                Constants.RECEIVER);
        List<Address> addresses = null;

        try {
            addresses = geocoder.getFromLocation(
                    location.latitude,
                    location.longitude,
                    1);
        } catch (IOException ioException) {

        } catch (IllegalArgumentException illegalArgumentException) {
        }
        if (addresses == null || addresses.size()  == 0) {
                Log.e (" Error ", errorMessage);
            message=errorMessage;
            }
        else {
            Address address = addresses.get(0);
            // Fetch the address lines using getAddressLine,
            // join them, and send them to the thread.
            for(int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                message+=(address.getAddressLine(i)+" ");
            }
        }
        Bundle bundle = new Bundle ();
        bundle.putString(Constants.RESULT_DATA_KEY, message);
        mReceiver.send(0, bundle);
        stopSelf ();
    }

}
