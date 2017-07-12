package com.example.laili.pasporbayi.database;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper instance;

    public static synchronized DBHelper getInstance(Context context){
        if(instance == null) instance = new DBHelper(context);

        return instance;
    }

    private static final String DB_NAME = "paspor_bayi";
    private static final int DB_VERSION = 1;

    public static final String TABLE_TK = "table_tk";
    public static final String COLUMN_TK_INDEX = "tk_index";
    public static final String COLUMN_TK_UMUR = "tk_umur";
    public static final String COLUMN_TK_PERKEMBANGAN = "tk_perkembangan";
    public static final String COLUMN_TK_GERAK = "tk_gerak";
    public static final String COLUMN_TK_STATUS = "tk_done";
    private static final String CREATE_TABLE_TK = "CREATE TABLE " +TABLE_TK+ "(" +
            COLUMN_TK_INDEX+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_TK_UMUR+ " TEXT, " +
            COLUMN_TK_PERKEMBANGAN+ " TEXT, " +
            COLUMN_TK_GERAK+ " TEXT, " +
            COLUMN_TK_STATUS + " INTEGER DEFAULT 0" +
    ")";

    public static final String TABLE_NAME = "tabel_imunisasi";
    public static final String ID_IMUNISASI = "id_imunisasi";
    public static final String NAMA_IMUNISASI = "nama_imunisasi";
    public static final String UMUR_YANG_DIANJURKAN = "umur_yang_dianjurkan";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DB_NAME , null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table tabel_imunisasi " +
                        "(id_imunisasi integer primary key, nama_imunisasi varchar,umur_yang_dianjurkan varchar)"
        );

        db.execSQL(CREATE_TABLE_TK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS tabel_imunisasi");
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_TK);
        onCreate(db);
    }

    public boolean insertContact (String nama_imunisasi, String umur_yang_dianjurkan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama_imunisasi", nama_imunisasi);
        contentValues.put("umur_yang_dianjurkan", umur_yang_dianjurkan);
        db.insert("tabel_imunisasi", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from tabel_imunisasi where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

    public boolean updateContact (Integer id, String nama_imunisasi, String umur_yang_dianjurkan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama_imunisasi", nama_imunisasi);
        contentValues.put("umur_yang_dianjurkan", umur_yang_dianjurkan);
        db.update("tabel_imunisasi", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("tabel_imunisasi",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllCotacts() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from tabel_imunisasi", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(NAMA_IMUNISASI)));
            res.moveToNext();
        }
        return array_list;
    }
}