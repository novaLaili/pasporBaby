package com.example.laili.pasporbayi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.ikimuhendis.ldrawer.ActionBarDrawerToggle;
import com.ikimuhendis.ldrawer.DrawerArrowDrawable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerArrowDrawable drawerArrow;
    private boolean drawerArrowColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonDDBalita = (Button) findViewById(R.id.buttonDataDasarBalita);
        buttonDDBalita.setOnClickListener(this);

        Button buttonStatusGizi = (Button) findViewById(R.id.buttonStatusGizi);
        buttonStatusGizi.setOnClickListener(this);

        Button buttonTumbuhKembagBalita = (Button) findViewById(R.id.buttonTKB);
        buttonTumbuhKembagBalita.setOnClickListener(this);

        Button buttonCatatanKunjungan = (Button) findViewById(R.id.buttonCatKunjungan);
        buttonCatatanKunjungan.setOnClickListener(this);

//        Button buttonTumbuhKembagBalita = (Button) findViewById(R.id.buttonTKB);
//        buttonTumbuhKembagBalita.setOnClickListener(this);

//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mDrawerList = (ListView) findViewById(R.id.navdrawer);
//
//
//        drawerArrow = new DrawerArrowDrawable(this) {
//            @Override
//            public boolean isLayoutRtl() {
//                return false;
//            }
//        };
//        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
//                drawerArrow, R.string.drawer_open,
//                R.string.drawer_close) {
//
//            public void onDrawerClosed(View view) {
//                super.onDrawerClosed(view);
//                invalidateOptionsMenu();
//            }
//
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//                invalidateOptionsMenu();
//            }
//        };
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
//        mDrawerToggle.syncState();
//
//
//        String[] values = new String[]{
//                "Stop Animation (Back icon)",
//                "Stop Animation (Home icon)",
//                "Start Animation",
//                "Change Color",
//                "GitHub Page",
//                "Share",
//                "Rate"
//        };
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, values);
//        mDrawerList.setAdapter(adapter);
//        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                switch (position) {
//                    case 0:
//                        mDrawerToggle.setAnimateEnabled(false);
//                        drawerArrow.setProgress(1f);
//                        break;
//                    case 1:
//                        mDrawerToggle.setAnimateEnabled(false);
//                        drawerArrow.setProgress(0f);
//                        break;
//                    case 2:
//                        mDrawerToggle.setAnimateEnabled(true);
//                        mDrawerToggle.syncState();
//                        break;
//                    case 3:
//                        if (drawerArrowColor) {
//                            drawerArrowColor = false;
//                            drawerArrow.setColor(R.color.ldrawer_color);
//                        } else {
//                            drawerArrowColor = true;
//                            drawerArrow.setColor(R.color.drawer_arrow_second_color);
//                        }
//                        mDrawerToggle.syncState();
//                        break;
//                    case 4:
//                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/IkiMuhendis/LDrawer"));
//                        startActivity(browserIntent);
//                        break;
//                    case 5:
//                        Intent share = new Intent(Intent.ACTION_SEND);
//                        share.setType("text/plain");
//                        share.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        share.putExtra(Intent.EXTRA_SUBJECT,
//                                getString(R.string.app_name));
//                        share.putExtra(Intent.EXTRA_TEXT, getString(R.string.app_description) + "\n" +
//                                "GitHub Page :  https://github.com/IkiMuhendis/LDrawer\n" +
//                                "Sample App : https://play.google.com/store/apps/details?id=" +
//                                getPackageName());
//                        startActivity(Intent.createChooser(share,
//                                getString(R.string.app_name)));
//                        break;
//                    case 6:
//                        String appUrl = "https://play.google.com/store/apps/details?id=" + getPackageName();
//                        Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(appUrl));
//                        startActivity(rateIntent);
//                        break;
//                }
//
//            }
//        });
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.buttonDataDasarBalita :
                //perintah
                //Toast.makeText(getBaseContext(),"Haloo !!", Toast.LENGTH_LONG).show();
                Intent openDDAActivity = new Intent(MainActivity.this,RekapDataAnakActivity.class);
                startActivity(openDDAActivity);
                break;
            case R.id.buttonStatusGizi :
                Intent openStatusGizi = new Intent(MainActivity.this,StatusGiziActivity.class);
                startActivity(openStatusGizi);
                break;
            case R.id.buttonTKB :
                Intent openTumbuhKembang = new Intent(MainActivity.this,TumbuhKembangBalitaActivity.class);
                startActivity(openTumbuhKembang);
                break;
            case R.id.buttonImunisasi :
                Intent openImunisasi = new Intent(MainActivity.this,HasilImunisasiActivity.class);
                startActivity(openImunisasi);
                break;
            case R.id.buttonCatKunjungan :
                Intent openCatKunj = new Intent(MainActivity.this, CatatanKunjunganActivity.class);
                startActivity(openCatKunj);
                break;
        }
    }
}
