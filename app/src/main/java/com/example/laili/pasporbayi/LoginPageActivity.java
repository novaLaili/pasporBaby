package com.example.laili.pasporbayi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.example.laili.pasporbayi.global.Api;
import com.example.laili.pasporbayi.global.SessionManager;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.makeText;

public class LoginPageActivity extends AppCompatActivity {

    Button login;
    Button regis;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_login);

        username = (EditText) findViewById(R.id.inuser);
        password = (EditText) findViewById(R.id.inpass);
        login = (Button) findViewById(R.id.btnlgn);
        regis = (Button) findViewById(R.id.btnRegistrasi);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnRegistrasi :
                        Intent openRKAActivity = new Intent(LoginPageActivity.this, PendaftaranActivity.class);
                        startActivity(openRKAActivity);
                }
            }
        });


    }

    private void loginUser(){
        final String vUsername = username.getText().toString().trim();
        final String vPassword = password.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, Api.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("failure")){
                            makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                        } else {
                            SessionManager.getInstance(LoginPageActivity.this).createSession(response);
                            startActivity(new Intent(LoginPageActivity.this, NavActivity.class));
                            finish();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        makeText(LoginPageActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){

            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("username",vUsername);
                params.put("password",vPassword);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
