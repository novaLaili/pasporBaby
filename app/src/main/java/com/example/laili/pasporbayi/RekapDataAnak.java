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

public class RekapDataAnak extends AppCompatActivity {

    //rekapdatanakactivity ndak usah di pakai!!!!
    private TextView txtnama, txttgl_lahir, txtwaktu, txtberat, txtpanjang, txtLK, txttempat_lahir, txtRS, txtayah,
            txtttl_ayah, txtempatlahirayah, txtpekerjaan_ayah, txtalamat_kantor_ayah, txttlp_kantor_ayah, txttlp_seluler_ayah,
            txtibu, txtttl_ibu, txtempatlahiribu, txtpekerjaan_ibu, txtalamat_kantor_ibu, txttlp_kantor_ibu, txttlp_seluler_ibu,
            txtnama_dktr_kandungan, txtnama_dktr_anak, txtkondisi_atau_saran;

    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rekap_data_anak);

        txtnama = (TextView) findViewById(R.id.Rekap_nama);
        txttgl_lahir = (TextView) findViewById(R.id.Rekap_tgl);
        txtwaktu = (TextView) findViewById(R.id.Rekap_waktu);
        txtberat = (TextView) findViewById(R.id.Rekap_berat);
        txtpanjang = (TextView) findViewById(R.id.Rekap_panjang);
        txtLK = (TextView) findViewById(R.id.Rekap_LK);
        txttempat_lahir = (TextView) findViewById(R.id.Rekap_tempatLahir);
        txtRS = (TextView) findViewById(R.id.Rekap_RS);
        txtayah = (TextView) findViewById(R.id.Rekap_namaAyah);
        txtttl_ayah = (TextView) findViewById(R.id.Rekap_TTL_Ayah);
        txtempatlahirayah = (TextView) findViewById(R.id.Rekap_tempat_lahir_ayah);
        txtpekerjaan_ayah = (TextView) findViewById(R.id.Rekap_pekerjaanAyah);
        txtalamat_kantor_ayah = (TextView) findViewById(R.id.Rekap_alamatKantorAyah);
        txttlp_kantor_ayah = (TextView) findViewById(R.id.Rekap_tlpKantorAyah);
        txttlp_seluler_ayah = (TextView) findViewById(R.id.Rekap_tlpSelulerAyah);
        txtibu = (TextView) findViewById(R.id.Rekap_namaIbu);
        txtttl_ibu = (TextView) findViewById(R.id.Rekap_TTL_Ibu);
        txtempatlahiribu = (TextView) findViewById(R.id.Rekap_tempat_lahir_ibu);
        txtpekerjaan_ibu = (TextView) findViewById(R.id.Rekap_pekerjaanIbu);
        txtalamat_kantor_ibu = (TextView) findViewById(R.id.Rekap_alamatKantorIbu);
        txttlp_kantor_ibu = (TextView) findViewById(R.id.Rekap_tlpKantorIbu);
        txttlp_seluler_ibu = (TextView) findViewById(R.id.Rekap_tlpSelulerIbu);
        txtnama_dktr_kandungan = (TextView) findViewById(R.id.idNamaDktrKndungan);
        txtnama_dktr_anak = (TextView) findViewById(R.id.idNamaDktrAnak);
        txtkondisi_atau_saran = (TextView) findViewById(R.id.idKondisi_saran);

        ImageButton next = (ImageButton) findViewById(R.id.buttonNext);
        ImageButton home = (ImageButton) findViewById(R.id.buttonHome);

        getData();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openRDAActivity = new Intent(RekapDataAnak.this, RekapRiwayatKelahiranActivity.class);
                startActivity(openRDAActivity);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonHome :
                        Intent openDAActivity = new Intent(RekapDataAnak.this, NavActivity.class);
                        startActivity(openDAActivity);
                }
            }
        });

    }

    private void getData() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);

        String user_id = Config.GetString(RekapDataAnak.this, "id_user");
        String url = Config.DATA_URL + user_id;

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
                        Toast.makeText(RekapDataAnak.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
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

            txtnama.setText(data.getString("nama"));
            txttgl_lahir.setText(data.getString("tgl_lahir"));
            txtwaktu.setText(data.getString("waktu"));
            txtberat.setText(data.getString("berat"));
            txtpanjang.setText(data.getString("panjang"));
            txtLK.setText(data.getString("LK"));
            txttempat_lahir.setText(data.getString("tempat_lahir"));
            txtRS.setText(data.getString("RS"));
            txtayah.setText(data.getString("nama_ayah"));
            txtttl_ayah.setText(data.getString("TTL_ayah"));
            txtempatlahirayah.setText(data.getString("tempat_lahir_ayah"));
            txtpekerjaan_ayah.setText(data.getString("pekerjaan_ayah"));
            txtalamat_kantor_ayah.setText(data.getString("alamat_kantor_ayah"));
            txttlp_kantor_ayah.setText(data.getString("tlp_kantor_ayah"));
            txttlp_seluler_ayah.setText(data.getString("tlp_seluler_ayah"));
            txtibu.setText(data.getString("nama_ibu"));
            txtttl_ibu.setText(data.getString("TTL_ibu"));
            txtempatlahiribu.setText(data.getString("tempat_lahir_ibu"));
            txtpekerjaan_ibu.setText(data.getString("pekerjaan_ibu"));
            txtalamat_kantor_ibu.setText(data.getString("alamat_kantor_ibu"));
            txttlp_kantor_ibu.setText(data.getString("tlp_kantor_ibu"));
            txttlp_seluler_ibu.setText(data.getString("tlp_seluler_ibu"));
            txtnama_dktr_kandungan.setText(data.getString("nama_dktr_kandungan_yg_membantu_kelahiran"));
            txtnama_dktr_anak.setText(data.getString("nama_dktr_anak_yg_membantu_kelahiran"));
            txtkondisi_atau_saran.setText(data.getString("kondisi_atau_saran_khusus_yg_diberikan"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
