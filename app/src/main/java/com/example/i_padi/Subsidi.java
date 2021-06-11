package com.example.i_padi;

public class Subsidi {
    String pendapatan;
    String subsidi;

    public String getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(String pendapatan) {
        this.pendapatan = pendapatan;
    }

    public String getSubsidi() {
        return subsidi;
    }

    public void setSubsidi(String subsidi) {
        this.subsidi = subsidi;
    }

    public Subsidi(String pendapatan, String subsidi) {
        this.pendapatan = pendapatan;
        this.subsidi = subsidi;
    }
}
