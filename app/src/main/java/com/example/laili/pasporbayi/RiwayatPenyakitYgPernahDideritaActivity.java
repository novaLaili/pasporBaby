package com.example.laili.pasporbayi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class RiwayatPenyakitYgPernahDideritaActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dra_riwayat_penyakit_yg_pernah_diderita);
        Button next = (Button) findViewById(R.id.buttonNext);
        Button home = (Button) findViewById(R.id.buttonHome);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonNext :
                        Intent openRKAActivity = new Intent(RiwayatPenyakitYgPernahDideritaActivity.this, LoginPageActivity.class);
                        startActivity(openRKAActivity);
                }
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonHome :
                        Intent openRKAActivity = new Intent(RiwayatPenyakitYgPernahDideritaActivity.this, MainActivity.class);
                        startActivity(openRKAActivity);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
    }
}