package ankita.myapplication.IntentPractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import ankita.myapplication.R;

public class PracticeImplicitIntent extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_implicit_intent);
    }

    public void shareTheStuff(View view){
        String message = ((EditText)findViewById (R.id.etImplicitIntent)).getText ().toString ();
        Log.e ("Message", message);
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType ("text/plain");
        myIntent.putExtra (Intent.EXTRA_TEXT, message);
        startActivity (myIntent);
    }
}
