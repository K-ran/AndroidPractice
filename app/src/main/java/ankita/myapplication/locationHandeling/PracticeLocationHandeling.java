package ankita.myapplication.locationHandeling;

import android.Manifest;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;

import ankita.myapplication.R;
public class PracticeLocationHandeling extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static final int REQUEST_CHECK_SETTINGS = 1;
    GoogleApiClient mGoogleApiClient;
    TextView mLatitudeText,mLongitudeText;
    LocationRequest mLocationRequest;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_location_handeling);
        mLatitudeText = (TextView )findViewById (R.id.tvLatitude);
        mLongitudeText = (TextView)findViewById (R.id.tvLongitude);


        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder (this)
                    .addConnectionCallbacks (this)
                    .addOnConnectionFailedListener (this)
                    .addApi (LocationServices.API)
                    .build ();
        }

        if (ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText (PracticeLocationHandeling.this, "Permission not given", Toast.LENGTH_SHORT).show ();
        }

    }

    @Override
    public void onConnected (@Nullable Bundle bundle) {

        if (ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Toast.makeText (PracticeLocationHandeling.this, "on Connect called", Toast.LENGTH_SHORT).show ();
        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation (mGoogleApiClient);
        if (mLastLocation != null) {
            mLatitudeText.setText(String.valueOf(mLastLocation.getLatitude()));
            mLongitudeText.setText(String.valueOf(mLastLocation.getLongitude()));
            Log.d ("Location", String.valueOf (mLastLocation.getLatitude ()));
            Log.d ("Location", String.valueOf (mLastLocation.getLongitude ()));
        }
    }


    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval (10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
    }

    @Override
    public void onConnectionSuspended (int i) {

    }

    @Override
    public void onConnectionFailed (@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        Toast.makeText (PracticeLocationHandeling.this, "disConnected", Toast.LENGTH_SHORT).show ();
        super.onStop();
    }
}
