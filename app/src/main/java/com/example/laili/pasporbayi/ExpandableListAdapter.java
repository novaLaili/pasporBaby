package com.example.laili.pasporbayi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laili.pasporbayi.R;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String[]>> _listDataChild;
    private HashMap<Integer, ArrayList<Integer>> flag = new HashMap<>();
    //private int[][] flag;


    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String[]>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;

        for (int i = 0; i < listDataHeader.size(); i++) {
            ArrayList<Integer> zero = new ArrayList<>();
            for (int j = 0; j < listChildData.get(listDataHeader.get(i)).size(); j++) {
                zero.add(0);
            }
            flag.put(i, zero);
        }
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final int index = childPosition;

        String childText[] = new String[2];
        childText= (String[]) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.tumbuhkembangbalita_list_item, null);
        }

        TextView keteranganChild = (TextView) convertView.findViewById(R.id.ket);
        TextView bidangChild = (TextView) convertView.findViewById(R.id.bidang);
        CheckBox checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);

        if (flag.get(groupPosition).get(childPosition) == 1){
            checkbox.setChecked(true);
        }else{
            checkbox.setChecked(false);
        }

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    flag.get(groupPosition).set(childPosition, 1);
                else
                    flag.get(groupPosition).set(childPosition, 0);

                Toast.makeText(_context, ""+flag.get(groupPosition).get(0), Toast.LENGTH_SHORT).show();
            }
        });

        keteranganChild.setText(childText[0]);
        bidangChild.setText(childText[1]);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.tumbuhkembangbalita_list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
