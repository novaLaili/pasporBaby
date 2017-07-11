package com.example.laili.pasporbayi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class RiwayatKelahiranActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPrefManager manager;

    EditText nama_RS, penolong_persanlinan_Dokterobs,
            penolong_persalinan_DokterAnak, umur_kelahiran,
            apgar_scope, BBL, PBL, LK, LD, tali_pusat_pj, air_ketuban_warna, air_ketuban_bau,
            placenta_berat, placenta_kelahiran, goldar;

    RadioGroup grupKondisiLahir, grupLetakJanin, grupCaraLahir, grupLilitan, grupProlaps, grupInsersi, grupJumlah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_riwayat_kelahiran);

        manager = SharedPrefManager.getmInstance(this);

        ImageButton next = (ImageButton) findViewById(R.id.buttonNext);
        ImageButton home = (ImageButton) findViewById(R.id.buttonHome);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputData();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonHome:
                        Intent openRKAActivity = new Intent(RiwayatKelahiranActivity.this, NavActivity.class);
                        startActivity(openRKAActivity);
                }
            }
        });
        nama_RS = (EditText) findViewById(R.id.editTextNamaRS);
        penolong_persanlinan_Dokterobs = (EditText) findViewById(R.id.editTextDokterObs);
        penolong_persalinan_DokterAnak = (EditText) findViewById(R.id.editTextDokterAnak);
        umur_kelahiran = (EditText) findViewById(R.id.editTextumurKelahiran);
        apgar_scope = (EditText) findViewById(R.id.editTextApgarScope);
        BBL = (EditText) findViewById(R.id.editTextBBLahir);
        PBL = (EditText) findViewById(R.id.editTextPBLahir);
        LK = (EditText) findViewById(R.id.editTextPBLahir);
        LD = (EditText) findViewById(R.id.editTextLingkarDada);
        tali_pusat_pj = (EditText) findViewById(R.id.editTextpanjang);
        air_ketuban_warna = (EditText) findViewById(R.id.editTextwarnaKetuban);
        air_ketuban_bau = (EditText) findViewById(R.id.editTextbauKetuban);
        placenta_berat = (EditText) findViewById(R.id.editTextberatPlacenta);
        placenta_kelahiran = (EditText) findViewById(R.id.editTextklhrnPlacenta);
        goldar = (EditText) findViewById(R.id.editTextgoldar);
        grupKondisiLahir = (RadioGroup) findViewById(R.id.group1);
        grupLetakJanin = (RadioGroup) findViewById(R.id.group2);
        grupCaraLahir = (RadioGroup) findViewById(R.id.group3);
        grupLilitan = (RadioGroup) findViewById(R.id.group4);
        grupProlaps = (RadioGroup) findViewById(R.id.group5);
        grupInsersi = (RadioGroup) findViewById(R.id.groupInsersi);
        grupJumlah = (RadioGroup) findViewById(R.id.group6);

    }

    private void InputData() {
            int RadiobuttonKondisiLahir = grupKondisiLahir.getCheckedRadioButtonId();
            int RadiobuttonLetakJanin = grupLetakJanin.getCheckedRadioButtonId();
            int RadiobuttonCaraLahir = grupCaraLahir.getCheckedRadioButtonId();
            int RadiobuttonLilitan = grupLilitan.getCheckedRadioButtonId();
            int RadiobuttonProlaps = grupProlaps.getCheckedRadioButtonId();
            int RadiobuttonInsersi = grupInsersi.getCheckedRadioButtonId();
            int RadiobuttonJumlah = grupJumlah.getCheckedRadioButtonId();

            RadioButton selectedKondisiLahir = (RadioButton) findViewById(RadiobuttonKondisiLahir);
            RadioButton selectedLetakJanin = (RadioButton) findViewById(RadiobuttonLetakJanin);
            RadioButton selectedCaraLahir = (RadioButton) findViewById(RadiobuttonCaraLahir);
            RadioButton selectedLilitan = (RadioButton) findViewById(RadiobuttonLilitan);
            RadioButton selectedProlaps = (RadioButton) findViewById(RadiobuttonProlaps);
            RadioButton selectedInsersi = (RadioButton) findViewById(RadiobuttonInsersi);
            RadioButton selectedJumlah = (RadioButton) findViewById(RadiobuttonJumlah);


            final String vJumlah = selectedJumlah.getText().toString();
            final String vKondisi_lahir = selectedKondisiLahir.getText().toString();
            final String vLetak_janin = selectedLetakJanin.getText().toString();
            final String vCara_lahir = selectedCaraLahir.getText().toString();
            final String vLilitan = selectedLilitan.getText().toString();
            final String vProlaps = selectedProlaps.getText().toString();
            final String vInsersi = selectedInsersi.getText().toString();
            final String vNama_RS = nama_RS.getText().toString().trim();
            final String vPenolong_persalinan_DokterAnak = penolong_persalinan_DokterAnak.getText().toString().trim();
            final String vPenolong_persanlinan_Dokterobs = penolong_persanlinan_Dokterobs.getText().toString().trim();
            final String vUmur_kelahiran = umur_kelahiran.getText().toString().trim();
            final String vApgar_scope = apgar_scope.getText().toString().trim();
            final String vBBL = BBL.getText().toString().trim();
            final String vPBL = PBL.getText().toString().trim();
            final String vLK = LK.getText().toString().trim();
            final String vLD = LD.getText().toString().trim();
            final String vTali_pusat_pj = tali_pusat_pj.getText().toString().trim();
            final String vAir_ketuban_warna = air_ketuban_warna.getText().toString().trim();
            final String vAir_ketuban_bau = air_ketuban_bau.getText().toString().trim();
            final String vPlacenta_berat = placenta_berat.getText().toString().trim();
            final String vPlacenta_kelahiran = placenta_kelahiran.getText().toString().trim();
            final String vGoldar = goldar.getText().toString().trim();


            StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.102/pasporBayi_TA/form_riwayat_kelahiran.php",
//            StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.100/pasporBayi_TA/form_riwayat_kelahiran.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (!response.equals("oops! Please try again")) {
                                Config.SetString(RiwayatKelahiranActivity.this, "id_riwayat_kelahiran", response);
                                Log.d("id_riwayat_kelahiran",response);
                                Intent openRKAActivity = new Intent(RiwayatKelahiranActivity.this, RiwayatKesehatanActivity.class);
                                startActivity(openRKAActivity);
                            }
//                        Toast.makeText(PendaftaranActivity.this,response,Toast.LENGTH_LONG).show();

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("Test", "Ini request error " +error.getMessage());
                            Toast.makeText(RiwayatKelahiranActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    String id_anak = Config.GetString(RiwayatKelahiranActivity.this, "id_anak");
                    params.put("id_anak", id_anak);
                    params.put("nama_RS", vNama_RS);
                    params.put("penolong_persalinan_DokterAnak", vPenolong_persalinan_DokterAnak);
                    params.put("penolong_persanlinan_Dokterobs", vPenolong_persanlinan_Dokterobs);
                    params.put("umur_kelahiran", vUmur_kelahiran);
                    params.put("kondisi_lahir", vKondisi_lahir);
                    params.put("letak_janin", vLetak_janin);
                    params.put("cara_lahir", vCara_lahir);
                    params.put("apgar_scope", vApgar_scope);
                    params.put("BBL", vBBL);
                    params.put("PBL", vPBL);
                    params.put("LK", vLK);
                    params.put("LD", vLD);
                    params.put("tali_pusat_pj", vTali_pusat_pj);
                    params.put("tali_pusat_lilitan", vLilitan);
                    params.put("tali_pusat_prolaps", vProlaps);
                    params.put("tali_pusat_insersi", vInsersi);
                    params.put("air_ketuban_warna", vAir_ketuban_warna);
                    params.put("air_ketuban_bau", vAir_ketuban_bau);
                    params.put("air_ketuban_jumlah", vJumlah);
                    params.put("placenta_berat", vPlacenta_berat);
                    params.put("placenta_kelahiran", vPlacenta_kelahiran);
                    params.put("goldar", vGoldar);
                    return params;


                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }



    @Override
    public void onClick(View v) {

    }
}