package ankita.myapplication.HttpCallWithOkHttp;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.util.concurrent.TimeUnit;

/**
 * Created by bharat on 22/10/15.
 */
public class SampleAsync extends AsyncTask<Void,Void,String> {


    private Context mContext;
    private SampleInterface mInterface;

    public SampleAsync(Context mContext,SampleInterface mInterface){

        this.mContext = mContext;
        this.mInterface = mInterface;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute ();
    }

    @Override
    protected String doInBackground(Void... voids) {

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(15, TimeUnit.SECONDS); // connect timeout
        client.setReadTimeout(15, TimeUnit.SECONDS);

        try {
            Request request = new Request.Builder()
                    .url("http://api.androidhive.info/contacts/")
                    .build ();

            Response response = client.newCall(request).execute();
            String Result = response.body().string();

            return Result;
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute (s);
        mInterface.OnResult(s);
    }
}
