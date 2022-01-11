package model;

import util.BaseDao;
import util.BaseModel;

import java.time.LocalDate;

public class Emanet extends BaseModel {

    private Kitap kitap;

    private Uye uye;

    private LocalDate emanetAlis;

    private LocalDate emanetTeslim;

    public Kitap getKitap() {
        return kitap;
    }

    public void setKitap(Kitap kitap) {
        this.kitap = kitap;
    }

    public Uye getUye() {
        return uye;
    }

    public void setUye(Uye uye) {
        this.uye = uye;
    }

    public LocalDate getEmanetAlis() {
        return emanetAlis;
    }

    public void setEmanetAlis(LocalDate emanetAlis) {
        this.emanetAlis = emanetAlis;
    }

    public LocalDate getEmanetTeslim() {
        return emanetTeslim;
    }

    public void setEmanetTeslim(LocalDate emanetTeslim) {
        this.emanetTeslim = emanetTeslim;
    }
}
