package ankita.myapplication.MapsPractice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import ankita.myapplication.R;

public class PracticeMaps extends AppCompatActivity {
    GoogleMap googleMap;
    float currentZoom=10;
    LatLng HomeCoordinates=new LatLng (26.2806646,73.003775);
    Marker start=null,end=null;
    PolylineOptions options;
    Polyline polyline;
    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_maps_practice);
        if(googleMap==null)
             googleMap = ((MapFragment)getFragmentManager ().findFragmentById (R.id.map)).getMap ();
        CameraUpdate center=
                CameraUpdateFactory.newLatLng (HomeCoordinates);
        CameraUpdate zoom= CameraUpdateFactory.zoomTo (currentZoom);

        googleMap.moveCamera (center);
        googleMap.animateCamera (zoom);

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener () {
            @Override
            public void onMapClick (LatLng point) {
                Log.d ("LOcation", point.toString ());
                if(start==null)
                    start = googleMap.addMarker (new MarkerOptions ().position (point).title ("Start"));
                else if(end==null) {
                    end = googleMap.addMarker (new MarkerOptions ().position (point).title ("End"));
                    bothMarkerPlaced();
                }
            }
        });
    }

    private void bothMarkerPlaced(){
        options = new PolylineOptions ();

        options.color( Color.parseColor ("#CC0000FF") );
        options.width (5);
        options.visible (true);
        options.add (start.getPosition ());
        options.add (end.getPosition ());
        polyline = googleMap.addPolyline (options);
    }
    public void clearMarkers(View view){

        if(start!=null){
            start.remove ();
            start=null;
        }
        if(end!=null){
            end.remove ();
            end=null;
            polyline.remove ();
        }

    }
}
