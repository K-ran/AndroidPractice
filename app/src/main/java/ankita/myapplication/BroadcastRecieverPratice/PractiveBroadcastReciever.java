package ankita.myapplication.BroadcastRecieverPratice;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ankita.myapplication.R;

public class PractiveBroadcastReciever extends AppCompatActivity {


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practive_broadcast_reciever);


    }

    public  void broadcast(View view){
        Intent intent = new Intent ();
        intent.putExtra ("data","THis is the data");
        intent.setAction("CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    @Override
    protected void onDestroy () {

        super.onDestroy ();
    }
}
