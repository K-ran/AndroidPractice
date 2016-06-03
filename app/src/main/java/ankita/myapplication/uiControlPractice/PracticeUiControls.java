package ankita.myapplication.uiControlPractice;

import android.app.Notification;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;

import java.lang.reflect.Type;

import ankita.myapplication.R;

public class PracticeUiControls extends AppCompatActivity {

    String[] names={"Karan","Kasish","Karn","Kumar","Kunal"};
    String [] fonts={"normal","monospace","sans","serif"};
    AutoCompleteTextView actvTextBox;
    Switch mySwitch;
    CheckBox checkBox;
    TimePicker timePicker;
    Typeface[] tf = {Typeface.DEFAULT,Typeface.MONOSPACE,Typeface.SANS_SERIF,Typeface.SERIF};
    int selected_tf=0;
    boolean bold = true;
    Spinner spinner;
    @Override

    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_ui_controls);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (this,R.layout.list_view_item_layout,names);
        ArrayAdapter<String> fontArrayAdapter = new ArrayAdapter<String> (this,R.layout.list_view_item_layout,fonts);
        spinner = (Spinner)findViewById (R.id.spinner);
        mySwitch = (Switch)findViewById (R.id.switch1);
        actvTextBox = (AutoCompleteTextView)findViewById (R.id.actvTextBox);
        checkBox = (CheckBox)findViewById (R.id.chkBoxClockEnable);
        timePicker = (TimePicker)findViewById (R.id.timePicker);

        spinner.setAdapter (fontArrayAdapter);
        actvTextBox.setThreshold (2);
        actvTextBox.setAdapter (arrayAdapter);
        spinner.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected (AdapterView<?> parent, View view, int position, long id) {

                selected_tf = position;
                if (bold)
                    actvTextBox.setTypeface (tf[selected_tf], Typeface.BOLD);
                else actvTextBox.setTypeface (tf[selected_tf], Typeface.NORMAL);
            }

            @Override
            public void onNothingSelected (AdapterView<?> parent) {

            }
        });

        mySwitch.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {

                bold = isChecked;
                if (bold)
                    actvTextBox.setTypeface (tf[selected_tf], Typeface.BOLD);
                else actvTextBox.setTypeface (tf[selected_tf], Typeface.NORMAL);
            }
        });

        checkBox.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {
                timePicker.setEnabled (isChecked);
            }
        });
    }
}
