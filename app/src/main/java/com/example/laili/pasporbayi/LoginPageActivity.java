package com.example.laili.pasporbayi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    String match;

    private GoogleApiClient client;

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
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("LoginPage Page") // TODO: Define a title for the content shown.
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

    private void loginUser(){
        final String vUsername = username.getText().toString().trim();
        final String vPassword = password.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://10.252.130.173/pasporBayi_TA/login.php",
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.100/pasporBayi_TA/login.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {
                        if(response.equals("failure")){
                            makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();

                        } else {
                            String arr[] = response.split("_", 2);

                            String id_user = arr[0];   //the
                            String match = arr[1];
                            Log.d("match", match);
                            Log.d("id_user", id_user);

                            Config.SetString(LoginPageActivity.this, "id_user", id_user);
                            Config.SetString(LoginPageActivity.this, "id_anak", id_user);

                            if(match.equals("ADA")){
                                startActivity( new Intent(LoginPageActivity.this, NavActivity.class));
//                                startActivity( new Intent(LoginPageActivity.this, Main2Activity.class));
                                finish();
                            } else if (match.equals("BELUM")){
                                startActivity(new Intent(LoginPageActivity.this, DataAnakActivity.class));
                                finish();
                            }
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
