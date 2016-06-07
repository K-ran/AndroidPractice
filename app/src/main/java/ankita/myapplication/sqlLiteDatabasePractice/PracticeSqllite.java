package ankita.myapplication.sqlLiteDatabasePractice;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ankita.myapplication.R;
import ankita.myapplication.launcherActivity.MyDBHelper;

public class PracticeSqllite extends AppCompatActivity {

    TextView results;
    EditText etId;
    EditText etMarks;
    EditText etNames;


    MyDBHelper mydb;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_sqllite);
        mydb = new MyDBHelper (this);
        results=(TextView)findViewById (R.id.tvdisplay);
        etId=(EditText)findViewById (R.id.etId);
        etMarks=(EditText)findViewById (R.id.etMarks);
        etNames=(EditText)findViewById (R.id.etName);
    }


    public void displayData(View view) {
        Cursor cursor = mydb.getData ();
        results.setText ("");
        while (cursor.moveToNext ()) {
            String s = cursor.getString (0) + " " + cursor.getString (1) + " " + cursor.getString (2);
            results.append (s+"\n");
        }
    }

    public void insertData(View view){
        mydb.insert (etNames.getText ().toString (),Integer.parseInt (etMarks.getText ().toString ()));
        Toast.makeText (PracticeSqllite.this, "Inserted", Toast.LENGTH_SHORT).show ();
    }
    public void removeData(View view){
        mydb.remove (Integer.parseInt (etId.getText ().toString ()));
        Toast.makeText (PracticeSqllite.this, "Removed", Toast.LENGTH_SHORT).show ();
    }
}
