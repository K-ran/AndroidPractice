package ankita.myapplication.UiTask2Practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ankita.myapplication.R;

/**
 * Created by karan on 10/6/16.
 */
public class UiTask2ArrayAdapter extends ArrayAdapter<TravelInfo> {

    public UiTask2ArrayAdapter(Context context,ArrayList<TravelInfo> info){
        super(context,0,info);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView!=null)
            return convertView;
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.ui_task_2_list_item,parent,false);
        ((TextView)convertView.findViewById(R.id.tvDistance)).setText(getItem(position).totalDisatnce);
        ((TextView)convertView.findViewById(R.id.tvUpperFromCost)).setText("$"+getItem(position).fair);
        ((TextView)convertView.findViewById(R.id.tvUpperFromLocation)).setText(getItem(position).fromAddress);
        ((TextView)convertView.findViewById(R.id.tvUpperFromCountry)).setText(getItem(position).fromCity+" "+getItem(position).fromCountry);
        ((TextView)convertView.findViewById(R.id.tvUpperFromDate)).setText(getItem(position).fromdate);
        ((TextView)convertView.findViewById(R.id.tvUpperFromTime)).setText(getItem(position).fromtime);

        ((TextView)convertView.findViewById(R.id.tvLowerFromLocation)).setText(getItem(position).toAddress);
        ((TextView)convertView.findViewById(R.id.tvLowerFromCountry)).setText(getItem(position).toCity+" "+getItem(position).toCountry);
        ((TextView)convertView.findViewById(R.id.tvLowerFromDate)).setText(getItem(position).todate);
        ((TextView)convertView.findViewById(R.id.tvLowerFromTime)).setText(getItem(position).totime);
        return convertView;
    }
}
