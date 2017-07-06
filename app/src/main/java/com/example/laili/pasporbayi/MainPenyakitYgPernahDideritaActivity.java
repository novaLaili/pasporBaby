package com.example.laili.pasporbayi;

import android.app.Activity;

public class MainPenyakitYgPernahDideritaActivity extends Activity {

}

    /*ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String[]>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.penyakitygpernahdiderita_main_2);

        Button submit = (Button) findViewById(R.id.idSubmitMedikPenting);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        expListView = (ExpandableListView) findViewById(R.id.lvExpMP);

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
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
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

            }
        });
    }*/

    /*
     * Preparing the list data
     */
    /*private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String[]>>();

        // Adding child data
        listDataHeader.add(" ");
        listDataHeader.add(" ");

        // Adding child data
        List<String[]>[] data= new List[listDataHeader.size()];
        for (int i = 0; i < listDataHeader.size(); i++) {
            data[i] = new ArrayList<>();
            switch (i) {
                case 0:
                    data[i].add(new String[]{"Cacar Air (Varicella)", "TBC"});
                    listDataChild.put(listDataHeader.get(0), data[i]); // Header, Child data
                    break;
                case 1:
                    data[i].add(new String[]{"Difteri", "Kejang"});
                    listDataChild.put(listDataHeader.get(1), data[i]);
                    break;
                case 2:
                    data[i].add(new String[]{"Campak(Morbili)", "Hepatitis"});
                    listDataChild.put(listDataHeader.get(2), data[i]);
                    break;
                case 3:
                    data[i].add(new String[]{"Enteritis (Diare)", "Gondangan"});
                    listDataChild.put(listDataHeader.get(3), data[i]);
                    break;
                case 4:
                    data[i].add(new String[]{"Demam Berdarah (DHF)", "Tetanus"});
                    listDataChild.put(listDataHeader.get(4), data[i]);
                    break;
                case 5:
                    data[i].add(new String[]{"Batuk Rejan (Pertusis)", "Bronkopneumonia"});
                    listDataChild.put(listDataHeader.get(5), data[i]);
                    break;
                case 6:
                    data[i].add(new String[]{"Demam Tifoid (Tifus Abdominalis)", "Poliomielitis"});
                    listDataChild.put(listDataHeader.get(6), data[i]);
                    break;
                case 7:
                    data[i].add(new String[]{"Asma Bronkial", " "});
                    listDataChild.put(listDataHeader.get(7), data[i]);
                    break;
                case 8:
                    data[i].add(new String[]{" ", ""});
                    listDataChild.put(listDataHeader.get(8), data[i]);
                    break;
            }
        }*/
