package dao;

import model.Kitap;
import util.BaseDao;
import model.Kitap;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class KitapDao implements BaseDao<Kitap,Long> {

    static Connection con = DatabaseConnection.getInstance();
    @Override
    public Kitap save(Kitap kitap) throws SQLException {
        String query= "insert into kitap (barkod,kitap_adi,basim_yili,sayfa_sayisi,kategori_id,yazar_id,basim_evi_id,raf_id) " +
                "values (?,?,?,?,?,?,?,?)" ;
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,kitap.getBarkod());
        ps.setString(2,kitap.getKitapAdi());
        ps.setInt(3,kitap.getBasimYili());
        ps.setInt(4,kitap.getSayfaSayisi());
        ps.setLong(5, kitap.getKategori().getId());
        ps.setLong(6,kitap.getYazar().getId());
        ps.setLong(7,kitap.getBasimEvi().getId());
        ps.setLong(8,kitap.getRaf().getId());
        ps.execute();
                return kitap;
    }

    @Override
    public List<Kitap> getList() throws SQLException {
        String query = "select * from kitap";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Kitap> list = new ArrayList();

        while (rs.next()) {
            Kitap kitap = new Kitap();
            kitap.setId(rs.getLong("id"));
            kitap.setKitapAdi(rs.getString("kitap_adi"));
            list.add(kitap);
        }
        return list;
    }

    @Override
    public void delete(Kitap kitap) {

    }
    
    public List<Kitap> searchKitap(String adi) throws SQLException {
        String query = "select * from kitap where kitap_adi like ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1,"%"+adi+"%");
        ResultSet rs = ps.executeQuery();
        List<Kitap> list = new ArrayList();

        while (rs.next()) {
            Kitap kitap = new Kitap();
            kitap.setId(rs.getLong("id"));
            kitap.setKitapAdi(rs.getString("kitap_adi"));
            list.add(kitap);
        }
        return list;
        
        
    }
}
