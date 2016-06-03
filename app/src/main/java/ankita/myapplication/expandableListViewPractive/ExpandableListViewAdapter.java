package ankita.myapplication.expandableListViewPractive;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import ankita.myapplication.R;

/**
 * Created by ankita on 3/6/16.
 */
public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    Context context;
    String[][] list;
    String[] headings;

    public ExpandableListViewAdapter (Context context, String[][] list,String[] headings) {
        this.list = list;
        this.context = context;
        this.headings=headings;
    }

    @Override
    public int getGroupCount () {
        return list.length;
    }

    @Override
    public int getChildrenCount (int groupPosition) {
        return list[groupPosition].length;
    }

    @Override
    public Object getGroup (int groupPosition) {

        return groupPosition;
    }

    @Override
    public Object getChild (int groupPosition, int childPosition) {

        return childPosition;
    }

    @Override
    public long getGroupId (int groupPosition) {

        return groupPosition;
    }

    @Override
    public long getChildId (int groupPosition, int childPosition) {

        return childPosition;
    }

    @Override
    public boolean hasStableIds () {

        return false;
    }

    @Override
    public View getGroupView (int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//        if(convertView==null){
            convertView = LayoutInflater.from (context).inflate (R.layout.explv_group_item_view,parent,false);
//        }
//        else return convertView;
        TextView textView = (TextView)convertView.findViewById (R.id.tvExpGroupView);
        textView.setText ("    "+headings[groupPosition]);
        return convertView;
    }

    @Override
    public View getChildView (int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//        if(convertView==null){
            convertView = LayoutInflater.from (context).inflate (R.layout.explv_clild_item_view,parent,false);
//        }
//        else return convertView;
        TextView textView = (TextView)convertView.findViewById (R.id.tvExpChildView);
        textView.setText("-> "+list[groupPosition][childPosition]);
        return convertView;
    }

    @Override
    public boolean isChildSelectable (int groupPosition, int childPosition) {

        return true;
    }
}
