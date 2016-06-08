package ankita.myapplication.sqlLiteDatabasePractice;

import android.app.AlertDialog;
import android.content.Context;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import ankita.myapplication.R;

/**
 * Created by karan on 7/6/16.
 */
public class CustomArrayAdapter extends ArrayAdapter<StudentData> {
    ArrayList<StudentData> myData;
    public CustomArrayAdapter(Context context, ArrayList<StudentData> data){
        super(context,0,data);
        myData =data;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.sqlite_vala_list_item,parent,false);
        final StudentData studentData = getItem(position);
        TextView tvId = (TextView)convertView.findViewById(R.id.tvsqlId);
        final TextView tvName = (TextView)convertView.findViewById(R.id.tvsqlName);
        final TextView tvMarks = (TextView)convertView.findViewById(R.id.tvsqlMarks);
        Button btn = (Button)convertView.findViewById(R.id.btnsqlDeleteMe);
        Button btnedit = (Button)convertView.findViewById(R.id.btnsqlEditMe);
        tvId.setText(studentData.id+"");
        tvName.setText(studentData.name);
        tvMarks.setText(studentData.marks+"");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentData studentData1 = getItem(position);
                myData.remove(position);
                notifyDataSetChanged();
                ((PracticeSqllite) getContext()).removeData(studentData.id);
            }
        });

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                http://www.mkyong.com/android/android-prompt-user-input-dialog-example/
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        getContext());
                View prompt =  LayoutInflater.from(getContext()).inflate(R.layout.sql_alert_box, null);
                alertDialogBuilder.setView(LayoutInflater.from(getContext()).inflate(R.layout.sql_alert_box,null));

            }
        });

        return convertView;
    }
}
