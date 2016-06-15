package ankita.myapplication.locationHandeling;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
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
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import ankita.myapplication.R;
public class PracticeLocationHandeling extends AppCompatActivity implements LocationListener,GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static final int REQUEST_CHECK_SETTINGS = 1;
    GoogleApiClient mGoogleApiClient;
    TextView mLatitudeText,mLongitudeText;
    LocationRequest mLocationRequest;
    Location lastLocation;
    Marker TP;
    static final LatLng point = new LatLng (28.6139 , 77.2090);
    private GoogleMap googleMap;


    @Override
    protected void onCreate (Bundle savedInstanceState) {

        Log.d("Activity Started","   sdf ssdf ");
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_location_handeling);
        mLatitudeText = (TextView )findViewById (R.id.tvLatitude);
        mLongitudeText = (TextView)findViewById (R.id.tvLongitude);

        createLocationRequest ();

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder (this)
                    .addConnectionCallbacks (this)
                    .addOnConnectionFailedListener (this)
                    .addApi (LocationServices.API)
                    .build ();
        }


        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(mLocationRequest);
        builder.setAlwaysShow(true);
        PendingResult<LocationSettingsResult> result =
                LocationServices.SettingsApi.checkLocationSettings (mGoogleApiClient, builder.build ());
        result.setResultCallback (new ResultCallback<LocationSettingsResult> () {
            @Override
            public void onResult (LocationSettingsResult result) {

                final Status status = result.getStatus ();
                final LocationSettingsStates state = result.getLocationSettingsStates ();
                switch (status.getStatusCode ()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        startLocationUpdates ();
                        Log.d("Success","success");
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        try {
                            status.startResolutionForResult (
                                    PracticeLocationHandeling.this, 1000);
                        }
                        catch (IntentSender.SendIntentException e) {
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        break;
                }
            }
        });




    }

    @Override
    public void onConnected (@Nullable Bundle bundle) {

        if (ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startLocationUpdates ();
        Toast.makeText (PracticeLocationHandeling.this, "on Connect called", Toast.LENGTH_SHORT).show ();
        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation (mGoogleApiClient);
        if (mLastLocation != null) {
            setLocationView (mLastLocation);
            Log.d ("Location", String.valueOf (mLastLocation.getLatitude ()));
            Log.d ("Location", String.valueOf (mLastLocation.getLongitude ()));
        }
        else startLocationUpdates ();
    }
    @Override
    public void onLocationChanged (Location location) {
        Log.d ("Location","Updated");
        setLocationView (location);
        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation (mGoogleApiClient);
    }

    public void setLocationView(Location mLastLocation){
        mLatitudeText.setText (String.valueOf (mLastLocation.getLatitude ()));
        mLongitudeText.setText (String.valueOf (mLastLocation.getLongitude ()));
        if(lastLocation!=null)
            if(lastLocation.getLatitude ()==mLastLocation.getLatitude () && lastLocation.getLongitude ()==mLastLocation.getLongitude ())
                return;
        try {
            if (googleMap == null) {
                googleMap = ((MapFragment) getFragmentManager().
                        findFragmentById(R.id.map)).getMap();
            }
            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            if(TP!=null)
                TP.remove ();
            TP = googleMap.addMarker (new MarkerOptions ().
                    position (new LatLng (mLastLocation.getLatitude(),mLastLocation.getLongitude())).title("I am here"));

            CameraUpdate center=
                    CameraUpdateFactory.newLatLng(TP.getPosition ());
            CameraUpdate zoom= CameraUpdateFactory.zoomTo (9);

            googleMap.moveCamera (center);
            googleMap.animateCamera (zoom);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval (10000);
        mLocationRequest.setFastestInterval (5000);
        mLocationRequest.setPriority (LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    protected void startLocationUpdates() {
        LocationServices.FusedLocationApi.requestLocationUpdates (mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onConnectionSuspended (int i) {
    }

    @Override
    protected void onResume () {
        if(mGoogleApiClient.isConnected() )
            startLocationUpdates();
        else
            mGoogleApiClient.connect ();
        super.onResume ();
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
        super.onStop ();
    }

    @Override
    protected void onPause () {
        if (mGoogleApiClient.isConnected()) {
            stopLocationUpdates ();
            mGoogleApiClient.disconnect();
        }
        super.onPause ();
    }


    protected void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates (
                mGoogleApiClient, this);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1000:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        if(mGoogleApiClient.isConnected ())
                            startLocationUpdates();
                        break;
                    case Activity.RESULT_CANCELED:
                        finish ();
                        break;
                }
                break;
        }
        super.onActivityResult (requestCode, resultCode, data);
    }
}

