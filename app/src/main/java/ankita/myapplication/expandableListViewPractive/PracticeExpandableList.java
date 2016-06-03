package ankita.myapplication.expandableListViewPractive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import ankita.myapplication.R;

public class PracticeExpandableList extends AppCompatActivity {
    String[] heading={"Microsoft","Google","Apple"};
    String[][] list={
                    {"Office","Windows","HoloLens"},
                    {"Drive","Chrome","Car","Glass"},
                    {"iPhone","MacBook","iPad"}
                    };
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_expandable_list);
        ExpandableListView expandableListView = (ExpandableListView)findViewById (R.id.explv1);
        expandableListView.setAdapter (new ExpandableListViewAdapter(this,list,heading));
        expandableListView.setOnChildClickListener (new ExpandableListView.OnChildClickListener () {
            @Override
            public boolean onChildClick (ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast toast = Toast.makeText (getApplicationContext (), list[groupPosition][childPosition], Toast.LENGTH_SHORT);
                toast.show ();
                return true;
            }
        });
        expandableListView.setOnGroupExpandListener (new ExpandableListView.OnGroupExpandListener () {
            @Override
            public void onGroupExpand (int groupPosition) {

            }
        });
    }
}
