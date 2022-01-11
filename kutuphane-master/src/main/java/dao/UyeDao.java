package dao;

import model.Uye;
import model.Uye;
import util.BaseDao;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UyeDao implements BaseDao<Uye,Long> {
    static Connection con = DatabaseConnection.getInstance();


    @Override
    public Uye save(Uye uye) throws SQLException {
        String query= "insert into uye(adi,soyadi,e_mail,adres) values (?,?,?,?) ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,uye.getAdi());
        ps.setString(2,uye.getSoyadi());
        ps.setString(3,uye.geteMail());
        ps.setString(4,uye.getAdres());
        ps.execute();
        return uye;

        
    }

    @Override
    public List<Uye> getList() throws SQLException {
        String query = "select * from uye";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Uye> list = new ArrayList();

        while (rs.next()) {
            Uye uye = new Uye();
            uye.setId(rs.getLong("id"));
            uye.setAdi(rs.getString("adi"));
            uye.setSoyadi(rs.getString("soyadi"));
            uye.setAdres(rs.getString("adres"));
            uye.seteMail(rs.getString("e_mail"));
            list.add(uye);
        }
        return list;
    }

    @Override
    public void delete(Uye uye) {

    }

    public List<Uye> searchUye(Long id) throws SQLException {
        String query = "select * from uye where id = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        List<Uye> list = new ArrayList();

        while (rs.next()) {
            Uye uye = new Uye();
            uye.setId(rs.getLong("id"));
            uye.setAdi(rs.getString("adi"));
            uye.setSoyadi(rs.getString("soyadi"));
            uye.setAdres(rs.getString("adres"));
            uye.seteMail(rs.getString("e_mail"));
            list.add(uye);
        }
        return list;

    }
}
