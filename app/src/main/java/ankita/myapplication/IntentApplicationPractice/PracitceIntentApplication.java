package ankita.myapplication.IntentApplicationPractice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

import ankita.myapplication.R;

public class PracitceIntentApplication extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_pracitce_intent_applcation);
    }

    public  void  getTheStuff(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction (Intent.ACTION_GET_CONTENT);
        startActivityForResult (Intent.createChooser (intent, "Select Picture"), 1);
    }
    public void getTheStufffromCamera(View view){
        Intent intent = new Intent();
        intent.setAction(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),2);
    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                InputStream image_stream = null;
                try {
                    image_stream = getContentResolver().openInputStream (data.getData ());
                    Bitmap bitmap= BitmapFactory.decodeStream (image_stream);
                    ((ImageView)findViewById (R.id.ivContentProvider)).setImageBitmap (bitmap);
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace ();
                }
                Log.e("Got the result from", data.getData ().toString ());
            }
        }
        else if(requestCode == 2 && resultCode==RESULT_OK){
                Bitmap bitmap = (Bitmap)data.getExtras ().get("data");
                ((ImageView)findViewById (R.id.ivContentProvider)).setImageBitmap (bitmap);
        }

        super.onActivityResult (requestCode, resultCode, data);
    }
}
