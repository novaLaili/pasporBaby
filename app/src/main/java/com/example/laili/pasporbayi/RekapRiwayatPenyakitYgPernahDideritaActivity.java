package com.example.laili.pasporbayi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RekapRiwayatPenyakitYgPernahDideritaActivity extends AppCompatActivity implements View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rekap_riwayat_penyakit_yg_pernah_diderita);

        Button home = (Button) findViewById(R.id.buttonHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonHome :
                        Intent openRKAActivity = new Intent(RekapRiwayatPenyakitYgPernahDideritaActivity.this, MainActivity.class);
                        startActivity(openRKAActivity);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
    }
}
