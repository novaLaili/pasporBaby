package com.example.laili.pasporbayi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CatatanKunjunganActivity extends AppCompatActivity implements View.OnClickListener {
    EditText umur, BB, PB, LK, hasil_pemeriksaaan, pengobatan;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_catatan_kunjungan);

        SearchID();
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        Button buttonCatatanKunjungan = (Button) findViewById(R.id.buttonTabelCatK);
        buttonCatatanKunjungan.setOnClickListener(this);

        buttonCatatanKunjungan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            User();
        }
    });
    }

    public void SearchID(){
        dateView = (TextView) findViewById(R.id.calenderCatKunj);
        umur = (EditText) findViewById(R.id.editTextUmur);
        BB = (EditText) findViewById(R.id.editTextberatBadan);
        PB = (EditText) findViewById(R.id.editTextpanjangBadan);
        LK = (EditText) findViewById(R.id.editTextLK);
        hasil_pemeriksaaan = (EditText) findViewById(R.id.editTextPemeriksaan);
        pengobatan = (EditText) findViewById(R.id.editTextPengobatan);
    }

    private void User(){
        final String vTanggal = dateView.getText().toString().trim();
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
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.103/pasporBayi_TA/form_catatan_kunjungan.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(!response.equals("oops! Please try again")){
                            Intent openCKAActivity = new Intent(CatatanKunjunganActivity.this, TabelCatKunjunganActivity.class);
                            startActivity(openCKAActivity);
                        }
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
                String id_anak = Config.GetString(CatatanKunjunganActivity.this, "id_anak");
                params.put("id_anak", id_anak);
                params.put("tanggal",vTanggal);
                params.put("umur",vUmur);
                params.put("berat_badan",vBerat_badan);
                params.put("panjang_badan",vPanjang_badan);
                params.put("lingkar_kepala",vLingkar_kepala);
                params.put("hasil_pemeriksaan",vPemeriksaan);
                params.put("pengobatan",vPengobatan);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "calender",
                Toast.LENGTH_SHORT)
                .show();
    }

    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(year).append("-")
                .append(month).append("-").append(day));

    }

    @Override
    public void onClick(View v) {
    }
}
