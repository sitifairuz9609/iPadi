package com.example.i_padi;

public class Perbelanjaan {
    String perbelanjaan;
    String jenisaktiviti;
    String aktiviti;
    String item;
    String ukuran;
    String harga;
    String kuantiti;

    public String getPerbelanjaan() {
        return perbelanjaan;
    }

    public void setPerbelanjaan(String perbelanjaan) {
        this.perbelanjaan = perbelanjaan;
    }

    public String getJenisaktiviti() {
        return jenisaktiviti;
    }

    public void setJenisaktiviti(String jenisaktiviti) {
        this.jenisaktiviti = jenisaktiviti;
    }

    public String getAktiviti() {
        return aktiviti;
    }

    public void setAktiviti(String aktiviti) {
        this.aktiviti = aktiviti;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKuantiti() {
        return kuantiti;
    }

    public void setKuantiti(String kuantiti) {
        this.kuantiti = kuantiti;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    public Perbelanjaan(String perbelanjaan, String jenisaktiviti, String aktiviti, String item, String ukuran, String harga, String kuantiti, String id) {
        this.perbelanjaan = perbelanjaan;
        this.jenisaktiviti = jenisaktiviti;
        this.aktiviti = aktiviti;
        this.item = item;
        this.ukuran = ukuran;
        this.harga = harga;
        this.kuantiti = kuantiti;
        this.id = id;
    }

    public Perbelanjaan(){}
}
