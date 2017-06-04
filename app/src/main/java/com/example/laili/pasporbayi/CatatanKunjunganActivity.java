package com.example.laili.pasporbayi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class CatatanKunjunganActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPrefManager manager;
    EditText tanggal, umur, BB, PB, LK, hasil_pemeriksaaan, pengobatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_catatan_kunjungan);

        manager = SharedPrefManager.getmInstance(this);

        Button buttonCatatanKunjungan = (Button) findViewById(R.id.buttonTabelCatK);
        buttonCatatanKunjungan.setOnClickListener(this);

        buttonCatatanKunjungan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
            }
            User();
        }
    });

        tanggal = (EditText) findViewById(R.id.editTextTanggal);
        umur = (EditText) findViewById(R.id.editTextUmur);
        BB = (EditText) findViewById(R.id.editTextberatBadan);
        PB = (EditText) findViewById(R.id.editTextpanjangBadan);
        LK = (EditText) findViewById(R.id.editTextLK);
        hasil_pemeriksaaan = (EditText) findViewById(R.id.editTextPemeriksaan);
        pengobatan = (EditText) findViewById(R.id.editTextPengobatan);
    }

    private void User(){
        final String vTanggal = tanggal.getText().toString().trim();
        final String vUmur = umur.getText().toString().trim();
        final String vBerat_badan = BB.getText().toString().trim();
        final String vPanjang_badan = PB.getText().toString().trim();
        final String vLingkar_kepala = LK.getText().toString().trim();
        final String vPemeriksaan = hasil_pemeriksaaan.getText().toString().trim();
        final String vPengobatan = pengobatan.getText().toString().trim();


        StringRequest request = new StringRequest(Request.Method.POST, "127.0.0.1",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        //StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://10.252.128.198/pasporBayi_TA/catatan_kunjungan.php",
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.43.50/pasporBayi_TA/form_catatan_kunjungan.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("successfully input")){
                            Intent openCKAActivity = new Intent(CatatanKunjunganActivity.this, TabelCatKunjunganActivity.class);
                            startActivity(openCKAActivity);
                        }
                        Toast.makeText(CatatanKunjunganActivity.this, response, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(PendaftaranActivity.this,response,Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Test", "Ini request error " +error.getMessage());
                        Toast.makeText(CatatanKunjunganActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("tanggal",vTanggal);
                params.put("umur",vUmur);
                params.put("berat_badan",vBerat_badan);
                params.put("panjang_badan",vPanjang_badan);
                params.put("lingkar_kepala",vLingkar_kepala);
                params.put("hasil_pemeriksaan",vPemeriksaan);
                params.put("pengobatan",vPengobatan);
                params.put("id_anak",""+manager.getUserId());
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonTabelCatK:
                Intent openHasilTKActivity = new Intent(CatatanKunjunganActivity.this, TabelCatKunjunganActivity.class);
                startActivity(openHasilTKActivity);
                break;
        }

    }
}
