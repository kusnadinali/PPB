package com.example.ligasepakbola;

public class Klub {
    String nama;
    int poin;
    int totalMain;
    int menang;
    int seri;
    int kalah;
    int golMasuk;
    int golKemasukan;
    int selisihGol;

    public int getTotalMain() {
        return totalMain;
    }

    public void setTotalMain(int totalMain) {
        this.totalMain = totalMain;
    }

    public int getSelisihGol() {
        return selisihGol;
    }

    public void setSelisihGol(int selisihGol) {
        this.selisihGol = selisihGol;
    }

    public Klub(String nama, int poin, int totalMain, int menang, int seri, int kalah, int golMasuk, int golKemasukan, int selisihGol) {
        this.nama = nama;
        this.poin = poin;
        this.menang = menang;
        this.seri = seri;
        this.kalah = kalah;
        this.golMasuk = golMasuk;
        this.golKemasukan = golKemasukan;
    }

    public String getNama() {
        return nama;
    }

    public int getPoin() {
        return poin;
    }

    public int getMenang() {
        return menang;
    }

    public int getSeri() {
        return seri;
    }

    public int getKalah() {
        return kalah;
    }

    public int getGolMasuk() {
        return golMasuk;
    }

    public int getGolKemasukan() {
        return golKemasukan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    public void setMenang(int menang) {
        this.menang = menang;
    }

    public void setSeri(int seri) {
        this.seri = seri;
    }

    public void setKalah(int kalah) {
        this.kalah = kalah;
    }

    public void setGolMasuk(int golMasuk) {
        this.golMasuk = golMasuk;
    }

    public void setGolKemasukan(int golKemasukan) {
        this.golKemasukan = golKemasukan;
    }
}
