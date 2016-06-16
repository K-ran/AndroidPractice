package ankita.myapplication.HttpCallsWithVolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import ankita.myapplication.R;

public class PracticeHttpCalls extends AppCompatActivity implements Response.ErrorListener, Response.Listener<String> {

    TextView tv;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_http_calls);
        tv =(TextView)findViewById (R.id.tvHttpCalls);
        RequestQueue queue = Volley.newRequestQueue (this);
        String url ="http://api.androidhive.info/contacts/";
        StringRequest stringRequest = new StringRequest (Request.Method.GET, url,this,this);
        queue.add (stringRequest);
    }


    @Override
    public void onErrorResponse (VolleyError error) {
        tv.setText ("Oops, something went wrong");
    }

    @Override
    public void onResponse (String response) {
        tv.setText (response);
    }
}
