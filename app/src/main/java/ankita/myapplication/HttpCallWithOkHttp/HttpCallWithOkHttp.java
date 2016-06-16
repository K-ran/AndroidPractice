package ankita.myapplication.HttpCallWithOkHttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ankita.myapplication.R;

public class HttpCallWithOkHttp extends AppCompatActivity implements SampleInterface{
    TextView textView;
    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_http_call_without_volley);
        textView = (TextView)findViewById (R.id.tvOkHttpCalls);
        SampleAsync task = new SampleAsync (this,this);
        task.execute ();
    }

    @Override
    public void OnResult (String result) {
        textView.setText (result);
    }
}
