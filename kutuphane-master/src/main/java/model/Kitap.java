package model;

import util.BaseModel;

import java.sql.Date;

public class Kitap extends BaseModel {

    private String barkod;

    private String kitapAdi;

    private int basimYili;

    private Integer sayfaSayisi;

    private Kategori kategori;

    private Yazar yazar;

    private BasimEvi basimEvi;

    private Raf raf;

    public int getBasimYili() {
        return basimYili;
    }

    public String getBarkod() {
        return barkod;
    }

    public void setBarkod(String barkod) {
        this.barkod = barkod;
    }

    public Raf getRaf() {
        return raf;
    }

    public void setRaf(Raf raf) {
        this.raf = raf;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public void setBasimYili(int basimYili) {
        this.basimYili = basimYili;
    }

    public Integer getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(Integer sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public Yazar getYazar() {
        return yazar;
    }

    public void setYazar(Yazar yazar) {
        this.yazar = yazar;
    }

    public BasimEvi getBasimEvi() {
        return basimEvi;
    }

    public void setBasimEvi(BasimEvi basimEvi) {
        this.basimEvi = basimEvi;
    }
}
