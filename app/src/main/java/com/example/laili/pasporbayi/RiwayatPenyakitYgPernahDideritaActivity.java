package com.example.laili.pasporbayi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RiwayatPenyakitYgPernahDideritaActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox chk1, chk2, chk3, chk4, chk5, chk6, chk7, chk8, chk9, chk10, chk11, chk12, chk13, chk14, chk15, chk16;
    Button btn;

    TextView txt;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        list = new ArrayList<String>();


        chk1 = (CheckBox) findViewById(R.id.idCacar);
        chk2 = (CheckBox) findViewById(R.id.idTBC);
        chk3 = (CheckBox) findViewById(R.id.idDifteri);
        chk4 = (CheckBox) findViewById(R.id.idKejang);
        chk5 = (CheckBox) findViewById(R.id.idCampak);
        chk6 = (CheckBox) findViewById(R.id.idHepatitis);
        chk7 = (CheckBox) findViewById(R.id.idEnteritis);
        chk8 = (CheckBox) findViewById(R.id.idGondangan);
        chk9 = (CheckBox) findViewById(R.id.idDBD);
        chk10 = (CheckBox) findViewById(R.id.idTetanus);
        chk11 = (CheckBox) findViewById(R.id.idBatuk);
        chk12 = (CheckBox) findViewById(R.id.idPneumonia);
        chk13 = (CheckBox) findViewById(R.id.idDemam);
        chk14 = (CheckBox) findViewById(R.id.idPolio);
        chk15 = (CheckBox) findViewById(R.id.idAsma);
        chk16 = (CheckBox) findViewById(R.id.idAdd);
        txt = (TextView)findViewById(R.id.textView1);
        btn = (Button) findViewById(R.id.idSubmitPenyakit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addListenerOnButton();
            }
        });

    }


    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.idCacar:
                list.add(chk1.getText().toString());

                break;
            case R.id.idTBC:
                list.add(chk2.getText().toString());

                break;

            case R.id.idDifteri:
                list.add(chk3.getText().toString());

                break;
            case R.id.idKejang:
                list.add(chk4.getText().toString());

                break;
            case R.id.idCampak:
                list.add(chk5.getText().toString());

                break;
            case R.id.idHepatitis:
                list.add(chk6.getText().toString());

                break;
            case R.id.idEnteritis:
                list.add(chk7.getText().toString());

                break;
            case R.id.idGondangan:
                list.add(chk8.getText().toString());

                break;
            case R.id.idDBD:
                list.add(chk9.getText().toString());

                break;
            case R.id.idTetanus:
                list.add(chk10.getText().toString());

                break;
            case R.id.idBatuk:
                list.add(chk11.getText().toString());

                break;
            case R.id.idPneumonia:
                list.add(chk12.getText().toString());

                break;
            case R.id.idDemam:
                list.add(chk13.getText().toString());

                break;
            case R.id.idPolio:
                list.add(chk14.getText().toString());

                break;
            case R.id.idAsma:
                list.add(chk15.getText().toString());

                break;
            case R.id.idAdd:
                list.add(chk16.getText().toString());

                break;
        }
    }

    public void addListenerOnButton() {

//        String vPenyakit;
//        for (String str : list) {
//            vPenyakit = txt.getText().toString() + " , " + str;
//        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.102/pasporBayi_TA/riwayat_penyakit.php",
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.100/pasporBayi_TA/form_data_anak.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(!response.equals("oops! Please try again")){
                            Intent openDAActivity = new Intent(RiwayatPenyakitYgPernahDideritaActivity.this, NavActivity.class);
                            startActivity(openDAActivity);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Test", "Ini request error " +error.getMessage());
                        Toast.makeText(RiwayatPenyakitYgPernahDideritaActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                String id_anak = Config.GetString(RiwayatPenyakitYgPernahDideritaActivity.this, "id_anak");
                params.put("id_anak", id_anak);
                for (String str : list){
                    params.put("nama_penyakit", list.toString());
                }

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
