package com.example.laili.pasporbayi;

/**
 * Created by test on 25/05/2017.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.laili.pasporbayi.R;

public class MainTumbuhKembangActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String[]>> listDataChild;
    DAOTumbuhKembang daoTumbuhKembang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tumbuhkembangbalita_main_2);
        daoTumbuhKembang = new DAOTumbuhKembang(this);
        Toast.makeText(this, ""+daoTumbuhKembang.find().size(), Toast.LENGTH_SHORT).show();

        Button submit = (Button) findViewById(R.id.idSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelTumbuhKembang model = new ModelTumbuhKembang(1,1,"gerak kasar", "menjimpit");
                daoTumbuhKembang.save(model);
                Intent intent = new Intent (MainTumbuhKembangActivity.this, NavActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        Log.e("Jum List Header", listDataHeader.size()+"");
        Log.e("Jum List Child", listDataChild.size()+"");

        // setting list adapter
        expListView.setAdapter(listAdapter);
        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
        // Listview Group expanded listener
        expListView.expandGroup(0);
        expListView.expandGroup(1);
        expListView.expandGroup(2);
        expListView.expandGroup(3);
        expListView.expandGroup(4);
        expListView.expandGroup(5);
        expListView.expandGroup(6);
        expListView.expandGroup(7);
        expListView.expandGroup(8);
        expListView.expandGroup(9);
        expListView.expandGroup(10);
        expListView.expandGroup(11);
        expListView.expandGroup(12);
        expListView.expandGroup(13);
        expListView.expandGroup(14);
        expListView.expandGroup(15);
        expListView.expandGroup(16);
        expListView.expandGroup(17);
        expListView.expandGroup(18);
        expListView.expandGroup(19);
        expListView.expandGroup(20);
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Expanded",
//                        Toast.LENGTH_SHORT).show();
            }
        });
        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                expListView.expandGroup(0);
                expListView.expandGroup(1);
                expListView.expandGroup(2);
                expListView.expandGroup(3);
                expListView.expandGroup(4);
                expListView.expandGroup(5);
                expListView.expandGroup(6);
                expListView.expandGroup(7);
                expListView.expandGroup(8);
                expListView.expandGroup(9);
                expListView.expandGroup(10);
                expListView.expandGroup(11);
                expListView.expandGroup(12);
                expListView.expandGroup(13);
                expListView.expandGroup(14);
                expListView.expandGroup(15);
                expListView.expandGroup(16);
                expListView.expandGroup(17);
                expListView.expandGroup(18);
                expListView.expandGroup(19);
                expListView.expandGroup(20);
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Collapsed",
//                        Toast.LENGTH_SHORT).show();

            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String[]>>();

        // Adding child data
        listDataHeader.add("1 bulan");
        listDataHeader.add("2 bulan");
        listDataHeader.add("3 bulan");
        listDataHeader.add("4 bulan");
        listDataHeader.add("5 bulan");
        listDataHeader.add("6 bulan");
        listDataHeader.add("7 bulan");
        listDataHeader.add("8 bulan");
        listDataHeader.add("9 bulan");
        listDataHeader.add("10 bulan");
        listDataHeader.add("11 bulan");
        listDataHeader.add("12 bulan");
        listDataHeader.add("15 bulan");
        listDataHeader.add("1.5 tahun");
        listDataHeader.add("2 tahun");
        listDataHeader.add("2.5 tahun");
        listDataHeader.add("3 tahun");
        listDataHeader.add("3.5 tahun");
        listDataHeader.add("4 tahun");
        listDataHeader.add("4.5 tahun");
        listDataHeader.add("5 tahun");

        // Adding child data

        List<String[]>[] data= new List[listDataHeader.size()];
        for (int i = 0; i < listDataHeader.size(); i++) {
            data[i] = new ArrayList<>();
            switch (i){
                case 0:
                    data[i].add(new String[]{"gerak kasar", "tangan dan kaki bergerak aktif"});
                    data[i].add(new String[]{"gerakan", "kepala menoleh ke samping kanan-kiri"});
                    data[i].add(new String[]{"komunikasi/berbicara", "bereaksi pada bunyi lonceng"});
                    data[i].add(new String[]{"sosial dan kemandirian", "menatap wajah ibu/pengasuh"});
                    listDataChild.put(listDataHeader.get(0), data[i]); // Header, Child data
                    break;
                case 1:
                    data[i].add(new String[]{"gerak kasar", "mengangkat kepala ketika tengkurap"});
                    data[i].add(new String[]{"gerakan", "kepala menoleh ke samping kanan-kiri"});
                    data[i].add(new String[]{"komunikasi/berbicara", "bersuara"});
                    data[i].add(new String[]{"sosial dan kemandirian", "tersenyum spontan"});
                    listDataChild.put(listDataHeader.get(1), data[i]);
                    break;
                case 2:
                    data[i].add(new String[]{"gerak kasar", "kepala tegak ketika didudukan"});
                    data[i].add(new String[]{"gerakan", "memegang mainan"});
                    data[i].add(new String[]{"komunikasi/berbicara", "tertawa/berteriak"});
                    data[i].add(new String[]{"sosial dan kemandirian", "memandang tangannya"});
                    listDataChild.put(listDataHeader.get(2), data[i]);
                    break;
                case 3:
                    data[i].add(new String[]{"gerak kasar", "tengkurap-terlentang sendiri"});
                    data[i].add(new String[]{"gerakan", "memegang mainan"});
                    data[i].add(new String[]{"komunikasi/berbicara", ""});
                    data[i].add(new String[]{"sosial dan kemandirian", ""});
                    listDataChild.put(listDataHeader.get(3), data[i]);
                    break;
                case 4:
                    data[i].add(new String[]{"gerak kasar", ""});
                    data[i].add(new String[]{"gerakan", "meraih, menggapai"});
                    data[i].add(new String[]{"komunikasi/berbicara", "menoleh suara"});
                    data[i].add(new String[]{"sosial dan kemandirian", "meraih mainan"});
                    listDataChild.put(listDataHeader.get(4), data[i]);
                    break;
                case 5:
                    data[i].add(new String[]{"gerak kasar", "duduk tanpa berpegangan"});
                    data[i].add(new String[]{"gerakan", "duduk tanpa berpegangan"});
                    data[i].add(new String[]{"komunikasi/berbicara", ""});
                    data[i].add(new String[]{"sosial dan kemandirian", "memasukkan biskuit ke mulut"});
                    listDataChild.put(listDataHeader.get(5), data[i]);
                    break;
                case 6:
                    data[i].add(new String[]{"gerak kasar", ""});
                    data[i].add(new String[]{"gerakan", "mengambil dengan tangan kanan dan kiri"});
                    data[i].add(new String[]{"komunikasi/berbicara", "bersuara ma.. ma.."});
                    data[i].add(new String[]{"sosial dan kemandirian", "bersuara ma.. ma.."});
                    listDataChild.put(listDataHeader.get(6), data[i]);
                    break;
                case 7:
                    data[i].add(new String[]{"gerak kasar", "berdiri berpegangan"});
                    data[i].add(new String[]{"gerakan", "berdiri berpegangan"});
                    data[i].add(new String[]{"komunikasi/berbicara", "bersuara ma.. ma.."});
                    data[i].add(new String[]{"sosial dan kemandirian", "bersuara ma.. ma.."});
                    listDataChild.put(listDataHeader.get(7), data[i]);
                    break;
                case 8:
                    data[i].add(new String[]{"gerak kasar", ""});
                    data[i].add(new String[]{"gerakan", "menjimpit"});
                    data[i].add(new String[]{"komunikasi/berbicara", ""});
                    data[i].add(new String[]{"sosial dan kemandirian", "melambaikan tangan"});
                    listDataChild.put(listDataHeader.get(8), data[i]);
                    break;
                case 9:
                    data[i].add(new String[]{"gerak kasar", ""});
                    data[i].add(new String[]{"gerakan", "memukulkan mainan dengan kedua tangan"});
                    data[i].add(new String[]{"komunikasi/berbicara", ""});
                    data[i].add(new String[]{"sosial dan kemandirian", "bertepuk tangan"});
                    listDataChild.put(listDataHeader.get(9), data[i]);
                    break;
                case 10:
                    data[i].add(new String[]{"gerak kasar", "berdiri tanpa berpegangan"});
                    data[i].add(new String[]{"gerakan", ""});
                    data[i].add(new String[]{"komunikasi/berbicara", "memanggil papa/mama"});
                    data[i].add(new String[]{"sosial dan kemandirian", "menunjukkan dan meminta"});
                    listDataChild.put(listDataHeader.get(10), data[i]);
                    break;
                case 11:
                    data[i].add(new String[]{"gerak kasar", ""});
                    data[i].add(new String[]{"gerakan", "memasukkan mainan ke cangkir"});
                    data[i].add(new String[]{"komunikasi/berbicara", ""});
                    data[i].add(new String[]{"sosial dan kemandirian", "bermain dengan orang lain"});
                    listDataChild.put(listDataHeader.get(11), data[i]);
                    break;
                case 12: //15 bulan
                    data[i].add(new String[]{"gerak kasar", "berjalan"});
                    data[i].add(new String[]{"gerakan", "mencoret-coret"});
                    data[i].add(new String[]{"komunikasi/berbicara", "berbicara dua kata"});
                    data[i].add(new String[]{"sosial dan kemandirian", "minum dari gelas"});
                    listDataChild.put(listDataHeader.get(12), data[i]);
                    break;
                case 13: //1.5 tahun
                    data[i].add(new String[]{"gerak kasar", "lari, naik tangga"});
                    data[i].add(new String[]{"gerakan", "menumpuk 2 mainan"});
                    data[i].add(new String[]{"komunikasi/berbicara", "berbicara beberapa kata"});
                    data[i].add(new String[]{"sosial dan kemandirian", "memakai sendok menyuapi boneka"});
                    listDataChild.put(listDataHeader.get(13), data[i]);
                    break;
                case 14: //2 tahun
                    data[i].add(new String[]{"gerak kasar", "menendang bola"});
                    data[i].add(new String[]{"gerakan", "menumpuk 4 mainan"});
                    data[i].add(new String[]{"komunikasi/berbicara", "menunjuk gambar"});
                    data[i].add(new String[]{"sosial dan kemandirian", "melepas pakaian, memakai pakaian, menyikat gigi"});
                    listDataChild.put(listDataHeader.get(14), data[i]);
                    break;
                case 15: //2.5 tahun
                    data[i].add(new String[]{"gerak kasar", "melompat"});
                    data[i].add(new String[]{"gerakan", ""});
                    data[i].add(new String[]{"komunikasi/berbicara", "menunjuk bagian tubuh"});
                    data[i].add(new String[]{"sosial dan kemandirian", "mencuci tangan, mengeringkan tangan"});
                    listDataChild.put(listDataHeader.get(15), data[i]);
                    break;
                case 16: //3 tahun
                    data[i].add(new String[]{"gerak kasar", ""});
                    data[i].add(new String[]{"gerakan", "menggambar garis tegak"});
                    data[i].add(new String[]{"komunikasi/berbicara", "menyebutkan warna benda"});
                    data[i].add(new String[]{"sosial dan kemandirian", "menyebutkan warna teman"});
                    listDataChild.put(listDataHeader.get(16), data[i]);
                    break;
                case 17: //3.5 tahun
                    data[i].add(new String[]{"gerak kasar", "berdiri satu kaki"});
                    data[i].add(new String[]{"gerakan", "menggambar lingkaran, menggambar tanda tambah, menggambar manusia (kepala, badan, kaki)"});
                    data[i].add(new String[]{"komunikasi/berbicara", ""});
                    data[i].add(new String[]{"sosial dan kemandirian", "memakai baju kaos"});
                    listDataChild.put(listDataHeader.get(17), data[i]);
                    break;
                case 18: //4 tahun
                    data[i].add(new String[]{"gerak kasar", ""});
                    data[i].add(new String[]{"gerakan", "menggambar lingkaran, menggambar tanda tambah, menggambar manusia (kepala, badan, kaki)"});
                    data[i].add(new String[]{"komunikasi/berbicara", ""});
                    data[i].add(new String[]{"sosial dan kemandirian", "memakai baju tanpa dibantu"});
                    listDataChild.put(listDataHeader.get(18), data[i]);
                    break;
                case 19: //4.5 tahun
                    data[i].add(new String[]{"gerak kasar", ""});
                    data[i].add(new String[]{"gerakan", "menggambar lingkaran, menggambar tanda tambah, menggambar manusia (kepala, badan, kaki)"});
                    data[i].add(new String[]{"komunikasi/berbicara", ""});
                    data[i].add(new String[]{"sosial dan kemandirian", "bermain kartu, menyikat gigi tanpa dibantu"});
                    listDataChild.put(listDataHeader.get(19), data[i]);
                    break;
                case 20: //5 tahun
                    data[i].add(new String[]{"gerak kasar", ""});
                    data[i].add(new String[]{"gerakan", ""});
                    data[i].add(new String[]{"komunikasi/berbicara", "menghitung mainan"});
                    data[i].add(new String[]{"sosial dan kemandirian", "mengambil makanan sendiri"});
                    listDataChild.put(listDataHeader.get(20), data[i]);
                    break;
            }
        }

    }
}
