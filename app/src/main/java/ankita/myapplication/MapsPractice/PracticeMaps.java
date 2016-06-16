package ankita.myapplication.MapsPractice;

import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ankita.myapplication.R;

public class PracticeMaps extends AppCompatActivity implements Response.ErrorListener, Response.Listener<String> {
    GoogleMap googleMap;
    float currentZoom=10;
    LatLng HomeCoordinates=new LatLng (26.2806646,73.003775);
    Marker start=null,end=null;
    PolylineOptions options;
    Polyline polyline;

    RequestQueue queue;
    StringRequest request;
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
        googleMap.setOnMapClickListener (new GoogleMap.OnMapClickListener () {
            @Override
            public void onMapClick (LatLng point) {

                Log.d ("LOcation", point.toString ());
                if (start == null)
                    start = googleMap.addMarker (new MarkerOptions ().position (point).title ("Start"));
                else if (end == null) {
                    end = googleMap.addMarker (new MarkerOptions ().position (point).title ("End"));
                    bothMarkerPlaced ();
                }
            }
        });


    }

    void resetPolyline(){
        options = new PolylineOptions ();
        options.color (Color.parseColor ("#CC0000FF"));
        options.width (5);
        options.visible (true);
    }

    private void bothMarkerPlaced(){
        doSomething();
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

    void doSomething(){
        resetPolyline ();
        queue = Volley.newRequestQueue (this);
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin="+
                    start.getPosition ().latitude+
                    ","+start.getPosition ().longitude+"&destination="+
                    end.getPosition ().latitude+
                    ","+end.getPosition ().longitude+"&key=AIzaSyBFs73owtXHDXmc_8WFNoyCdM3162ghlZc";
        request = new StringRequest (Request.Method.GET, url,this,this);
        queue.add(request);
    }

    @Override
    public void onResponse (String response) {
        JSONObject root=null;
        String distance=null,time=null;
        try {
            root = new JSONObject (response);
            JSONArray pointsArray = root.getJSONArray("routes").getJSONObject (0).getJSONArray ("legs").getJSONObject (0).getJSONArray ("steps");
            distance = root.getJSONArray("routes").getJSONObject (0).getJSONArray ("legs").getJSONObject (0).getJSONObject ("distance").getString("text");
            time = root.getJSONArray("routes").getJSONObject (0).getJSONArray ("legs").getJSONObject (0).getJSONObject ("duration").getString("text");
            for(int i=0;i<pointsArray.length ();i++){
                JSONObject point = pointsArray.getJSONObject (i);
                LatLng startPoint = new LatLng (point.getJSONObject ("start_location").getDouble ("lat"),point.getJSONObject ("start_location").getDouble ("lng"));
                LatLng endPoint = new LatLng (point.getJSONObject ("end_location").getDouble ("lat"),point.getJSONObject ("start_location").getDouble ("lng"));
                Log.d("Cool: ", startPoint.toString ()+" : "+endPoint.toString ());
                options.add (startPoint);
                options.add (endPoint);
            }
        }
        catch (JSONException e) {
            e.printStackTrace ();
        }
        polyline = googleMap.addPolyline (options);
        AlertDialog alertDialog = new AlertDialog.Builder(PracticeMaps.this).create ();
        alertDialog.setTitle ("Informaton");
        String message = "Total Distance: "+ distance+"\nDuration: "+time+"\nCost (Rs5/km): Rs. "+( Float.parseFloat (distance.split (" ")[0])*5);
        alertDialog.setMessage (message);
        alertDialog.show ();
    }

    @Override
    public void onErrorResponse (VolleyError error) {

    }
}
