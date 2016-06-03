package ankita.myapplication.layoutPractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ankita.myapplication.R;

public class PracticeLinearLauoyt extends AppCompatActivity {
    String msg = "Android : ";
    TextView tv;
    float lastStored=0;
    char lastOperator='=';
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        tv=(TextView)findViewById (R.id.tvDisplay);
        Log.d (msg, "The onCreate() event");
    }

    public void digitPressed(View v){
        String text = ((Button)v).getText ().toString ();
        String displayText=tv.getText ().toString ();
        displayText+=text;
        tv.setText (displayText);
        Log.e ("My Debug :", text);
    }

    public void functionPressed(View v) {

        String text = ((Button) v).getText ().toString ();
        Log.e ("My Debug kjkjjklj=:", text );
        if (!text.equals ("=")) {
            switch (text) {
                case "+":
                    lastOperator = '+';
                    break;
                case "-":
                    lastOperator = '-';
                    break;
                case "X":
                    lastOperator = 'X';
                    break;
                case "/":
                    lastOperator = '/';
                    break;
            }
            lastStored = Float.parseFloat (tv.getText ().toString ());
            tv.setText ("0");
            Log.e ("My Debug :", lastStored + "");
        }
        else {
            float answer=0;
            Log.e ("My Debug ", lastStored +" "+ Float.parseFloat (tv.getText().toString()));
            switch(lastOperator){
                case '+': answer =lastStored + Float.parseFloat (tv.getText().toString()); break;
                case '-': answer =lastStored - Float.parseFloat (tv.getText().toString()); break;
                case '/': answer =lastStored / Float.parseFloat (tv.getText().toString()); break;
                case 'X': answer =lastStored * Float.parseFloat (tv.getText().toString()); break;
            }
            lastStored=answer;
            Log.e ("My Debug answer", answer+"");
            lastOperator='=';
            tv.setText (answer+"");
        }
    }

    public  void clearDisplay(View v){
        tv.setText ("0");
        lastStored=0;
        lastOperator='=';
    }
}
