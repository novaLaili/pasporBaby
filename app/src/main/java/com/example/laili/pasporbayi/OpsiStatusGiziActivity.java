package com.example.laili.pasporbayi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OpsiStatusGiziActivity extends AppCompatActivity {

    TextView BeratBUmur, TinggiBUmur, LingkarKUmur, BeratBTinggi, BeratBTBUmur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opsi_status_gizi);

        BeratBTBUmur = (TextView) findViewById(R.id.BBTBUmur);
        BeratBUmur = (TextView) findViewById(R.id.BBUmur);
        TinggiBUmur = (TextView) findViewById(R.id.TBUmur);
        LingkarKUmur = (TextView) findViewById(R.id.LKUmur);
        BeratBTinggi = (TextView) findViewById(R.id.BBTinggi);

        BeratBUmur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpsiStatusGiziActivity.this, HasilStatusGiziActivity.class);
                startActivity(intent);
            }
        });

        BeratBTBUmur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openHTKActivity = new Intent(OpsiStatusGiziActivity.this, MainActivity.class);
                startActivity(openHTKActivity);
            }
        });

        TinggiBUmur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpsiStatusGiziActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        LingkarKUmur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpsiStatusGiziActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        BeratBTinggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpsiStatusGiziActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
