package ankita.myapplication.drawablesPractice;

import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import ankita.myapplication.R;

public class PracticeDrawables extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_drawables);
        btn = (Button)findViewById (R.id.btnDrawableTran);
        btn.setOnTouchListener (new View.OnTouchListener () {
            @Override
            public boolean onTouch (View v, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    TransitionDrawable transitionDrawable = (TransitionDrawable)btn.getBackground ();
                    transitionDrawable.startTransition (0);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    TransitionDrawable transitionDrawable = (TransitionDrawable)btn.getBackground ();
                    transitionDrawable.reverseTransition (500);
                }
                return true;
            }
        });
    }

    public void back(View view){
        finish();
    }
}
