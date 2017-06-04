package com.example.laili.pasporbayi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StatusGiziActivity extends AppCompatActivity implements View.OnClickListener {
    EditText umurTahun, umurBulan, jenis_kelamin, berat, tinggi, lingkar_kepala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_status_gizi);

        Button buttonHasil = (Button) findViewById(R.id.buttonHasilSG);
        buttonHasil.setOnClickListener(this);

        umurTahun = (EditText) findViewById(R.id.editTextUmurTahun);
        umurBulan = (EditText) findViewById(R.id.editTextUmurBulan);
        jenis_kelamin = (EditText) findViewById(R.id.editTextJnsKelamin);
        berat = (EditText) findViewById(R.id.editTextberat);
        tinggi = (EditText) findViewById(R.id.editTextTinggi);
        lingkar_kepala = (EditText) findViewById(R.id.editTextLK);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonHasilSG:
                Intent openHasilSGActivity = new Intent(StatusGiziActivity.this, HasilStatusGiziActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("jenis_kelamin", jenis_kelamin.getText().toString());
                bundle.putInt("tahun", Integer.parseInt(umurTahun.getText().toString()) );
                bundle.putInt("bulan", Integer.parseInt(umurBulan.getText().toString()) );
                bundle.putDouble("berat", Double.parseDouble(berat.getText().toString()));
                bundle.putDouble("tinggi", Double.parseDouble(tinggi.getText().toString()));
                openHasilSGActivity.putExtras(bundle);//put Extras fungsinya untuk melemparkan data antara activity status gizi ke hasilstatusgizi
                startActivity(openHasilSGActivity);
                break;
        }
    }
}
