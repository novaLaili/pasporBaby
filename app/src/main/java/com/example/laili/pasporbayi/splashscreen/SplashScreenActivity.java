package com.example.laili.pasporbayi.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

import com.example.laili.pasporbayi.database.DAOTumbuhKembang;
import com.example.laili.pasporbayi.LoginPageActivity;
import com.example.laili.pasporbayi.NavActivity;
import com.example.laili.pasporbayi.global.SessionManager;
import com.example.laili.pasporbayi.models.ModelTumbuhKembang;
import com.example.laili.pasporbayi.R;

import java.util.ArrayList;

public class SplashScreenActivity extends AppCompatActivity {

    private static final String LOG = "Splash Screen";

    private LoaderManager mLoaderManager;
    private static final int LOADER_ID = 8151;
    private LoaderManager.LoaderCallbacks mCallback = new LoaderManager.LoaderCallbacks() {
        @Override
        public Loader onCreateLoader(int id, Bundle args) {
            return new AsyncTaskLoader<String>(getApplicationContext()) {

                @Override
                public String loadInBackground() {
                    if(DAOTumbuhKembang.getInstance(getApplicationContext()).find().size() <= 0){
                        insertData();
                    }else{
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    return "Completed";
                }

                @Override
                protected void onStartLoading() {
                    forceLoad();
                }
            };
        }

        @Override
        public void onLoadFinished(Loader loader, Object data) {
            if(SessionManager.getInstance(getApplicationContext()).isLogin()){
                startActivity(new Intent(getApplicationContext(), NavActivity.class));
            }else{
                startActivity(new Intent(SplashScreenActivity.this, LoginPageActivity.class));
            }
        }

        @Override
        public void onLoaderReset(Loader loader) {}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mLoaderManager = getSupportLoaderManager();

        if(mLoaderManager.getLoader(LOADER_ID) == null){
            mLoaderManager.initLoader(LOADER_ID, null, mCallback);
        }
    }

    private void insertData(){
        ArrayList<ModelTumbuhKembang> list = new ArrayList<>();

        list.add(new ModelTumbuhKembang("1 bulan", "gerak kasar", "tangan dan kaki bergerak aktif", 0));
        list.add(new ModelTumbuhKembang("1 bulan", "gerakan", "kepala menoleh ke samping kanan-kiri", 0));
        list.add(new ModelTumbuhKembang("1 bulan", "komunikasi/berbicara", "bereaksi pada bunyi lonceng", 0));
        list.add(new ModelTumbuhKembang("1 bulan", "sosial dan kemandirian", "menatap wajah ibu/pengasuh", 0));

        list.add(new ModelTumbuhKembang("2 bulan", "gerak kasar", "mengangkat kepala ketika tengkurap", 0));
        list.add(new ModelTumbuhKembang("2 bulan", "gerakan", "kepala menoleh ke samping kanan-kiri", 0));
        list.add(new ModelTumbuhKembang("2 bulan", "komunikasi/berbicara", "bersuara", 0));
        list.add(new ModelTumbuhKembang("2 bulan", "sosial dan kemandirian", "tersenyum spontan", 0));

        list.add(new ModelTumbuhKembang("3 bulan", "gerak kasar", "kepala tegak ketika didudukan", 0));
        list.add(new ModelTumbuhKembang("3 bulan", "gerakan", "memegang mainan", 0));
        list.add(new ModelTumbuhKembang("3 bulan", "komunikasi/berbicara", "tertawa/berteriak", 0));
        list.add(new ModelTumbuhKembang("3 bulan", "sosial dan kemandirian", "memandang tangannya", 0));

        list.add(new ModelTumbuhKembang("4 bulan", "gerak kasar", "tengkurap-terlentang sendiri", 0));
        list.add(new ModelTumbuhKembang("4 bulan", "gerakan", "memegang mainan", 0));
        list.add(new ModelTumbuhKembang("4 bulan", "komunikasi/berbicara", "-", 0));
        list.add(new ModelTumbuhKembang("4 bulan", "sosial dan kemandirian", "-", 0));

        list.add(new ModelTumbuhKembang("5 bulan", "gerak kasar", "-", 0));
        list.add(new ModelTumbuhKembang("5 bulan", "gerakan", "meraih, menggapai", 0));
        list.add(new ModelTumbuhKembang("5 bulan", "komunikasi/berbicara", "menoleh suara", 0));
        list.add(new ModelTumbuhKembang("5 bulan", "sosial dan kemandirian", "meraih mainan", 0));

        list.add(new ModelTumbuhKembang("6 bulan", "gerak kasar", "duduk tanpa berpegangan", 0));
        list.add(new ModelTumbuhKembang("6 bulan", "gerakan", "duduk tanpa berpegangan", 0));
        list.add(new ModelTumbuhKembang("6 bulan", "komunikasi/berbicara", "-", 0));
        list.add(new ModelTumbuhKembang("6 bulan", "sosial dan kemandirian", "memasukkan biskuit ke mulut", 0));

        list.add(new ModelTumbuhKembang("7 bulan", "gerak kasar", "-", 0));
        list.add(new ModelTumbuhKembang("7 bulan", "gerakan", "mengambil dengan tangan kanan dan kiri", 0));
        list.add(new ModelTumbuhKembang("7 bulan", "komunikasi/berbicara", "bersuara ma.. ma..", 0));
        list.add(new ModelTumbuhKembang("7 bulan", "sosial dan kemandirian", "bersuara ma.. ma..", 0));

        list.add(new ModelTumbuhKembang("8 bulan", "gerak kasar", "berdiri berpegangan", 0));
        list.add(new ModelTumbuhKembang("8 bulan", "gerakan", "berdiri berpegangan", 0));
        list.add(new ModelTumbuhKembang("8 bulan", "komunikasi/berbicara", "bersuara ma.. ma..", 0));
        list.add(new ModelTumbuhKembang("8 bulan", "sosial dan kemandirian", "bersuara ma.. ma..", 0));

        list.add(new ModelTumbuhKembang("9 bulan", "gerak kasar", "-", 0));
        list.add(new ModelTumbuhKembang("9 bulan", "gerakan", "menjimpit", 0));
        list.add(new ModelTumbuhKembang("9 bulan", "komunikasi/berbicara", "-", 0));
        list.add(new ModelTumbuhKembang("9 bulan", "sosial dan kemandirian", "melambaikan tangan", 0));

        list.add(new ModelTumbuhKembang("10 bulan", "gerak kasar", "-", 0));
        list.add(new ModelTumbuhKembang("10 bulan", "gerakan", "memukulkan mainan dengan kedua tangan", 0));
        list.add(new ModelTumbuhKembang("10 bulan", "komunikasi/berbicara", "-", 0));
        list.add(new ModelTumbuhKembang("10 bulan", "sosial dan kemandirian", "bertepuk tangan", 0));

        list.add(new ModelTumbuhKembang("11 bulan", "gerak kasar", "berdiri tanpa berpegangan", 0));
        list.add(new ModelTumbuhKembang("11 bulan", "gerakan", "-", 0));
        list.add(new ModelTumbuhKembang("11 bulan", "komunikasi/berbicara", "memanggil papa/mama", 0));
        list.add(new ModelTumbuhKembang("11 bulan", "sosial dan kemandirian", "menunjukkan dan meminta", 0));

        list.add(new ModelTumbuhKembang("12 bulan", "gerak kasar", "-", 0));
        list.add(new ModelTumbuhKembang("12 bulan", "gerakan", "memasukkan mainan ke cangkir", 0));
        list.add(new ModelTumbuhKembang("12 bulan", "komunikasi/berbicara", "-", 0));
        list.add(new ModelTumbuhKembang("12 bulan", "sosial dan kemandirian", "bermain dengan orang lain", 0));

        list.add(new ModelTumbuhKembang("15 bulan", "gerak kasar", "berjalan", 0));
        list.add(new ModelTumbuhKembang("15 bulan", "gerakan", "mencoret-coret", 0));
        list.add(new ModelTumbuhKembang("15 bulan", "komunikasi/berbicara", "berbicara dua kata", 0));
        list.add(new ModelTumbuhKembang("15 bulan", "sosial dan kemandirian", "minum dari gelas", 0));

        list.add(new ModelTumbuhKembang("1.5 tahun", "gerak kasar", "lari, naik tangga", 0));
        list.add(new ModelTumbuhKembang("1.5 tahun", "gerakan", "menumpuk 2 mainan", 0));
        list.add(new ModelTumbuhKembang("1.5 tahun", "komunikasi/berbicara", "berbicara beberapa kata", 0));
        list.add(new ModelTumbuhKembang("1.5 tahun", "sosial dan kemandirian", "memakai sendok menyuapi boneka", 0));

        list.add(new ModelTumbuhKembang("2 tahun", "gerak kasar", "menendang bola", 0));
        list.add(new ModelTumbuhKembang("2 tahun", "gerakan", "menumpuk 4 mainan", 0));
        list.add(new ModelTumbuhKembang("2 tahun", "komunikasi/berbicara", "menunjuk gambar", 0));
        list.add(new ModelTumbuhKembang("2 tahun", "sosial dan kemandirian", "melepas pakaian, memakai pakaian, menyikat gigi", 0));

        list.add(new ModelTumbuhKembang("2.5 tahun", "gerak kasar", "melompat", 0));
        list.add(new ModelTumbuhKembang("2.5 tahun", "gerakan", "-", 0));
        list.add(new ModelTumbuhKembang("2.5 tahun", "komunikasi/berbicara", "menunjuk bagian tubuh", 0));
        list.add(new ModelTumbuhKembang("2.5 tahun", "sosial dan kemandirian", "mencuci tangan, mengeringkan tangan", 0));

        list.add(new ModelTumbuhKembang("3 tahun", "gerak kasar", "-", 0));
        list.add(new ModelTumbuhKembang("3 tahun", "gerakan", "menggambar garis tegak", 0));
        list.add(new ModelTumbuhKembang("3 tahun", "komunikasi/berbicara", "menyebutkan warna benda", 0));
        list.add(new ModelTumbuhKembang("3 tahun", "sosial dan kemandirian", "menyebutkan warna teman", 0));

        list.add(new ModelTumbuhKembang("3.5 tahun", "gerak kasar", "berdiri satu kaki", 0));
        list.add(new ModelTumbuhKembang("3.5 tahun", "gerakan", "menggambar lingkaran, menggambar tanda tambah, menggambar manusia (kepala, badan, kaki)", 0));
        list.add(new ModelTumbuhKembang("3.5 tahun", "komunikasi/berbicara", "-", 0));
        list.add(new ModelTumbuhKembang("3.5 tahun", "sosial dan kemandirian", "memakai baju kaos", 0));

        list.add(new ModelTumbuhKembang("4 tahun", "gerak kasar", "-", 0));
        list.add(new ModelTumbuhKembang("4 tahun", "gerakan", "menggambar lingkaran, menggambar tanda tambah, menggambar manusia (kepala, badan, kaki)", 0));
        list.add(new ModelTumbuhKembang("4 tahun", "komunikasi/berbicara", "-", 0));
        list.add(new ModelTumbuhKembang("4 tahun", "sosial dan kemandirian", "memakai baju tanpa dibantu", 0));

        list.add(new ModelTumbuhKembang("4.5 tahun", "gerak kasar", "-", 0));
        list.add(new ModelTumbuhKembang("4.5 tahun", "gerakan", "menggambar lingkaran, menggambar tanda tambah, menggambar manusia (kepala, badan, kaki)", 0));
        list.add(new ModelTumbuhKembang("4.5 tahun", "komunikasi/berbicara", "-", 0));
        list.add(new ModelTumbuhKembang("4.5 tahun", "sosial dan kemandirian", "bermain kartu, menyikat gigi tanpa dibantu", 0));

        list.add(new ModelTumbuhKembang("5 tahun", "gerak kasar", "-", 0));
        list.add(new ModelTumbuhKembang("5 tahun", "gerakan", "-", 0));
        list.add(new ModelTumbuhKembang("5 tahun", "komunikasi/berbicara", "menghitung mainan", 0));
        list.add(new ModelTumbuhKembang("5 tahun", "sosial dan kemandirian", "mengambil makanan sendiri", 0));

        for (int i = 0; i < list.size(); i++) {
            DAOTumbuhKembang.getInstance(this).save(list.get(i));
        }
    }
}
