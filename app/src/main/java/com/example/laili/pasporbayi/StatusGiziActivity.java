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

public class StatusGiziActivity extends AppCompatActivity implements View.OnClickListener {

    EditText umurTahun, umurBulan, jenis_kelamin, berat, tinggi, lingkar_kepala;
    SharedPrefManager manager;

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
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.108/pasporBayi_TA/form_status_gizi.php",
                        //StringRequest stringRequest = new StringRequest(Request.Method.POST, "http:///192.168.0.105/pasporBayi_TA/form_data_anak.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(!response.equals("oops! Please try again")){
                                    Intent openHasilSGActivity = new Intent(StatusGiziActivity.this, HasilStatusGiziActivity.class);
                                    final Bundle bundle = new Bundle();
                                    bundle.putString("jenis_kelamin", jenis_kelamin.getText().toString());
                                    bundle.putInt("tahun", Integer.parseInt(umurTahun.getText().toString()) );
                                    bundle.putInt("bulan", Integer.parseInt(umurBulan.getText().toString()) );
                                    bundle.putDouble("berat", Double.parseDouble(berat.getText().toString()));
                                    bundle.putDouble("tinggi", Double.parseDouble(tinggi.getText().toString()));
                                    bundle.putDouble("lingkar_kepala", Double.parseDouble(lingkar_kepala.getText().toString()));
                                    openHasilSGActivity.putExtras(bundle);//put Extras fungsinya untuk melemparkan data antara activity status gizi ke hasilstatusgizi
                                    startActivity(openHasilSGActivity);
                                }
                                else {
                                    Intent openHasilSGActivity = new Intent(StatusGiziActivity.this, HasilStatusGiziActivity.class);
                                    final Bundle bundle = new Bundle();
                                    bundle.putString("jenis_kelamin", jenis_kelamin.getText().toString());
                                    bundle.putInt("tahun", Integer.parseInt(umurTahun.getText().toString()) );
                                    bundle.putInt("bulan", Integer.parseInt(umurBulan.getText().toString()) );
                                    bundle.putDouble("berat", Double.parseDouble(berat.getText().toString()));
                                    bundle.putDouble("tinggi", Double.parseDouble(tinggi.getText().toString()));
                                    bundle.putDouble("lingkar_kepala", Double.parseDouble(lingkar_kepala.getText().toString()));
                                    openHasilSGActivity.putExtras(bundle);//put Extras fungsinya untuk melemparkan data antara activity status gizi ke hasilstatusgizi
                                    Config.SetString(StatusGiziActivity.this, "id_anak", response);
                                    Log.d("id_anak",response);
                                    startActivity(openHasilSGActivity);
                                }
                                //Toast.makeText(DataAnakActivity.this, response, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(PendaftaranActivity.this,response,Toast.LENGTH_LONG).show();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("Test", "Ini request error " +error.getMessage());
                                Toast.makeText(StatusGiziActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                            }
                        }){
                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("id_anak",""+manager.getUserId());
                        params.put("umur_tahun",umurTahun.getText().toString());
                        params.put("umur_bulan",umurBulan.getText().toString());
                        params.put("jenis_kelamin",jenis_kelamin.getText().toString());
                        params.put("berat_badan",berat.getText().toString());
                        params.put("tinggi_badan",tinggi.getText().toString());
                        params.put("lingkar_kepala",lingkar_kepala.getText().toString());
                        return params;
                    }

                };

                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(stringRequest);
                }




                }


    }