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

public class RekapRiwayatKelahiranActivity extends AppCompatActivity  {

    private TextView txtnama_RS, txtpenolong_persalinan_DokterObs, txtLD, txttali_pusat_pj, txtLK, txttali_pusat_insersi, txtair_ketuban_warna, txtair_ketuban_jumlah,
            txtpenolong_persalinan_DokterAnak, txtumur_kelahiran, txtkondisi_lahir, txttali_pusat_lilitan, txttali_pusat_prolaps, txtair_ketuban_bau,
            txtletak_janin, txtcara_lahir, txtapgar_scope, txtBBL, txtPBL, txtplacenta_berat, txtplacenta_kelahiran, txtgoldar;

    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rekap_riwayat_kelahiran);

        txtnama_RS = (TextView) findViewById(R.id.idRS);
        txtpenolong_persalinan_DokterObs = (TextView) findViewById(R.id.idDokterObs);
        txtpenolong_persalinan_DokterAnak = (TextView) findViewById(R.id.idDokterAnak);
        txtumur_kelahiran = (TextView) findViewById(R.id.idUmur);
        txtkondisi_lahir = (TextView) findViewById(R.id.idKondisiLahir);
        txtletak_janin = (TextView) findViewById(R.id.idLetakJanin);
        txtcara_lahir = (TextView) findViewById(R.id.idCaraLahir);
        txtapgar_scope = (TextView) findViewById(R.id.idApgarScope);
        txtBBL = (TextView) findViewById(R.id.idBeratBadan);
        txtPBL = (TextView) findViewById(R.id.idPanjangBadan);
        txtLK = (TextView) findViewById(R.id.idLK);
        txtLD = (TextView) findViewById(R.id.idLD);
        txttali_pusat_pj = (TextView) findViewById(R.id.idPanjang);
        txttali_pusat_lilitan = (TextView) findViewById(R.id.idLilitan);
        txttali_pusat_prolaps = (TextView) findViewById(R.id.idPprolaps);
        txttali_pusat_insersi = (TextView) findViewById(R.id.idInsersi);
        txtair_ketuban_warna = (TextView) findViewById(R.id.idWarna);
        txtair_ketuban_bau = (TextView) findViewById(R.id.idBau);
        txtair_ketuban_jumlah = (TextView) findViewById(R.id.idJumlah);
        txtplacenta_berat = (TextView) findViewById(R.id.idBerat);
        txtplacenta_kelahiran = (TextView) findViewById(R.id.idKelahiran);
        txtgoldar = (TextView) findViewById(R.id.idGoldar);

        ImageButton next = (ImageButton) findViewById(R.id.buttonNext);
        ImageButton home = (ImageButton) findViewById(R.id.buttonHome);

        getData();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openRKAActivity = new Intent(RekapRiwayatKelahiranActivity.this, RekapRiwayatKesehatanActivity.class);
                startActivity(openRKAActivity);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonHome :
                        Intent openRKActivity = new Intent(RekapRiwayatKelahiranActivity.this, NavActivity.class);
                        startActivity(openRKActivity);
                }
            }
        });
    }

    private void getData() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);

        String user_id = Config.GetString(RekapRiwayatKelahiranActivity.this, "id_anak");
        String url = Config.DATA_URL_ANAK + user_id;

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
                        Toast.makeText(RekapRiwayatKelahiranActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
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

            txtnama_RS.setText(data.getString("nama_RS"));
            txtpenolong_persalinan_DokterObs.setText(data.getString("penolong_persalinan_DokterObs"));
            txtpenolong_persalinan_DokterAnak.setText(data.getString("penolong_persalinan_DokterAnak"));
            txtumur_kelahiran.setText(data.getString("umur_kelahiran"));
            txtkondisi_lahir.setText(data.getString("kondisi_lahir"));
            txtletak_janin.setText(data.getString("letak_janin"));
            txtcara_lahir.setText(data.getString("cara_lahir"));
            txtapgar_scope.setText(data.getString("apgar_scope"));
            txtBBL.setText(data.getString("BBL"));
            txtPBL.setText(data.getString("PBL"));
            txtLK.setText(data.getString("LK"));
            txtLD.setText(data.getString("LD"));
            txttali_pusat_pj.setText(data.getString("tali_pusat_pj"));
            txttali_pusat_lilitan.setText(data.getString("tali_pusat_lilitan"));
            txttali_pusat_prolaps.setText(data.getString("tali_pusat_prolaps"));
            txttali_pusat_insersi.setText(data.getString("tali_pusat_insersi"));
            txtair_ketuban_warna.setText(data.getString("air_ketuban_warna"));
            txtair_ketuban_bau.setText(data.getString("air_ketuban_bau"));
            txtair_ketuban_jumlah.setText(data.getString("air_ketuban_jumlah"));
            txtplacenta_berat.setText(data.getString("placenta_berat"));
            txtplacenta_kelahiran.setText(data.getString("placenta_kelahiran"));
            txtgoldar.setText(data.getString("goldar"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
