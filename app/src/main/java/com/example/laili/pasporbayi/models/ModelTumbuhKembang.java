package com.example.laili.pasporbayi.models;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.laili.pasporbayi.database.DBHelper;

/**
 * Created by Laili on 03/06/2017.
 */

public class ModelTumbuhKembang implements Parcelable {
    int index, status;
    String umur, gerak, perkembangan;

    public ModelTumbuhKembang(String umur, String gerak, String perkembangan, int status) {
        this.index = index;
        this.umur = umur;
        this.gerak = gerak;
        this.perkembangan = perkembangan;
    }

    public ModelTumbuhKembang(Cursor cursor){
        this.setIndex(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_TK_INDEX)));
        this.setUmur(cursor.getString(  cursor.getColumnIndex(DBHelper.COLUMN_TK_UMUR)));
        this.setGerak(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TK_GERAK)));
        this.setPerkembangan(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TK_PERKEMBANGAN)));
        this.setStatus(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_TK_STATUS)));
    }

    protected ModelTumbuhKembang(Parcel in) {
        index = in.readInt();
        umur = in.readString();
        gerak = in.readString();
        perkembangan = in.readString();
        status = in.readInt();
    }

    public static final Creator<ModelTumbuhKembang> CREATOR = new Creator<ModelTumbuhKembang>() {
        @Override
        public ModelTumbuhKembang createFromParcel(Parcel in) {
            return new ModelTumbuhKembang(in);
        }

        @Override
        public ModelTumbuhKembang[] newArray(int size) {
            return new ModelTumbuhKembang[size];
        }
    };

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getGerak() {
        return gerak;
    }

    public void setGerak(String gerak) {
        this.gerak = gerak;
    }

    public String getPerkembangan() {
        return perkembangan;
    }

    public void setPerkembangan(String perkembangan) {
        this.perkembangan = perkembangan;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(index);
        parcel.writeString(umur);
        parcel.writeString(gerak);
        parcel.writeString(perkembangan);
        parcel.writeInt(status);
    }
}
