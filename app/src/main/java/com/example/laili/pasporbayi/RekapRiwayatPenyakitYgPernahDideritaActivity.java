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

public class RekapRiwayatPenyakitYgPernahDideritaActivity extends AppCompatActivity  {

    private TextView txtNamaPenyakit;

    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rekap_riwayat_penyakit);

        txtNamaPenyakit = (TextView) findViewById(R.id.idListPenyakit);

        ImageButton home = (ImageButton) findViewById(R.id.buttonHome);

        getData();

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonHome :
                        Intent openRKAActivity = new Intent(RekapRiwayatPenyakitYgPernahDideritaActivity.this, NavActivity.class);
                        startActivity(openRKAActivity);
                        finish();
                }
            }
        });
    }

    private void getData() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);

        String user_id = Config.GetString(RekapRiwayatPenyakitYgPernahDideritaActivity.this, "id_anak");
        String url = Config.DATA_URL_RIWAYAT_PENYAKIT + user_id;

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
                        Toast.makeText(RekapRiwayatPenyakitYgPernahDideritaActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response) {
//        String name = "";
//        String address = "";
//        String vc = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            JSONObject data = result.getJSONObject(0);

            txtNamaPenyakit.setText(data.getString("nama_penyakit"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
