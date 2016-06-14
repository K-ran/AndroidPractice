package ankita.myapplication.ToolBarPractice;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import ankita.myapplication.R;

public class PracticeToolbar extends AppCompatActivity {

    ActionBar ab;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_toolbar);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar (myToolbar);
        ab = getSupportActionBar ();
        ab.setDisplayHomeAsUpEnabled (true);
        ab.setHomeButtonEnabled (true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate (R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText (PracticeToolbar.this, "Settings", Toast.LENGTH_SHORT).show ();
                return true;

            case R.id.action_favorite:
                Toast.makeText (PracticeToolbar.this, "Favorite", Toast.LENGTH_SHORT).show ();
                return true;

            default:
                Toast.makeText (PracticeToolbar.this, "Default", Toast.LENGTH_SHORT).show ();
                return super.onOptionsItemSelected(item);

        }
    }
}
