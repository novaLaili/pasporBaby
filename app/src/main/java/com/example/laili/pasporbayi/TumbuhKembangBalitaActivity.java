package com.example.laili.pasporbayi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TumbuhKembangBalitaActivity extends AppCompatActivity{

        private String[] TKB01 = {"tangan dan kaki bergerak aktif", "mengangkat kepala ketika tengkurap",
                "kepala tegak ketika didudukan"
    ,"tengkurap-terlentang sendiri", "", "duduk tanpa berpegangan", "", "berdiri berpegangan",
    "", "", "berdiri tanpa berpegangan", "", "berjalan", "lari, naik tangga", "menendang bola",
    "melompat", " ", "berdiri satu kaki", "", "", ""};

    String[] TKB02 = {"kepala menoleh ke samping kanan-kiri", "kepala menoleh ke samping kanan-kiri",
    "memegang mainan", "memegang mainan", "meraih, menggapai", "duduk tanpa berpegangan",
    "mengambil dengan tangan kanan dan kiri", "berdiri berpegangan", "menjimpit",
    "memukulkan mainan dengan kedua tangan", "", "memasukkan mainan ke cangkir",
    "mencoret-coret", "menumpuk 2 mainan", "menumpuk 4 mainan", "", "menggambar garis tegak",
    "menggambar lingkaran menggambar tanda tambah, menggambar manusia (kepala, badan, kaki)",
    "menggambar lingkaran menggambar tanda tambah, menggambar manusia (kepala, badan, kaki)",
    "menggambar lingkaran menggambar tanda tambah, menggambar manusia (kepala, badan, kaki)",
    ""};

    String[] TKB11 = {"bereaksi pada bunyi lonceng", "bersuara", "tertawa/berteriak",
    "", "menoleh suara", "", "bersuara ma.. ma..", "bersuara ma.. ma..", "", "", "memanggil papa / mama",
            "", "berbicara dua kata", "berbicara beberapa kata", "menunjuk gambar", "menunjuk bagian tubuh",
            "menyebutkan warna benda", "", "", "", "menghitung mainan"};

    String[] TKB12 = {"menatap wajah ibu/pengasuh", "tersenyum spontan", "memandang tangannya",
    "", "meraih mainan", "memasukkan biskuit ke mulut", "bersuara ma.. ma..", "bersuara ma.. ma..",
    "melambaikan tangan", "bertepuk tangan", "menunjukkan dan meminta", "bermain dengan orang lain",
    "minum dari gelas", "memakai sendok menyuapi boneka", "melepas pakaian, memakai pakaian, menyikat gigi",
    "mencuci tangan, mengeringkan tangan", "menyebut nama teman", "memakai baju kaos",
    "memakai baju tanpa dibantu", "bermain kartu, menyikat gigi tanpa dibantu", "mengambil makanan sendiri"};

    TabelPerkembangan[] tabelPerkembangen;
    List<TabelPerkembangan> list;
    LayoutInflater linf ;
    LinearLayout line1, line2;
    TextView bulan, ket, bidang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_tumbuh_kembang_balita);

        tabelPerkembangen = new TabelPerkembangan[]{
                new TabelPerkembangan(1, "gerak kasar", "tangan dan kaki bergerak aktif"),
                new TabelPerkembangan(1, "gerakan", "kepala menoleh ke samping kanan-kiri"),
                new TabelPerkembangan(1, "komunikasi/berbicara", "bereaksi pada bunyi lonceng"),
                new TabelPerkembangan(1, "sosial dan kemandirian", "menatap wajah ibu/pengasuh"),

                new TabelPerkembangan(2, "gerak kasar", "mengangkat kepala ketika tengkurap"),
                new TabelPerkembangan(2, "gerakan", "kepala menoleh ke samping kanan-kiri"),
                new TabelPerkembangan(2, "komunikasi/berbicara", "bersuara"),
                new TabelPerkembangan(2, "sosial dan kemandirian", "tersenyum spontan"),

                new TabelPerkembangan(3, "gerak kasar", "kepala tegak ketika didudukan"),
                new TabelPerkembangan(3, "gerakan", "memegang mainan"),
                new TabelPerkembangan(3, "komunikasi/berbicara", "tertawa/berteriak"),
                new TabelPerkembangan(3, "sosial dan kemandirian", "memandang tangannya"),

                new TabelPerkembangan(4, "gerak kasar", "tengkurap-terlentang sendiri"),
                new TabelPerkembangan(4, "gerakan", "memegang mainan"),
                new TabelPerkembangan(4, "komunikasi/berbicara", ""),
                new TabelPerkembangan(4, "sosial dan kemandirian", ""),
        };
        list = new ArrayList<TabelPerkembangan>(tabelPerkembangen.length);
        Collections.addAll(list, tabelPerkembangen);

        line1 = (LinearLayout) findViewById(R.id.line1);
        line2 = (LinearLayout) findViewById(R.id.line2);
        bidang= (TextView) findViewById(R.id.bidang);
        ket= (TextView) findViewById(R.id.ket);
        bulan= (TextView) findViewById(R.id.bulan);

        linf = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        linf = LayoutInflater.from(TumbuhKembangBalitaActivity.this);
        int tempUmur = list.get(0).getUmur();
        for (int i=0; i<list.size(); i++){
            if(i>0 && tempUmur!=list.get(i).getUmur()){

            }else{}
        }


        ImageButton buttonHasilKembang = (ImageButton) findViewById(R.id.buttonNext);

        buttonHasilKembang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openTKActivity = new Intent(TumbuhKembangBalitaActivity.this, HasilTumbuhKembangActivity.class);
                startActivity(openTKActivity);
            }
        });

    }
}