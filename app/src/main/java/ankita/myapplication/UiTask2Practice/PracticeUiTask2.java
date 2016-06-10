package ankita.myapplication.UiTask2Practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import ankita.myapplication.R;

public class PracticeUiTask2 extends AppCompatActivity {

    ArrayList<TravelInfo> list = new ArrayList<TravelInfo>();
    TravelInfo[] info = {
            new TravelInfo("12.1 Miles","13","Paota C Road","IN","Jodhpur","1/1/1","11:22","Paota C Road","IN","Jodhpur","1/1/1","11:22"),
            new TravelInfo("03.0 Miles","02","Pal Road","IN","Jodhpur","1/1/1","11:22","Paota C Road","IN","Jodhpur","1/1/1","11:22"),
            new TravelInfo("17.0 Miles","15","Paota C Road","IN","Jodhpur","1/1/1","11:22","Paota C Road","IN","Jodhpur","1/1/1","11:22"),
            new TravelInfo("20.0 Miles","20","Pal C Road","IN","Jodhpur","1/1/1","11:22","Paota C Road","IN","Jodhpur","1/1/1","11:22"),
    };
    ListView lv;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_practice_ui_task2);
        list.addAll(Arrays.asList(info));
        lv =(ListView)findViewById(R.id.lvUitask2);
        lv.setAdapter(new UiTask2ArrayAdapter(this,list));
    }
}
