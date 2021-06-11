package com.example.i_padi;

public class Profile {
    String email;
    String nama;
    String umur;
    String status;
    String telefon;

    public Profile() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Profile(String email, String nama, String umur, String status, String telefon) {
        this.email = email;
        this.nama = nama;
        this.umur = umur;
        this.status = status;
        this.telefon = telefon;
    }
}
