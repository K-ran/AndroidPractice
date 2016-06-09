package ankita.myapplication.sharedPreferencePrectice;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ankita.myapplication.R;

public class PrecticeSharedPreference extends AppCompatActivity {

    EditText etName;
    SharedPreferences sharedPreferences;
    TextView tvSave;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_prectice_shared_preference);
        etName = (EditText)findViewById (R.id.etSharedPreferencesName);
        tvSave = (TextView)findViewById (R.id.tvSharedPreferenceTwo);
        sharedPreferences = getPreferences (MODE_PRIVATE);
        String name = sharedPreferences.getString ("name","-");
        tvSave.setText (name);
    }

    public void saveName(View view){
        String name = etName.getText ().toString ();
        SharedPreferences.Editor editor = sharedPreferences.edit ();
        editor.putString ("name",name);
        editor.commit ();
        tvSave.setText (name);
    }
    public void removeName(View view){
        SharedPreferences.Editor editor = sharedPreferences.edit ();
        editor.clear ();
        editor.commit ();
        tvSave.setText ("-");
    }
}
