package com.example.laili.pasporbayi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class PendaftaranActivity extends AppCompatActivity implements View.OnClickListener{
    Button create;
    EditText nama;
    EditText username;
    EditText password;
    EditText repeatPass;
    SharedPrefManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_registrasi);

        create = (Button) findViewById(R.id.btnCreate);
        manager = SharedPrefManager.getmInstance(this);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                switch (view.getId()) {
//                    case R.id.btnCreate :
//                        Intent openRKAActivity = new Intent(PendaftaranActivity.this, DataAnakActivity.class);
//                        startActivity(openRKAActivity);
//                }
                registerUser();

            }
        });

        nama = (EditText) findViewById(R.id.inuser);
        username = (EditText) findViewById(R.id.inusername);
        password = (EditText) findViewById(R.id.inpass);
        repeatPass = (EditText) findViewById(R.id.inrepeatPass);
    }

    private void registerUser(){
        final String vUsername = username.getText().toString().trim();
        final String vPassword = password.getText().toString().trim();
        final String vNama = nama.getText().toString().trim();
        final String vRepeatPassword = repeatPass.getText().toString().trim();

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


        //StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://10.252.132.183/pasporBayi_TA/register.php",
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://10.252.130.173/pasporBayi_TA/register.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(!response.equals("oops! Please try again")){
                            int id = Integer.valueOf(response.split(";")[1]);
                            manager.setUserID(id);
                            Intent openActivity = new Intent(PendaftaranActivity.this, NavActivity.class);
                            startActivity(openActivity);
                        }
                        Toast.makeText(PendaftaranActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PendaftaranActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("username",vUsername);
                params.put("password",vPassword);
                params.put("nama",vNama);
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
