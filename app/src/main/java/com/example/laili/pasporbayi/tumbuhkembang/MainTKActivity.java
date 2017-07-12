package com.example.laili.pasporbayi.tumbuhkembang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.laili.pasporbayi.database.DAOTumbuhKembang;
import com.example.laili.pasporbayi.R;
import com.example.laili.pasporbayi.models.ModelTumbuhKembang;

import java.util.ArrayList;

/**
 * Created by Bend on 6/14/2017.
 */

public class MainTKActivity extends AppCompatActivity {

    private Button btnSubmit;
    private ExpandableListView mListView;

    private ArrayList<ObjectExpandableTumbuhKembang> listData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tumbuhkembangbalita_main_2);

        initList();
        initView();
    }

    private void initList(){
        ArrayList<ModelTumbuhKembang> listTK = DAOTumbuhKembang.getInstance(this).find();
        listData = new ArrayList<>();

        for (int i = 0; i < listTK.size(); i+=4) {
            ObjectExpandableTumbuhKembang obj = new ObjectExpandableTumbuhKembang();
            obj.setUmur(listTK.get(i).getUmur());
            obj.setVar(new ArrayList<ModelTumbuhKembang>());

            for (int j = i; j < i+4; j++) {
                obj.add(listTK.get(j));
            }

            listData.add(obj);
        }
    }

    private void initView(){
        btnSubmit = (Button)findViewById(R.id.idSubmit);
        mListView = (ExpandableListView)findViewById(R.id.lvExp);

        mListView.setAdapter(new ExpandableAdapter(this, listData));

        for (int i = 0; i < listData.size(); i++) {
            mListView.expandGroup(i);
        }

        mListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                mListView.expandGroup(i);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < listData.size(); i++) {
                    for (int j = 0; j < 4; j++) {
                        DAOTumbuhKembang.getInstance(MainTKActivity.this).updateStatus(listData.get(i).getVar().get(j));
                    }
                }

                Toast.makeText(MainTKActivity.this, "Data saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
