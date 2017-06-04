package com.example.laili.pasporbayi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Laili on 20/04/2017.
 */

public class DAOTumbuhKembang {
    private Context context;
    private SQLiteDatabase db;

    public DAOTumbuhKembang(Context context) {
        this.context = context;
        this.db = new DatabaseTumbuhKembang(context).getWritableDatabase();
    }

    public ArrayList<ModelTumbuhKembang> find(){
        ArrayList<ModelTumbuhKembang> list = new ArrayList<>();
        String query = "SELECT * FROM " +DatabaseTumbuhKembang.tabelTumbuhKembang+ " WHERE 1"; //queri untuk findall dari tabeltumbuhkembang

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst(); //mengambil perbaris dari atas

        if (cursor.getCount()>0){ //ada datanya
            do {
                int index = cursor.getInt(cursor.getColumnIndex(DatabaseTumbuhKembang.index));
                int umur = cursor.getInt(cursor.getColumnIndex(DatabaseTumbuhKembang.umur));
                String gerak = cursor.getString(cursor.getColumnIndex(DatabaseTumbuhKembang.gerak));
                String perkembangan = cursor.getString(cursor.getColumnIndex(DatabaseTumbuhKembang.perkembangan));

                ModelTumbuhKembang tumbuhKembang = new ModelTumbuhKembang(index, umur, gerak, perkembangan);
                list.add(tumbuhKembang);
            } while (cursor.moveToNext());
            //perbaris di masukkan arraylist
        }

        cursor.close();
        return list;
    }

    public void save(ModelTumbuhKembang model){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseTumbuhKembang.umur, model.getUmur());
        cv.put(DatabaseTumbuhKembang.perkembangan, model.getPerkembangan());
        cv.put(DatabaseTumbuhKembang.gerak, model.getGerak());

        db.insert(DatabaseTumbuhKembang.tabelTumbuhKembang, null, cv);
    }


}
