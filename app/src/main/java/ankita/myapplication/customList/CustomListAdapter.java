package ankita.myapplication.customList;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import ankita.myapplication.R;

/**
 * Created by ankita on 2/6/16.
 */
public class CustomListAdapter extends BaseAdapter {
    User [] users;
    Context context;
    public CustomListAdapter (Context context, User[] user) {
        super ();
        this.users=user;
        this.context=context;
    }

    @Override
    public int getCount () {

        return users.length;
    }

    @Override
    public View getView (final int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView =  LayoutInflater.from (context).inflate(R.layout.custom_list_item_layout, parent, false);
        else return convertView;

        final TextView Name=(TextView)convertView.findViewById (R.id.tvNameField);
        TextView City=(TextView)convertView.findViewById (R.id.tvCityField);
        TextView Phno=(TextView)convertView.findViewById (R.id.tvPhoneNumberField);
        Name.setText (users[position]._name);
        City.setText (users[position].city);
        Phno.setText (users[position].contact);
        Switch _switch = (Switch)convertView.findViewById (R.id.switchCustomListVala);
        _switch.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {
                Log.e ("Switch : ",isChecked+"");
                if(isChecked)
                    Name.setTypeface (null, Typeface.BOLD);
                else Name.setTypeface (null, Typeface.NORMAL);

            }
        });
        return convertView;
    }

    @Override
    public Object getItem (int position) {

        return position;
    }

    @Override
    public long getItemId (int position) {

        return position;
    }
}
