package enums;

public enum  UyeTipi {
    OGRENCI("OGRENCI"),KAMU("KAMU"),VATANDAS("VATANDAS");

    private final String value;

    UyeTipi(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }


}
