package ankita.myapplication.customList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import ankita.myapplication.R;

public class PracticeCustomListView extends AppCompatActivity {
    User[] users={new User ("asds","123","Jodhpur"),new User ("Ram","233","Ayodhya"),
                  new User ("Sai","123","Ladhak"),new User ("Sh","233","Ayodhya"),
                  new User ("God","333","Jaipur"),new User ("Gal","23","Ayodhya"),
                  new User ("Kn2","123","Jodhpur"),new User ("Rm2","233","Ayodhya")
                };
    ListView listView;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_custom_list_view);
        listView = (ListView)findViewById (R.id.lvCustomListView);
        CustomListAdapter customListAdapter = new CustomListAdapter (this,users);
        listView.setAdapter (customListAdapter);
        listView.setItemsCanFocus (true);
    }
}
