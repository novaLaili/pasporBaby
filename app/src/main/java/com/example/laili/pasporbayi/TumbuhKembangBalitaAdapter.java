package com.example.laili.pasporbayi;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Laili on 17/05/2017.
 */

public class TumbuhKembangBalitaAdapter extends BaseAdapter {

    private Context context;
    Cursor c;

    public TumbuhKembangBalitaAdapter(Context context, Cursor c){
        super();
        this.context = context;
        this.c = c;
    }
    @Override
    public int getCount() {
        return c.getCount();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.perkembangan_data, null);
        c.moveToPosition(position);

//        if(position)
//        int umur = c.getInt(c.getColumnIndex("umur"));
//        String bidang = c.getInt(c.getColumnIndex("umur"));
        return null;
    }
}
