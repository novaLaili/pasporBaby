package com.example.laili.pasporbayi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import static android.accounts.AccountManager.KEY_PASSWORD;

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
                attemptRegister();
                registerUser();

            }
        });

        nama = (EditText) findViewById(R.id.inuser);
        username = (EditText) findViewById(R.id.inusername);
        password = (EditText) findViewById(R.id.inpass);
        repeatPass = (EditText) findViewById(R.id.inrepeatPass);
    }

    private void attemptRegister(){
        String name = nama.getText().toString();
        String user = username.getText().toString();
        String pass = password.getText().toString();
        String confPass = repeatPass.getText().toString();

        View view = null;
        boolean cancel = false;

        if(TextUtils.isEmpty(confPass)){
            repeatPass.setError("Field harus diisi");
            view = repeatPass;
            cancel = true;
        }else if(!confPass.equals(pass)){
            repeatPass.setError("Password tidak sama");
            view = repeatPass;
            cancel = true;
        }

        if(TextUtils.isEmpty(pass)){
            password.setError("Field harus diisi");
            view = password;
            cancel = true;
        }

        if(TextUtils.isEmpty(user)){
            username.setError("Field harus diisi");
            view = username;
            cancel = true;
        }

        if(TextUtils.isEmpty(name)){
            nama.setError("Field harus diisi");
            view = nama;
            cancel = true;
        }

        if(cancel){
            view.requestFocus();
        }else{
            registerUser();
        }
    }

    private void registerUser(){
        final String vUsername = username.getText().toString().trim();
        final String vPassword = password.getText().toString().trim();
        final String vNama = nama.getText().toString().trim();

//        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://10.252.131.202/pasporBayi_TA/register.php",
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.1.177/pasporBayi_TA/register.php",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    if(!response.equals("oops! Please try again")){
                        int id = Integer.valueOf(response.split(";")[1]);
                        manager.setUserID(id);
                        Intent openActivity = new Intent(PendaftaranActivity.this, DataAnakActivity.class);
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
