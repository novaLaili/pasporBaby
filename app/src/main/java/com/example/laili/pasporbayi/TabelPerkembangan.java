package com.example.laili.pasporbayi;

/**
 * Created by Laili on 17/05/2017.
 */

public class TabelPerkembangan {
    private int umur;
    private String gerak;
    private String perkembangan;

    public TabelPerkembangan(int umur, String gerak, String perkembangan){
        this.umur = umur;
        this.gerak = gerak;
        this.perkembangan = perkembangan;
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
