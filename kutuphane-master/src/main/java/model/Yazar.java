package model;

import util.BaseModel;

public class Yazar extends BaseModel {


    private String adi;

    private String soyadi;

    private String email;


    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdSoyad()
    {
        return this.adi+" "+this.soyadi;
    }
}
