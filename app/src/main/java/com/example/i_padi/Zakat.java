package com.example.i_padi;

public class Zakat {
    String zakat;
    String pendapatan;

    public String getZakat() {
        return zakat;
    }

    public void setZakat(String zakat) {
        this.zakat = zakat;
    }

    public String getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(String pendapatan) {
        this.pendapatan = pendapatan;
    }

    public Zakat(String zakat, String pendapatan) {
        this.zakat = zakat;
        this.pendapatan = pendapatan;
    }
}
