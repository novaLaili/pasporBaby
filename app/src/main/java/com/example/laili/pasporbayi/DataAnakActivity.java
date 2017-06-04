package com.example.laili.pasporbayi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DataAnakActivity extends AppCompatActivity implements View.OnClickListener  {
    SharedPrefManager manager;
    EditText nama, waktu, berat, panjang, LK, tempat_lahir, RS,
            nama_ayah, tgl_lahir_ayah, tempat_lahir_ayah, pekerjaan_ayah, alamat_kantor_ayah,
            tlp_kantor_ayah, tlp_seluler_ayah, nama_ibu, tgl_lahir_ibu, tempat_lahir_ibu, pekerjaan_ibu,
            alamat_kantor_ibu, tlp_kantor_ibu, tlp_seluler_ibu, nama_dktr_kandungan, nama_dktr_anak, kondisi_saran;

    private Calendar calendar;
    private TextView dateView, dateViewAyah, dateViewIbu;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dra_form_data_anak);

        manager = SharedPrefManager.getmInstance(this);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day); //menampilkan tanggal

        ImageButton next = (ImageButton) findViewById(R.id.buttonNext);
        ImageButton home = (ImageButton) findViewById(R.id.buttonHome);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDataUser();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonHome :
                        Intent openDAActivity = new Intent(DataAnakActivity.this, MainActivity.class);
                        startActivity(openDAActivity);
                }
            }
        });
        SearchID();
    }

    void SearchID(){
        dateView = (TextView) findViewById(R.id.calenderTgl);
        dateViewAyah = (TextView) findViewById(R.id.calenderTglLahirAyah);
        dateViewIbu = (TextView) findViewById(R.id.calenderTglLahirIbu);
        nama = (EditText) findViewById(R.id.editTextNama);
        waktu = (EditText) findViewById(R.id.editTextwaktu);
        berat = (EditText) findViewById(R.id.editTextDABerat);
        panjang = (EditText) findViewById(R.id.editTextpanjang);
        LK = (EditText) findViewById(R.id.editTextLK);
        tempat_lahir = (EditText) findViewById(R.id.editTexttmptLahir);
        RS = (EditText) findViewById(R.id.editTextRS);
        nama_ayah = (EditText) findViewById(R.id.editTextNamaAyah);
        tempat_lahir_ayah = (EditText) findViewById(R.id.editTexttempat_lahir_Ayah);
        pekerjaan_ayah = (EditText) findViewById(R.id.editTextpekerjaanAyah);
        alamat_kantor_ayah = (EditText) findViewById(R.id.editTextAlamatKantorAyah);
        tlp_kantor_ayah = (EditText) findViewById(R.id.editTextTelpKntrAyah);
        tlp_seluler_ayah = (EditText) findViewById(R.id.editTextTelpSllerAyah);
        nama_ibu = (EditText) findViewById(R.id.editTextNamaIbu);
        tempat_lahir_ibu = (EditText) findViewById(R.id.editTexttempat_lahir_ibu);
        pekerjaan_ibu = (EditText) findViewById(R.id.editTextpekerjaanIbu);
        alamat_kantor_ibu = (EditText) findViewById(R.id.editTextAlamatKantorIbu);
        tlp_kantor_ibu = (EditText) findViewById(R.id.editTextTlpKantorIbu);
        tlp_seluler_ibu = (EditText) findViewById(R.id.editTextTelpSllerIbu);
        nama_dktr_kandungan = (EditText) findViewById(R.id.editNamaDktrKndungan);
        nama_dktr_anak = (EditText) findViewById(R.id.editTextNamaDktrAnak);
        kondisi_saran = (EditText) findViewById(R.id.editTextKondisi);
    }

    private void InputDataUser(){
        final String vNama = nama.getText().toString().trim();
        final String vTanggal_lahir = dateView.getText().toString().trim();
        final String vWaktu = waktu.getText().toString().trim();
        final String vBerat = berat.getText().toString().trim();
        final String vPanjang = panjang.getText().toString().trim();
        final String vLingkar_kepala = LK.getText().toString().trim();
        final String vTempat_lahir = tempat_lahir.getText().toString().trim();
        final String vRumahSakit = RS.getText().toString().trim();
        final String vNama_ayah = nama_ayah.getText().toString().trim();
        final String vTgl_lahir_ayah = dateViewAyah.getText().toString().trim();
        final String vTempat_lahir_ayah = tempat_lahir_ayah.getText().toString().trim();
        final String vPekerjaan_ayah = pekerjaan_ayah.getText().toString().trim();
        final String vAlamat_ayah = alamat_kantor_ayah.getText().toString().trim();
        final String vTlp_kantor_ayah = tlp_kantor_ayah.getText().toString().trim();
        final String vTlp_seluler_ayah = tlp_seluler_ayah.getText().toString().trim();
        final String vNama_ibu = nama.getText().toString().trim();
        final String vTgl_lahir_ibu = dateViewIbu.getText().toString().trim();
        final String vTempat_lahir_ibu = tempat_lahir_ibu.getText().toString().trim();
        final String vPekerjaan_ibu = pekerjaan_ibu.getText().toString().trim();
        final String vAlamat_ibu = alamat_kantor_ibu.getText().toString().trim();
        final String vTlp_kantor_ibu = tlp_kantor_ibu.getText().toString().trim();
        final String vTlp_seluler_ibu = tlp_seluler_ibu.getText().toString().trim();
        final String vDokter_kandungan = nama_dktr_kandungan.getText().toString().trim();
        final String vDokter_anak = nama_dktr_anak.getText().toString().trim();
        final String vKondisi= kondisi_saran.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://10.252.129.206/pasporBayi_TA/form_data_anak.php",
        //StringRequest stringRequest = new StringRequest(Request.Method.POST, "http:///192.168.0.105/pasporBayi_TA/form_data_anak.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(!response.equals("oops! Please try again")){
                            Intent openDAActivity = new Intent(DataAnakActivity.this, RiwayatKelahiranActivity.class);
                            startActivity(openDAActivity);
                        }
                        else {
                            Intent openDAActivity = new Intent(DataAnakActivity.this, RiwayatKelahiranActivity.class);
                            Config.SetString(DataAnakActivity.this, "id_anak", response);
                            Log.d("id_anak",response);
                            startActivity(openDAActivity);
                        }
                        //Toast.makeText(DataAnakActivity.this, response, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(PendaftaranActivity.this,response,Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Test", "Ini request error " +error.getMessage());
                        Toast.makeText(DataAnakActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("nama",vNama);
                params.put("tgl_lahir",vTanggal_lahir);
                params.put("waktu",vWaktu);
                params.put("berat",vBerat);
                params.put("panjang",vPanjang);
                params.put("LK",vLingkar_kepala);
                params.put("tempat_lahir",vTempat_lahir);
                params.put("RS",vRumahSakit);
                params.put("nama_ayah",vNama_ayah);
                params.put("TTL_ayah",vTgl_lahir_ayah);
                params.put("tempat_lahir_ayah",vTempat_lahir_ayah);
                params.put("pekerjaan_ayah",vPekerjaan_ayah);
                params.put("alamat_kantor_ayah",vAlamat_ayah);
                params.put("tlp_kantor_ayah",vTlp_kantor_ayah);
                params.put("tlp_seluler_ayah",vTlp_seluler_ayah);
                params.put("nama_ibu",vNama_ibu);
                params.put("TTL_ibu",vTgl_lahir_ibu);
                params.put("tempat_lahir_ibu",vTempat_lahir_ibu);
                params.put("pekerjaan_ibu",vPekerjaan_ibu);
                params.put("alamat_kantor_ibu",vAlamat_ibu);
                params.put("tlp_kantor_ibu",vTlp_kantor_ibu);
                params.put("tlp_seluler_ibu",vTlp_seluler_ibu);
                params.put("nama_dktr_kandungan_yg_membantu_kelahiran",vDokter_kandungan);
                params.put("nama_dktr_anak_yg_membantu_kelahiran",vDokter_anak);
                params.put("kondisi_atau_saran_khusus_yg_diberikan",vKondisi);
                params.put("id_user",""+manager.getUserId());
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
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

    //fungsi menampilkan tanggal
    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(year).append("-")
                .append(month).append("-").append(day));
    }

    @Override
    public void onClick(View v) {
    }
}
