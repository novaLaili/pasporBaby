package com.example.laili.pasporbayi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
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


public class RiwayatKesehatanActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox chk1, chk2, chk3, chk4, chk5, chk6, chk7,
            chk_ruang_bayi1, chk_ruang_bayi2, chk_ruang_bayi3, chk_ruang_bayi4,
            chk_vitK, chk_Que, chk_Light, chk_Lain,
            chk_HB, chk_HT, chk_Lekosit, chk_Thrombosit, chk_Lain_Lab ;

    ArrayList<String> list;

    EditText VitK, Que, Light, lain_pengobatan,
    birilubin_tgl1, birilubin_tgl2,
    torch, lainLab, periksalain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dra_form_riwayat_kesehatan_bayi);

        list = new ArrayList<String>();

        //kesehatan bayi saat lahir
        chk1 = (CheckBox) findViewById(R.id.checkBoxNormal);
        chk2 = (CheckBox) findViewById(R.id.checkBoxCongenitalHeartDisease);
        chk3 = (CheckBox) findViewById(R.id.checkBoxCaput);
        chk4 = (CheckBox) findViewById(R.id.checkBoxPostJaundice);
        chk5 = (CheckBox) findViewById(R.id.checkBoxCephal);
        chk6 = (CheckBox) findViewById(R.id.checkBoxRespiratory);
        chk7 = (CheckBox) findViewById(R.id.checkBoxPostlain2);

        //kesehatan di ruang bayi
        chk_ruang_bayi1 = (CheckBox) findViewById(R.id.checkBoxNormalRB);
        chk_ruang_bayi2 = (CheckBox) findViewById(R.id.checkBoxKesmin);
        chk_ruang_bayi3 = (CheckBox) findViewById(R.id.checkBoxHyper);
        chk_ruang_bayi4 = (CheckBox) findViewById(R.id.checkBoxlain);

        //pengobatan yang telah diberikan
        chk_vitK = (CheckBox) findViewById(R.id.checkBoxVitK);
        chk_Que = (CheckBox) findViewById(R.id.checkBoxQue);
        chk_Light = (CheckBox) findViewById(R.id.checkBoxLight);
        chk_Lain = (CheckBox) findViewById(R.id.checkBoxlain_pengobatan);

        VitK = (EditText) findViewById(R.id.editTextVitK);
        Que = (EditText) findViewById(R.id.editTextQue);
        Light = (EditText) findViewById(R.id.editTextLight);
        lain_pengobatan = (EditText) findViewById(R.id.editTextlain_pengobatan);

        //pemeriksaan lab
        chk_HB = (CheckBox) findViewById(R.id.checkBoxHB);
        chk_HT = (CheckBox) findViewById(R.id.checkBoxHT);
        chk_Lekosit = (CheckBox) findViewById(R.id.checkBoxLekosit);
        chk_Thrombosit = (CheckBox) findViewById(R.id.checkBoxThrombosit);
        chk_Lain_Lab = (CheckBox) findViewById(R.id.checkBoxlain_lab);

        birilubin_tgl1 = (EditText) findViewById(R.id.editTextTglBilirubin);
        birilubin_tgl2 = (EditText) findViewById(R.id.editTextTglBilirubin2);

        torch = (EditText) findViewById(R.id.editTextTORCH);
        lainLab = (EditText) findViewById(R.id.editTextLainLab);
        periksalain = (EditText) findViewById(R.id.editTextPeriksaLain);

        ImageButton next = (ImageButton) findViewById(R.id.buttonNext);
        ImageButton home = (ImageButton) findViewById(R.id.buttonHome);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addListenerOnButton();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonHome :
                        Intent openRKAActivity = new Intent(RiwayatKesehatanActivity.this, MainActivity.class);
                        startActivity(openRKAActivity);
                }
            }
        });
    }

    public void onCheckboxClicked(View view) {

        switch(view.getId()) {
            case R.id.checkBoxNormal:
                list.add(chk1.getText().toString());
                break;

            case R.id.checkBoxCongenitalHeartDisease:
                list.add(chk2.getText().toString());
                break;

            case R.id.checkBoxCaput:
                list.add(chk3.getText().toString());
                break;

            case R.id.checkBoxPostJaundice:
                list.add(chk4.getText().toString());
                break;

            case R.id.checkBoxCephal:
                list.add(chk5.getText().toString());
                break;

            case R.id.checkBoxRespiratory:
                list.add(chk6.getText().toString());
                break;

            case R.id.checkBoxPostlain2:
                list.add(chk7.getText().toString());
                break;

            case R.id.checkBoxNormalRB:
                list.add(chk_ruang_bayi1.getText().toString());
                break;

            case R.id.checkBoxKesmin:
                list.add(chk_ruang_bayi2.getText().toString());
                break;

            case R.id.checkBoxHyper:
                list.add(chk_ruang_bayi3.getText().toString());

                break;
            case R.id.checkBoxlain:
                list.add(chk_ruang_bayi4.getText().toString());
                break;

            case R.id.checkBoxVitK:
                list.add(chk_vitK.getText().toString());
                break;

            case R.id.checkBoxQue:
                list.add(chk_Que.getText().toString());
                break;

            case R.id.checkBoxLight:
                list.add(chk_Light.getText().toString());
                break;

            case R.id.checkBoxlain_pengobatan:
                list.add(chk_Lain.getText().toString());
                break;

            case R.id.checkBoxHB:
                list.add(chk_HB.getText().toString());
                break;

            case R.id.checkBoxHT:
                list.add(chk_HT.getText().toString());
                break;

            case R.id.checkBoxLekosit:
                list.add(chk_Lekosit.getText().toString());
                break;

            case R.id.checkBoxThrombosit:
                list.add(chk_Thrombosit.getText().toString());
                break;

            case R.id.checkBoxlain_lab:
                list.add(chk_Lain_Lab .getText().toString());
                break;
        }
    }

    public void addListenerOnButton() {



        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.101/pasporBayi_TA/form_riwayat_kesehatan_bayi.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(!response.equals("oops! Please try again")){
                            Intent openDAActivity = new Intent(RiwayatKesehatanActivity.this, RiwayatMedikPentingActivity.class);
                            startActivity(openDAActivity);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Test", "Ini request error " +error.getMessage());
                        Toast.makeText(RiwayatKesehatanActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                String id_user = Config.GetString(RiwayatKesehatanActivity.this, "id_user");
                params.put("id_anak", id_user);
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