package com.example.laili.pasporbayi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import java.util.Map;

public class CatatanImunisasiActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPrefManager manager;
    EditText tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_imunisasi);

        manager = SharedPrefManager.getmInstance(this);

        Button buttonCatatanImunisasi = (Button) findViewById(R.id.buttonHasil);
        buttonCatatanImunisasi.setOnClickListener(this);
        buttonCatatanImunisasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonHasil:
                        Intent openHasilActivity = new Intent(CatatanImunisasiActivity.this, HasilImunisasiActivity.class);
                        startActivity(openHasilActivity);
                }

            }
        });
        tanggal = (EditText) findViewById(R.id.HB_1bulan);
    }
    private void registerUser(){
        final String vTanggal = tanggal.getText().toString().trim();
    StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://10.252.133.161/pasporBayi_TA/form_data_anak.php",
            //StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.103/pasporBayi_TA/form_data_anak.php",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if(response.equals("successfully input")){
                        Intent openRKAActivity = new Intent(CatatanImunisasiActivity.this, HasilImunisasiActivity.class);
                        startActivity(openRKAActivity);
                    }
                    Toast.makeText(CatatanImunisasiActivity.this, response, Toast.LENGTH_SHORT).show();
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("Test", "Ini request error " +error.getMessage());
                    Toast.makeText(CatatanImunisasiActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                }
            }) {
        @Override
        protected Map<String, String> getParams() {
            Map<String, String> params = new HashMap<String, String>();
            params.put("taggal", vTanggal);
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
