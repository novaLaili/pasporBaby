package com.example.laili.pasporbayi.tumbuhkembang;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.laili.pasporbayi.models.ModelTumbuhKembang;

import java.util.ArrayList;

/**
 * Created by Bend on 6/14/2017.
 */

public class ObjectExpandableTumbuhKembang implements Parcelable {
    private String umur;
    private ArrayList<ModelTumbuhKembang> var;

    public ObjectExpandableTumbuhKembang(){}

    protected ObjectExpandableTumbuhKembang(Parcel in) {
        umur = in.readString();
        var = in.createTypedArrayList(ModelTumbuhKembang.CREATOR);
    }

    public static final Creator<ObjectExpandableTumbuhKembang> CREATOR = new Creator<ObjectExpandableTumbuhKembang>() {
        @Override
        public ObjectExpandableTumbuhKembang createFromParcel(Parcel in) {
            return new ObjectExpandableTumbuhKembang(in);
        }

        @Override
        public ObjectExpandableTumbuhKembang[] newArray(int size) {
            return new ObjectExpandableTumbuhKembang[size];
        }
    };

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public ArrayList<ModelTumbuhKembang> getVar() {
        return var;
    }

    public void setVar(ArrayList<ModelTumbuhKembang> var) {
        this.var = var;
    }

    public void add(ModelTumbuhKembang model){
        var.add(model);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(umur);
        parcel.writeTypedList(var);
    }
}
