package ankita.myapplication.sqlLiteDatabasePractice;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ankita.myapplication.R;

public class PracticeSqllite extends AppCompatActivity {

    ListView lv;
    EditText etMarks;
    EditText etNames;
    CustomArrayAdapter studentAdapter;
    ArrayList<StudentData>student = new ArrayList<StudentData>();

    MyDBHelper mydb;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_sqllite);
        mydb = new MyDBHelper (this);
        lv=(ListView)findViewById (R.id.lvSqliteValeList);
        etMarks=(EditText)findViewById (R.id.etMarks);
        etNames=(EditText)findViewById (R.id.etName);
        studentAdapter = new CustomArrayAdapter(this,student);
        lv.setAdapter(studentAdapter);
        displayData(null);
    }


    public void displayData(View view) {
        Cursor cursor = mydb.getData ();
        studentAdapter.clear();
        while (cursor.moveToNext ()) {
            String s = cursor.getString (0) + " " + cursor.getString (1) + " " + cursor.getString (2);
            studentAdapter.add(new StudentData(Integer.parseInt(cursor.getString(0)),
                                                cursor.getString(1),
                                                Integer.parseInt(cursor.getString(2))
                                                )
                             );
        }
        studentAdapter.notifyDataSetChanged();
    }

    public void insertData(View view){
        mydb.insert (etNames.getText ().toString (),Integer.parseInt (etMarks.getText ().toString ()));
        displayData(view);
        Toast.makeText (PracticeSqllite.this, "Inserted", Toast.LENGTH_SHORT).show ();
    }
    public void removeData(int id){
        mydb.remove (id);
        Toast.makeText (PracticeSqllite.this, "Removed", Toast.LENGTH_SHORT).show ();
    }
}
