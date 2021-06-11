package com.example.i_padi;

public class Penjimatan {
    String pendapatan;
    String pendapatanbuatsendiri;

    public String getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(String pendapatan) {
        this.pendapatan = pendapatan;
    }

    public String getPendapatanbuatsendiri() {
        return pendapatanbuatsendiri;
    }

    public void setPendapatanbuatsendiri(String pendapatanbuatsendiri) {
        this.pendapatanbuatsendiri = pendapatanbuatsendiri;
    }

    public Penjimatan(String pendapatan, String pendapatanbuatsendiri) {
        this.pendapatan = pendapatan;
        this.pendapatanbuatsendiri = pendapatanbuatsendiri;
    }
}
