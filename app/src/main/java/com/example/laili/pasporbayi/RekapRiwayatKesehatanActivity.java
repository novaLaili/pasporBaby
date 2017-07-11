package com.example.laili.pasporbayi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RekapRiwayatKesehatanActivity extends AppCompatActivity  {

    TextView txtKesehatan, txtKesehatandiRuangBayi, txtVitkK, txtQue, txtLight, txtLainPengobatan,
            txtDarahLengkap, txtBirilubin, txtBirilubin2, txtTorch, txtLainLab, txtPeriksaLain;

    private ProgressDialog loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rekap_riwayat_kesehatan_bayi);

        txtKesehatan = (TextView) findViewById(R.id.idkesehatan);
        txtKesehatandiRuangBayi = (TextView) findViewById(R.id.idKesehatanDiRuangBayi);
        txtVitkK = (TextView) findViewById(R.id.idVitK);
        txtQue = (TextView) findViewById(R.id.idQue);
        txtLight = (TextView) findViewById(R.id.idLight);
        txtLainPengobatan = (TextView) findViewById(R.id.idLain_pengobatan);
        txtDarahLengkap = (TextView) findViewById(R.id.idDarahLengkap);
        txtBirilubin = (TextView) findViewById(R.id.idTglBilirubin);
        txtBirilubin2 = (TextView) findViewById(R.id.idTglBilirubin2);
        txtTorch = (TextView) findViewById(R.id.idTORCH);
        txtLainLab = (TextView) findViewById(R.id.idLainLab);
        txtPeriksaLain = (TextView) findViewById(R.id.idPeriksaLain);

        ImageButton next = (ImageButton) findViewById(R.id.buttonNext);
        ImageButton home = (ImageButton) findViewById(R.id.buttonHome);

        getData();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonNext :
                        Intent openRKAActivity = new Intent(RekapRiwayatKesehatanActivity.this, RekapRiwayatMedikPentingActivity.class);
                        startActivity(openRKAActivity);
                }
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonHome :
                        Intent openRKAActivity = new Intent(RekapRiwayatKesehatanActivity.this, MainActivity.class);
                        startActivity(openRKAActivity);
                }
            }
        });
    }

    private void getData() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);

        String user_id = Config.GetString(RekapRiwayatKesehatanActivity.this, "id_anak");
        String url = Config.DATA_URL_RIWAYAT_KESEHATAN + user_id;

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                Log.d("response", response);
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RekapRiwayatKesehatanActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            JSONObject data = result.getJSONObject(0);

            txtKesehatan.setText(data.getString("kesehatan_bayi_saat_lahir"));
            txtKesehatandiRuangBayi.setText(data.getString("kesehatan_bayi_selama_di_ruang_bayi"));
            txtVitkK.setText(data.getString("pengobatan_vitK"));
            txtQue.setText(data.getString("pengobatan_questran"));
            txtLight.setText(data.getString("pengobatan_light_therapy"));
            txtLainPengobatan.setText(data.getString("pengobatan_lain2"));
            txtDarahLengkap.setText(data.getString("pemeriksaan_lab_darah_lengkap"));
            txtBirilubin.setText(data.getString("pemeriksaan_lab_bilirubin1"));
            txtBirilubin2.setText(data.getString("pemeriksaan_lab_bilirubin2"));
            txtTorch.setText(data.getString("pemeriksaan_lab_TORCH"));
            txtLainLab.setText(data.getString("pemeriksaan_lab_lain2"));
            txtPeriksaLain.setText(data.getString("pemeriksaan_lain2"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
