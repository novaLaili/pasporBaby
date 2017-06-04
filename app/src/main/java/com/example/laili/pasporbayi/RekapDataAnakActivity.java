package com.example.laili.pasporbayi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class RekapDataAnakActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtnama, txttgl_lahir, txtwaktu, txtberat, txtpanjang, txtLK, txttempat_lahir, txtRS, txtayah,
            txtttl_ayah, txtempatlahirayah, txtpekerjaan_ayah, txtalamat_kantor_ayah, txttlp_kantor_ayah, txttlp_seluler_ayah,
            txtibu, txtttl_ibu, txtempatlahiribu, txtpekerjaan_ibu, txtalamat_kantor_ibu, txttlp_kantor_ibu, txttlp_seluler_ibu,
            txtnama_dktr_kandungan, txtnama_dktr_anak, txtkondisi_atau_saran;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rekap_data_anak);

        String url = "http://10.252.130.66/pasporBayi_TA/getdata.php";
        //String url = "http://192.168.0.106/pasporBayi_TA/getdata.php";

        ImageButton next = (ImageButton) findViewById(R.id.buttonNext);
        ImageButton home = (ImageButton) findViewById(R.id.buttonHome);
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
        txtnama_dktr_kandungan = (TextView) findViewById(R.id.Rekap_tlpSelulerIbu);
        txtnama_dktr_anak = (TextView) findViewById(R.id.Rekap_tlpSelulerIbu);
        txtkondisi_atau_saran = (TextView) findViewById(R.id.Rekap_tlpSelulerIbu);

        requestQueue = Volley.newRequestQueue(RekapDataAnakActivity.this);

        list_data = new ArrayList<HashMap<String, String>>();

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data_anak");
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("id_anak", json.getString("id_anak"));
                        map.put("nama", json.getString("nama"));
                        map.put("tgl_lahir", json.getString("tgl_lahir"));
                        map.put("waktu", json.getString("waktu"));
                        map.put("berat", json.getString("berat"));
                        map.put("panjang", json.getString("panjang"));
                        map.put("LK", json.getString("LK"));
                        map.put("tempat_lahir", json.getString("tempat_lahir"));
                        map.put("RS", json.getString("RS"));
                        map.put("nama_ayah", json.getString("nama_ayah"));
                        map.put("TTL_ayah", json.getString("TTL_ayah"));
                        map.put("tempat_lahir_ayah", json.getString("tempat_lahir_ayah"));
                        map.put("pekerjaan_ayah", json.getString("pekerjaan_ayah"));
                        map.put("alamat_kantor_ayah", json.getString("alamat_kantor_ayah"));
                        map.put("tlp_kantor_ayah", json.getString("tlp_kantor_ayah"));
                        map.put("tlp_seluler_ayah", json.getString("tlp_seluler_ayah"));
                        map.put("nama_ibu", json.getString("nama_ibu"));
                        map.put("TTL_ibu", json.getString("TTL_ibu"));
                        map.put("tempat_lahir_ibu", json.getString("tempat_lahir_ibu"));
                        map.put("pekerjaan_ibu", json.getString("pekerjaan_ibu"));
                        map.put("alamat_kantor_ibu", json.getString("alamat_kantor_ibu"));
                        map.put("tlp_kantor_ibu", json.getString("tlp_kantor_ibu"));
                        map.put("tlp_seluler_ibu", json.getString("tlp_seluler_ibu"));
                        map.put("nama_dktr_kandungan_yg_membantu_kelahiran", json.getString("nama_dktr_kandungan_yg_membantu_kelahiran"));
                        map.put("nama_dktr_anak_yg_membantu_kelahiran", json.getString("nama_dktr_anak_yg_membantu_kelahiran"));
                        map.put("kondisi_atau_saran_khusus_yg_diberikan", json.getString("kondisi_atau_saran_khusus_yg_diberikan"));
                        map.put("id_user", json.getString("id_user"));
                        list_data.add(map);
                    }

                    System.out.println("" + txtnama);
//                    Glide.with(getApplicationContext());
//                            .load("http://192.168.0.107/pasporBayi_TA/img/" + list_data.get(0).get("gambar"))
//                            .crossFade()
//                            .placeholder(R.mipmap.ic_launcher)
//                            .into(imghp);
                    txtnama.setText(list_data.get(0).get("nama"));
                    txttgl_lahir.setText(list_data.get(0).get("tgl_lahir"));
                    txtwaktu.setText(list_data.get(0).get("waktu"));
                    txtberat.setText(list_data.get(0).get("berat"));
                    txtpanjang.setText(list_data.get(0).get("panjang"));
                    txtLK.setText(list_data.get(0).get("LK"));
                    txttempat_lahir.setText(list_data.get(0).get("tempat_lahir"));
                    txtRS.setText(list_data.get(0).get("RS"));
                    txtayah.setText(list_data.get(0).get("nama_ayah"));
                    txtttl_ayah.setText(list_data.get(0).get("TTL_ayah"));
                    txtempatlahirayah.setText(list_data.get(0).get("tempat_lahir_ayah"));
                    txtpekerjaan_ayah.setText(list_data.get(0).get("pekerjaan_ayah"));
                    txtalamat_kantor_ayah.setText(list_data.get(0).get("alamat_kantor_ayah"));
                    txttlp_kantor_ayah.setText(list_data.get(0).get("tlp_kantor_ayah"));
                    txttlp_seluler_ayah.setText(list_data.get(0).get("tlp_seluler_ayah"));
                    txtibu.setText(list_data.get(0).get("nama_ibu"));
                    txtttl_ibu.setText(list_data.get(0).get("TTL_ibu"));
                    txtempatlahiribu.setText(list_data.get(0).get("tempat_lahir_ibu"));
                    txtpekerjaan_ibu.setText(list_data.get(0).get("pekerjaan_ibu"));
                    txtalamat_kantor_ibu.setText(list_data.get(0).get("alamat_kantor_ibu"));
                    txttlp_kantor_ibu.setText(list_data.get(0).get("tlp_kantor_ibu"));
                    txttlp_seluler_ibu.setText(list_data.get(0).get("tlp_seluler_ibu"));
                    txtnama_dktr_kandungan.setText(list_data.get(0).get("nama_dktr_kandungan_yg_membantu_kelahiran"));
                    txtnama_dktr_anak.setText(list_data.get(0).get("nama_dktr_anak_yg_membantu_kelahiran"));
                    txtkondisi_atau_saran.setText(list_data.get(0).get("kondisi_atau_saran_khusus_yg_diberikan"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RekapDataAnakActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }

            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                //params.put("id_user", Config.GetString(RekapDataAnakActivity.this, "id_user"));
                //params.put("id_user",id_user);
                return params;
            }
        });

        requestQueue.add(stringRequest);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonNext :
                        Intent openRKAActivity = new Intent(RekapDataAnakActivity.this, RekapRiwayatKelahiranActivity.class);
                        startActivity(openRKAActivity);
                }
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonHome :
                        Intent openRKAActivity = new Intent(RekapDataAnakActivity.this, MainActivity.class);
                        startActivity(openRKAActivity);
                }
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    //params.put("id_user",Config.GetString( DataAnakActivity.this, "id_user"));
    @Override
    public void onClick(View v) {
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("RekapDataAnak Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
