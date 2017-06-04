package com.example.laili.pasporbayi;

/**
 * Created by Laili on 03/06/2017.
 */

public class ModelTumbuhKembang {
    int index, umur;
    String gerak, perkembangan;

    public ModelTumbuhKembang(int index, int umur, String gerak, String perkembangan) {

        this.index = index;
        this.umur = umur;
        this.gerak = gerak;
        this.perkembangan = perkembangan;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
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


}
