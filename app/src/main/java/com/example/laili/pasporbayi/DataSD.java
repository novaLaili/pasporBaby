package com.example.laili.pasporbayi;

/**
 * Created by Laili on 27/05/2017.
 */

public class DataSD {
    private String jenis_kelamin;
    private int tahun, bulan, SD;
    private double beratAtas, beratBawah, tinggiAtas, tinggiBawah, LKAtas, LKBawah;

    public DataSD(){

    }

    public DataSD(String jenis_kelamin, int tahun, int bulan, int SD, double beratAtas, double beratBawah, double tinggiAtas, double tinggiBawah, double LKAtas, double LKBawah) {
        this.jenis_kelamin = jenis_kelamin;
        this.tahun = tahun;
        this.bulan = bulan;
        this.SD = SD;
        this.beratAtas = beratAtas;
        this.beratBawah = beratBawah;
        this.tinggiAtas = tinggiAtas;
        this.tinggiBawah = tinggiBawah;
        this.LKAtas = LKAtas;
        this.LKBawah = LKBawah;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public int getBulan() {
        return bulan;
    }

    public void setBulan(int bulan) {
        this.bulan = bulan;
    }

    public int getSD() {
        return SD;
    }

    public void setSD(int SD) {
        this.SD = SD;
    }

    public double getBeratAtas() {
        return beratAtas;
    }

    public void setBeratAtas(double beratAtas) {
        this.beratAtas = beratAtas;
    }

    public double getBeratBawah() {
        return beratBawah;
    }

    public void setBeratBawah(double beratBawah) {
        this.beratBawah = beratBawah;
    }

    public double getTinggiAtas() {
        return tinggiAtas;
    }

    public void setTinggiAtas(double tinggiAtas) {
        this.tinggiAtas = tinggiAtas;
    }

    public double getTinggiBawah() {
        return tinggiBawah;
    }

    public void setTinggiBawah(double tinggiBawah) {
        this.tinggiBawah = tinggiBawah;
    }

    public double getLKAtas() {
        return LKAtas;
    }

    public void setLKAtas(double LKAtas) {
        this.LKAtas = LKAtas;
    }

    public double getLKBawah() {
        return LKBawah;
    }

    public void setLKBawah(double LKBawah) {
        this.LKBawah = LKBawah;
    }
}
