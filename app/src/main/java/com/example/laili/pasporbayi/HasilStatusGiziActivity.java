package com.example.laili.pasporbayi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class HasilStatusGiziActivity extends AppCompatActivity implements View.OnClickListener {

    TextView pesan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_status_gizi);

        ImageButton home = (ImageButton) findViewById(R.id.buttonHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonHome:
                        Intent openRKAActivity = new Intent(HasilStatusGiziActivity.this, MainActivity.class);
                        startActivity(openRKAActivity);
                }
            }
        });

        pesan = (TextView) findViewById(R.id.pesan);
        hasilData();
    }

    private void hasilData(){
        Bundle bundle = getIntent().getExtras();
        String jenis_kelamin = bundle.getString("jenis_kelamin", null);
        int tahun = bundle.getInt("tahun");
        int bulan = bundle.getInt("bulan");
        double berat_badan = bundle.getInt("berat");
        double tinggi_badan = bundle.getInt("tinggi");

        TabelSD tabelSD = TabelSD.getInstance();
        int SD = tabelSD.search(jenis_kelamin, tahun, bulan, berat_badan, tinggi_badan);

        if (SD==0){
            pesan.setText("Selamat ya Bunda, balita bunda sehat. Pada usia "+tahun+" tahun "+bulan+" bulannya yang sekarang\n" +
                    "Pastikan bunda mengawasi tumbuh kembangnya dengan rutin");
        }
        else if(SD==-1)
            pesan.setText("Selamat ya Bunda, balita bunda sehat. Pada usia "+tahun+" tahun "+bulan+" bulannya yang sekarang\n" +
                    "Pastikan bunda mengawasi tumbuh kembangnya dengan rutin");
        else if(SD==-2)
            pesan.setText("Selamat ya Bunda, balita bunda sehat. Pada usia "+tahun+" tahun "+bulan+" bulannya yang sekarang\n" +
                    "Pastikan bunda mengawasi tumbuh kembangnya dengan rutin");
        else if(SD==-3)
            pesan.setText("Bun, di usia balita bunda "+tahun+" tahun "+bulan+" bulannya seharusnya balita bunda memiliki berat "+berat_badan+" dan tinggi "+tinggi_badan+"\n" +
                    "segera periksakan balita Bunda ke dokter ya Bun. Pastikan bunda mengawasi tumbuh kembangnya dengan rutin");
        else{
            pesan.setText("Bunda, balita bunda berada di atas 0 SD segera periksakan balita bunda ke fasilitas kesehatan ya bun");
        }
    }

    @Override
    public void onClick(View v) {

    }
}