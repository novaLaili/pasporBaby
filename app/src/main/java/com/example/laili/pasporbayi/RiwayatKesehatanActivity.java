package com.example.laili.pasporbayi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class RiwayatKesehatanActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox chk1, chk2, chk3, chk4, chk5, chk6, chk7,
            chk_ruang_bayi1, chk_ruang_bayi2, chk_ruang_bayi3, chk_ruang_bayi4,
            chk_HB, chk_HT, chk_Lekosit, chk_Thrombosit, chk_Lain_Lab ;

    ArrayList<String> listBayiLahir, listRuangBayi, listDarahLengkap;

    EditText VitK, Que, Light, lain_pengobatan,
    torch, lainLab, periksalain;

    private Calendar calendar;
    TextView birilubin_tgl1, birilubin_tgl2;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dra_form_riwayat_kesehatan_bayi);

        listBayiLahir = new ArrayList<String>();
        listRuangBayi = new ArrayList<String>();
        listDarahLengkap = new ArrayList<String>();

        //bukan checkbox
        birilubin_tgl1 = (TextView) findViewById(R.id.tglBilirubin);
        birilubin_tgl2 = (TextView) findViewById(R.id.tglBilirubin2);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day); //menampilkan tanggal

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
        VitK = (EditText) findViewById(R.id.editTextVitK);
        Que = (EditText) findViewById(R.id.editTextQue);
        Light = (EditText) findViewById(R.id.editTextLight);
        lain_pengobatan = (EditText) findViewById(R.id.editTextlain_pengobatan);

        //darah lengkap
        chk_HB = (CheckBox) findViewById(R.id.checkBoxHB);
        chk_HT = (CheckBox) findViewById(R.id.checkBoxHT);
        chk_Lekosit = (CheckBox) findViewById(R.id.checkBoxLekosit);
        chk_Thrombosit = (CheckBox) findViewById(R.id.checkBoxThrombosit);
        chk_Lain_Lab = (CheckBox) findViewById(R.id.checkBoxlain_lab);

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
                listBayiLahir.add(chk1.getText().toString());
                break;

            case R.id.checkBoxCongenitalHeartDisease:
                listBayiLahir.add(chk2.getText().toString());
                break;

            case R.id.checkBoxCaput:
                listBayiLahir.add(chk3.getText().toString());
                break;

            case R.id.checkBoxPostJaundice:
                listBayiLahir.add(chk4.getText().toString());
                break;

            case R.id.checkBoxCephal:
                listBayiLahir.add(chk5.getText().toString());
                break;

            case R.id.checkBoxRespiratory:
                listBayiLahir.add(chk6.getText().toString());
                break;

            case R.id.checkBoxPostlain2:
                listBayiLahir.add(chk7.getText().toString());
                break;

            case R.id.checkBoxNormalRB:
                listRuangBayi.add(chk_ruang_bayi1.getText().toString());
                break;

            case R.id.checkBoxKesmin:
                listRuangBayi.add(chk_ruang_bayi2.getText().toString());
                break;

            case R.id.checkBoxHyper:
                listRuangBayi.add(chk_ruang_bayi3.getText().toString());

                break;
            case R.id.checkBoxlain:
                listRuangBayi.add(chk_ruang_bayi4.getText().toString());
                break;

            case R.id.checkBoxHB:
                listDarahLengkap.add(chk_HB.getText().toString());
                break;

            case R.id.checkBoxHT:
                listDarahLengkap.add(chk_HT.getText().toString());
                break;

            case R.id.checkBoxLekosit:
                listDarahLengkap.add(chk_Lekosit.getText().toString());
                break;

            case R.id.checkBoxThrombosit:
                listDarahLengkap.add(chk_Thrombosit.getText().toString());
                break;

            case R.id.checkBoxlain_lab:
                listDarahLengkap.add(chk_Lain_Lab .getText().toString());
                break;
        }
    }

    public void addListenerOnButton() {

        final String vVitK = VitK.getText().toString().trim();
        final String vQue = Que.getText().toString().trim();
        final String vLight = Light.getText().toString().trim();
        final String vLainPengobatan = lain_pengobatan.getText().toString().trim();
        final String vBirilubinTgl1 = birilubin_tgl1.getText().toString().trim();
        final String vBirilubinTgl2 = birilubin_tgl2.getText().toString().trim();
        final String vTorch = torch.getText().toString().trim();
        final String vLainLab = lainLab.getText().toString().trim();
        final String vPeriksaLain = periksalain.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.102/pasporBayi_TA/form_riwayat_kesehatan_bayi.php",
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
                String tmp;
                Map<String,String> params = new HashMap<String, String>();
                String id_anak = Config.GetString(RiwayatKesehatanActivity.this, "id_anak");
                params.put("id_anak", id_anak);
                for (String str : listBayiLahir){
                    params.put("kesehatan_bayi_saat_lahir", listBayiLahir.toString());
                }
                for (String str : listRuangBayi){
                    params.put("kesehatan_bayi_selama_di_ruang_bayi", listRuangBayi.toString());
                }
                params.put("pengobatan_vitK", vVitK);
                params.put("pengobatan_questran", vQue);
                params.put("pengobatan_light_therapy", vLight);
                params.put("pengobatan_lain2", vLainPengobatan);
                for (String str : listDarahLengkap){
                    params.put("pemeriksaan_lab_darah_lengkap", listDarahLengkap.toString());
                }
                params.put("pemeriksaan_lab_bilirubin1", vBirilubinTgl1);
                params.put("pemeriksaan_lab_bilirubin2", vBirilubinTgl2);
                params.put("pemeriksaan_lab_TORCH", vTorch);
                params.put("pemeriksaan_lab_lain2", vLainLab);
                params.put("pemeriksaan_lain2", vPeriksaLain);
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

    public void setDate1(View view) {
        showDialog(998);
        Toast.makeText(getApplicationContext(), "calender1",
                Toast.LENGTH_SHORT)
                .show();
    }

    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener1, year, month, day);
        }else if (id == 998) {
            return new DatePickerDialog(this,
                    myDateListener2, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener1 = new
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

    private DatePickerDialog.OnDateSetListener myDateListener2 = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate1(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        birilubin_tgl1.setText(new StringBuilder().append(year).append("-")
                .append(month).append("-").append(day));

    }
    private void showDate1(int year, int month, int day) {
        birilubin_tgl2.setText(new StringBuilder().append(year).append("-")
                .append(month).append("-").append(day));
    }
    @Override
    public void onClick(View v) {

    }
}