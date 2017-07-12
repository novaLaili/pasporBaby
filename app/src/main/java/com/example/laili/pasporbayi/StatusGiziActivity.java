package com.example.laili.pasporbayi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class StatusGiziActivity extends AppCompatActivity implements View.OnClickListener {

    //DataSD, HasilStatusGiziActivity, OpsiStatusGiziActivity, TabelSD, HasilStatusGiziActivity

    EditText umurTahun, umurBulan, jenis_kelamin, berat, tinggi, lingkar_kepala;
    SharedPrefManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_status_gizi);

        Button buttonHasil = (Button) findViewById(R.id.buttonHasilSG);
        buttonHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDataUser();
            }
        });

        umurTahun = (EditText) findViewById(R.id.editTextUmurTahun);
        umurBulan = (EditText) findViewById(R.id.editTextUmurBulan);
        jenis_kelamin = (EditText) findViewById(R.id.editTextJnsKelamin);
        berat = (EditText) findViewById(R.id.editTextberat);
        tinggi = (EditText) findViewById(R.id.editTextTinggi);
        lingkar_kepala = (EditText) findViewById(R.id.editTextLK);

    }

    public void InputDataUser() {
        final String vJenisKelamin = jenis_kelamin.getText().toString().trim();
        final String vUmurTahun = umurTahun.getText().toString().trim();
        final String vUmurBulan = umurBulan.getText().toString().trim();
        final String vBB = berat.getText().toString().trim();
        final String vTB = tinggi.getText().toString().trim();
        final String vLK = lingkar_kepala.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.43.50/pasporBayi_TA/form_status_gizi.php",
                //StringRequest stringRequest = new StringRequest(Request.Method.POST, "http:///192.168.0.105/pasporBayi_TA/form_data_anak.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.equals("oops! Please try again")) {
                            final Bundle bundle = new Bundle();
                            bundle.putString("jenis_kelamin", jenis_kelamin.getText().toString());
                            bundle.putInt("tahun", Integer.parseInt(umurTahun.getText().toString()));
                            bundle.putInt("bulan", Integer.parseInt(umurBulan.getText().toString()));
                            bundle.putDouble("berat", Float.parseFloat(berat.getText().toString()));
                            bundle.putDouble("tinggi", Float.parseFloat(tinggi.getText().toString()));
                            bundle.putDouble("lingkar_kepala", Float.parseFloat(lingkar_kepala.getText().toString()));
                            System.out.print(jenis_kelamin.getText().toString());
                            System.out.print(umurBulan.getText().toString());
                            System.out.print(umurTahun.getText().toString());
                            Intent openHasilSGActivity = new Intent(StatusGiziActivity.this, HasilStatusGiziActivity.class);
                            openHasilSGActivity.putExtras(bundle);//put Extras fungsinya untuk melemparkan data antara activity status gizi ke hasilstatusgizi
                            startActivity(openHasilSGActivity);

                        }
                        //Toast.makeText(DataAnakActivity.this, response, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(PendaftaranActivity.this,response,Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Test", "Ini request error " + error.getMessage());
                        Toast.makeText(StatusGiziActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                String id_anak = Config.GetString(StatusGiziActivity.this, "id_anak");
                params.put("id_anak", id_anak);
                params.put("umur_tahun", vUmurTahun);
                params.put("umur_bulan", vUmurBulan);
                params.put("jenis_kelamin", vJenisKelamin);
                params.put("berat_badan", vBB);
                params.put("tinggi_badan", vTB);
                params.put("lingkar_kepala", vLK);
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