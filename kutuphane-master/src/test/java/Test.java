import dao.*;
import model.*;
import org.checkerframework.checker.units.qual.K;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
        System.out.println("1- Kitap Ekle\n2- Kitap Ver\n3- Kitap Al\n ");
        Scanner input = new Scanner(System.in);
        String islem = input.nextLine();
        if (null != islem) switch (islem) {
            case "1":
                kitapKaydet();
                break;
            case "2":
                kitapVer();
                break;
            case "3":
                kitapAl();
                break;
            default:
                break;
        }

    }

    public static void kitapKaydet() {
        Scanner input = new Scanner(System.in);
        Kitap kitap = new Kitap();
        try {
            BasimEviDao basimEviDao = new BasimEviDao();
            YazarDao yazarDao = new YazarDao();
            KategoriDao kategoriDao = new KategoriDao();
            List<BasimEvi> basimEviListe;
            basimEviListe = basimEviDao.getList();
            List<Yazar> yazarListe = yazarDao.getList();
            List<Kategori> kategoriListe = kategoriDao.getList();
            System.out.print("Kitap Adi=");
            kitap.setKitapAdi(input.nextLine());

            System.out.print("Kitap Barkod No=");
            kitap.setBarkod(input.nextLine());

            System.out.print("Sayfa Sayısı=");
            kitap.setSayfaSayisi(Integer.valueOf(input.nextLine()));
            String yazarList = "";
            for (int i = 0; i < yazarListe.size(); i++) {
                yazarList = yazarList + (i + 1) + "- " + yazarListe.get(i).getAdi() + yazarListe.get(i).getSoyadi() + "\n";
            }
            System.out.print(yazarList);
            System.out.print("Yazar Seç=");
            kitap.setYazar(yazarListe.get(Integer.parseInt(input.nextLine()) - 1));

            System.out.print("Basım Yili =");
            kitap.setBasimYili(Integer.parseInt(input.nextLine()));

            String kategoriList = "";
            for (int i = 0; i < kategoriListe.size(); i++) {
                kategoriList = kategoriList + "\n" + (i + 1) + "- " + kategoriListe.get(i).getAdi();
            }
            System.out.println(kategoriList);
            System.out.print("Kategori Seç=");
            kitap.setKategori(kategoriListe.get(Integer.parseInt(input.nextLine()) - 1));

            String basimEviList = "";
            for (int i = 0; i < basimEviListe.size(); i++) {
                basimEviList = basimEviList + "\n" + (i + 1) + "- " + basimEviListe.get(i).getAdi();
            }
            System.out.println(basimEviList);
            System.out.print("Basimevi Seç=");
            kitap.setBasimEvi(basimEviListe.get(Integer.parseInt(input.nextLine()) - 1));
            KitapDao kitapDao = new KitapDao();


            String rafListe = "";
            RafDao rafDao = new RafDao();
            List<Raf> rafList = rafDao.getList();
            for (int i = 0; i < rafList.size(); i++) {
                rafListe = rafListe + "\n" + (i + 1) + "- " + rafList.get(i).getRafCode();
            }
            System.out.println(rafListe);
            System.out.print("Raf Seç=");
            kitap.setRaf(rafList.get(Integer.parseInt(input.nextLine()) - 1));
            kitapDao.save(kitap);
            System.out.println("Kitap Başarıyla Kaydedildi." + kitap.getKitapAdi());
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void kitapVer() {
        KitapDao kitapDao = new KitapDao();
        UyeDao uyeDao = new UyeDao();
        EmanetDao emanetDao = new EmanetDao();
        Scanner input = new Scanner(System.in);
        Emanet emanet = new Emanet();
        System.out.println("Kitap adi Giriniz..");
        String araKitap = input.nextLine();
        try {
            List<Kitap> kitapListe = kitapDao.searchKitap(araKitap);
            String kitapList = "";
            for (int i = 0; i < kitapListe.size(); i++) {
                kitapList = kitapList + "\n" + (i + 1) + "- " + kitapListe.get(i).getKitapAdi();
            }
            System.out.println(kitapList);
            System.out.println("Kitap Seçiniz..");
            emanet.setKitap(kitapListe.get(Integer.parseInt(input.nextLine()) - 1));
            System.out.println("Üye No (id) Giriniz ..");
            String araUye = input.nextLine();
            try {
                List<Uye> uyeListe = uyeDao.searchUye(Long.valueOf(araUye));
                String uyeList = "";
                for (int i = 0; i < uyeListe.size(); i++) {
                    uyeList = uyeList + "\n" + (i + 1) + "- " + uyeListe.get(i).getAdi() + uyeListe.get(i).getSoyadi();
                }
                System.out.println(uyeList + "--> Üye Seçiniz");
                emanet.setUye(uyeListe.get(Integer.parseInt(input.nextLine()) - 1));
                emanetDao.save(emanet);
                System.out.println("Emanete Kitap Verildi... ");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public static void kitapAl() throws SQLException {
        UyeDao uyeDao = new UyeDao();
        EmanetDao emanetDao = new EmanetDao();
        Scanner input = new Scanner(System.in);
        Emanet emanet = new Emanet();
        System.out.println("Üye No-ID Giriniz..");
        String araUye = input.nextLine();
        List<Kitap> uyeKitapListe = emanetDao.getUyeKitap(Long.valueOf(araUye));

        String uyeKitapList = "";
        for (int i = 0; i < uyeKitapListe.size(); i++) {
            uyeKitapList = uyeKitapList + "\n" + (i + 1) + "- " + uyeKitapListe.get(i).getKitapAdi();

        }
        System.out.println(uyeKitapList + "--> Üyede Emanette olan kitaplar Teslim Alıncak Kitap Seç");
        String silEmanet = input.nextLine();
        emanetDao.kitapEmanetSil(Long.valueOf(silEmanet));
        System.out.println("Kitap Başarıyla Geri Alındı..");


    }
}
