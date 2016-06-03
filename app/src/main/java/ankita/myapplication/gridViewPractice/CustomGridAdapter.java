package ankita.myapplication.gridViewPractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import ankita.myapplication.R;

/**
 * Created by ankita on 3/6/16.
 */
public class CustomGridAdapter extends BaseAdapter {
    String [] labels;
    TextView tv;
    Context context;
    public CustomGridAdapter (Context context,String[] labels,TextView tv) {
        this.labels = labels;
        this.context=context;
        this.tv = tv;
    }

    @Override
    public int getCount () {
        return labels.length;
    }

    @Override
    public long getItemId (int position) {

        return position;
    }

    @Override
    public Object getItem (int position) {
        return position;
    }

    @Override
    public View getView (final int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=LayoutInflater.from (context).inflate (R.layout.grid_list_item,parent,false);
        }
        else return convertView;
        Button button = (Button)convertView.findViewById (R.id.btnGridVala);
        button.setText (labels[position]);
        convertView.setLayoutParams (new GridView.LayoutParams (GridView.AUTO_FIT,160));
        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                tv.setText (tv.getText ().toString ()+labels[position]);
            }
        });
        return convertView;
    }
}
