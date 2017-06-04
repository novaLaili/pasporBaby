package com.example.laili.pasporbayi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RekapTumbuhKembangActivity extends AppCompatActivity {

    Button edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekap_tumbuh_kembang);

        edit = (Button) findViewById(R.id.idEdit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RekapTumbuhKembangActivity.this, MainTumbuhKembangActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
