package com.example.laili.pasporbayi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.laili.pasporbayi.models.ModelTumbuhKembang;

import java.util.ArrayList;

/**
 * Created by Laili on 20/04/2017.
 */

public class DAOTumbuhKembang {

    private static DAOTumbuhKembang instance;

    public static synchronized DAOTumbuhKembang getInstance(Context context){
        if(instance == null) instance = new DAOTumbuhKembang(context);

        return instance;
    }

    private SQLiteDatabase db;

    public DAOTumbuhKembang(Context context) {
        this.db = DBHelper.getInstance(context).getWritableDatabase();
    }

    public ArrayList<ModelTumbuhKembang> find(){
        ArrayList<ModelTumbuhKembang> list = new ArrayList<>();
        String query = "SELECT * FROM " +DBHelper.TABLE_TK+ " WHERE 1"; //queri untuk findall dari tabeltumbuhkembang

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst(); //mengambil perbaris dari atas

        if (cursor.getCount()>0){ //ada datanya
            do {
                ModelTumbuhKembang tk = new ModelTumbuhKembang(cursor);
                list.add(tk);
            } while (cursor.moveToNext());
            //perbaris di masukkan arraylist
        }

        cursor.close();
        return list;
    }

    public ArrayList<ModelTumbuhKembang> findByUmur(String umur){
        ArrayList<ModelTumbuhKembang> list = new ArrayList<>();
        String query = "SELECT * FROM " +DBHelper.TABLE_TK+ " WHERE " +DBHelper.COLUMN_TK_UMUR+ "='" +umur+ "'";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst(); //mengambil perbaris dari atas

        if (cursor.getCount()>0){ //ada datanya
            do {
                ModelTumbuhKembang tk = new ModelTumbuhKembang(cursor);
                list.add(tk);
            } while (cursor.moveToNext());
            //perbaris di masukkan arraylist
        }

        cursor.close();
        return list;
    }

    public void save(ModelTumbuhKembang model){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_TK_UMUR, model.getUmur());
        cv.put(DBHelper.COLUMN_TK_PERKEMBANGAN, model.getPerkembangan());
        cv.put(DBHelper.COLUMN_TK_GERAK, model.getGerak());
        cv.put(DBHelper.COLUMN_TK_STATUS, model.getStatus());

        db.insert(DBHelper.TABLE_TK, null, cv);
    }

    public void updateStatus(ModelTumbuhKembang tk){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_TK_STATUS, tk.getStatus());

        db.update(DBHelper.TABLE_TK, cv, DBHelper.COLUMN_TK_INDEX+ "=?", new String[]{"" +tk.getIndex()});
    }
}
