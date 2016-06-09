package ankita.myapplication.AsyncTask;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import ankita.myapplication.R;

public class PracticeAsyncTask extends AppCompatActivity {

    ImageView iv;
    ImageDowloader imageDowloader;
    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_async_task);
        iv =  ((ImageView)findViewById (R.id.ivAsyncTask));
        imageDowloader = new ImageDowloader ();
        if(savedInstanceState==null)
          imageDowloader.execute ();
        else{
            Log.d("Open "," Data");
            Bitmap bitmap=savedInstanceState.getParcelable ("image");
            if(bitmap==null)
                imageDowloader.execute ();
            else
                iv.setImageBitmap (bitmap);
        }
    }

    class ImageDowloader extends AsyncTask<Void,Void,Bitmap>{
        private ProgressDialog dialog = new ProgressDialog(PracticeAsyncTask.this);
        @Override
        protected void onPreExecute () {
            this.dialog.setMessage("Loading Image");
            this.dialog.setCanceledOnTouchOutside (false);
            this.dialog.show();


            super.onPreExecute ();
        }

        @Override
        protected void onPostExecute (Bitmap bitmap) {
            iv.setImageBitmap (bitmap);
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }

        @Override
        protected Bitmap doInBackground (Void... params) {
            URL url;
            try {
                url = new URL ("https://pbs.twimg.com/profile_images/638751551457103872/KN-NzuRl.png");
                return BitmapFactory.decodeStream (url.openConnection ().getInputStream ());
            }
            catch (MalformedURLException e) {
                e.printStackTrace ();
            }
            catch (IOException e) {
                e.printStackTrace ();
            }
            return null;
        }
    }

    @Override
    public void onSaveInstanceState (Bundle outState) {
//        Bitmap bitmap = ((BitmapDrawable)iv.getDrawable()).getBitmap();
//        Log.d("Saved "," Data");
//        if(bitmap!=null)
//            outState.putParcelable ("image",bitmap);
        super.onSaveInstanceState (outState );
    }

    @Override
    protected void onDestroy () {
        imageDowloader.cancel (true);
        Log.d("cool"," Activity Destroy");
        super.onDestroy ();
    }

    @Override
    protected void onStop () {
        Log.d("cool"," Activity Stoped");
        super.onStop ();
    }
}
