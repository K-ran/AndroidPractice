package ankita.myapplication.VolleyPostRequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import ankita.myapplication.R;

public class PracticePostRequest extends AppCompatActivity implements Response.ErrorListener, Response.Listener<String>{

    TextView tv;
    EditText et;
    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_post_request);
        tv = (TextView)findViewById (R.id.tvVolleyResult);
        et = (EditText)findViewById (R.id.etVolleyQ);
    }

    public void sendRequest(View view){
        RequestQueue queue = Volley.newRequestQueue (this);
        StringRequest myReq = new StringRequest (Request.Method.POST,
                                                "http://karantesting.comlu.com/android/data.php",
                                                this,
                                                this)
        {
            protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
                Map<String, String> params = new HashMap<String, String> ();
                params.put("num",et.getText ().toString ());
                return params;
            };
        };
        queue.add(myReq);
    }


    @Override
    public void onErrorResponse (VolleyError error) {

    }

    @Override
    public void onResponse (String response) {
            String[] ans=response.split ("\n");
            tv.setText (ans[0]);
    }

}
