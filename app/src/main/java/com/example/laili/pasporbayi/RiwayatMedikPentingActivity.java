package com.example.laili.pasporbayi;

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


public class RiwayatMedikPentingActivity extends AppCompatActivity implements View.OnClickListener {

    EditText alergi, penyakit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dra_form_riwayat_medik_penting);
        Button next = (Button) findViewById(R.id.buttonNext);
        Button home = (Button) findViewById(R.id.buttonHome);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonNext :
                        InputData();
                }
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonHome :
                        Intent openRKAActivity = new Intent(RiwayatMedikPentingActivity.this, MainActivity.class);
                        startActivity(openRKAActivity);
                }
            }
        });

        alergi = (EditText) findViewById(R.id.editTextAlergi);
        penyakit = (EditText) findViewById(R.id.editTextPnykt);
    }

    public void InputData(){
        final String vAlergi = alergi.getText().toString();
        final String vPenyakit = penyakit.getText().toString();

    StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://10.252.130.173/pasporBayi_TA/form_riwayat_medik_penting.php",
//            StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.100/pasporBayi_TA/form_riwayat_kelahiran.php",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (!response.equals("oops! Please try again")) {
                        Intent openRKAActivity = new Intent(RiwayatMedikPentingActivity.this, RiwayatKesehatanActivity.class);
                        startActivity(openRKAActivity);
                    }
//                        Toast.makeText(PendaftaranActivity.this,response,Toast.LENGTH_LONG).show();

                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("Test", "Ini request error " +error.getMessage());
                    Toast.makeText(RiwayatMedikPentingActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                }
            }) {
        @Override
        protected Map<String, String> getParams() {
            Map<String, String> params = new HashMap<String, String>();
            String id_anak = Config.GetString(RiwayatMedikPentingActivity.this, "id_anak");
            params.put("id_anak", id_anak);
            params.put("riwayat_alergi_obat", vAlergi);
            params.put("riwayat_penyakit_dalam_keluarga", vPenyakit);
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