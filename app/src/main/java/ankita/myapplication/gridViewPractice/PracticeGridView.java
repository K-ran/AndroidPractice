package ankita.myapplication.gridViewPractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import ankita.myapplication.R;

public class PracticeGridView extends AppCompatActivity {

    GridView gridView;
    String[] lables={"7","8","9","*",
                    "4","5","6","/",
                    "1","2","3","x",
                    "-","0","+","="
                    };
    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_grid_view);
        gridView = (GridView)findViewById (R.id.gvKeyPad);
        gridView.setAdapter (new CustomGridAdapter (getApplicationContext(),lables,(TextView)findViewById (R.id.tvCustomGridTextView)));
    }
}
