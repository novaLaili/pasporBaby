package com.example.laili.pasporbayi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Laili on 12/04/2017.
 */

public class DAdapter extends RecyclerView.Adapter <DAdapter.DViewHolder> {

    Context context;

    public DAdapter(Context context){
        this.context = context;
    }
    @Override
    public DViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new DViewHolder(LayoutInflater.from(context).inflate(R.layout.dummy_layout,null,false));
    }

    @Override
    public void onBindViewHolder(DViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class DViewHolder extends RecyclerView.ViewHolder{

        public DViewHolder(View itemView) {
            super(itemView);
        }
    }
}
