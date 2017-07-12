package com.example.laili.pasporbayi.tumbuhkembang;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.laili.pasporbayi.R;

import java.util.ArrayList;

/**
 * Created by Bend on 6/14/2017.
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<ObjectExpandableTumbuhKembang> listData;

    public ExpandableAdapter(Context context, ArrayList<ObjectExpandableTumbuhKembang> listData){
        this.context = context;
        this.listData = listData;
    }

    @Override
    public int getGroupCount() {
        return listData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listData.get(groupPosition).getVar().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listData.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listData.get(groupPosition).getVar().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return listData.indexOf(listData.get(groupPosition));
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return listData.get(groupPosition).getVar().indexOf(listData.get(groupPosition).getVar().get(childPosition));
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.tumbuhkembangbalita_list_group, viewGroup, false);
        }

        TextView lblListHeader = (TextView)convertView.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(listData.get(groupPosition).getUmur());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View convertView, ViewGroup viewGroup) {

        final int groupIndex = groupPosition;
        final int childIndex = childPosition;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.tumbuhkembangbalita_list_item, viewGroup, false);
        }

        TextView keteranganChild = (TextView) convertView.findViewById(R.id.ket);
        TextView bidangChild = (TextView) convertView.findViewById(R.id.bidang);
        CheckBox checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);

        keteranganChild.setText(listData.get(groupPosition).getVar().get(childPosition).getGerak());
        bidangChild.setText(listData.get(groupPosition).getVar().get(childPosition).getPerkembangan());

        if(listData.get(groupPosition).getVar().get(childPosition).getStatus() == 1){
            checkbox.setChecked(true);
        }else{
            checkbox.setChecked(false);
        }

        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listData.get(groupIndex).getVar().get(childIndex).setStatus(listData.get(groupIndex).getVar().get(childIndex).getStatus() == 0 ? 1 : 0);
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
