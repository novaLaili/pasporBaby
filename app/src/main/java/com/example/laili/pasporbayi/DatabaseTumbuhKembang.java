package com.example.laili.pasporbayi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Laili on 03/06/2017.
 */

public class DatabaseTumbuhKembang extends SQLiteOpenHelper {

    private static String dbName="DbTumbuhKembang";
    private static int dbVersion=1;
    public static String tabelTumbuhKembang="tumbuh_kembang_balita";
    public static String index="tumbuh_kembang_index";
    public static String umur="umur";
    public static String perkembangan="perkembangan";
    public static String gerak="gerak";
    private static String createTableTumbuhKembang="create table "+tabelTumbuhKembang+"(" +
            index+" integer primary key autoincrement," +
            umur+" integer," +
            perkembangan+" text," +
            gerak+" text" +
            ");";

    public DatabaseTumbuhKembang(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableTumbuhKembang); //pertama aplikasi di buka akan menjalankan baris ini, jika sudah ada bakal di lewati, hanya digunakan pertama

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
