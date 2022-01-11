package dao;

import model.Emanet;
import model.Emanet;
import model.Kitap;
import util.BaseDao;
import util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class EmanetDao implements BaseDao<Emanet ,Long> {

    static Connection con= DatabaseConnection.getInstance();
    @Override
    public Emanet save(Emanet emanet) throws SQLException {
        LocalDate lt
                = LocalDate.now();
        String query = "insert into emanet (kitap_id,uye_id,emanet_alis) values (?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1,emanet.getKitap().getId());
        ps.setLong(2,emanet.getUye().getId());
        ps.setDate(3, Date.valueOf(lt));
        ps.execute();
        return emanet;
    }
    @Override
    public List<Emanet> getList() throws SQLException {

        String query = "select * from emanet";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Emanet> ls = new ArrayList();

        while (rs.next()) {
            Emanet emanet = new Emanet();
            emanet.setId(rs.getLong("id"));
            ls.add(emanet);
        }
        return ls;
    }

    @Override
    public void delete(Emanet emanet) throws SQLException {
        String query
                = "delete from emanet where id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setLong(1, emanet.getId());
        ps.executeUpdate();
    }


    public void kitapEmanetSil(Long id) throws SQLException {
        String query
                = "delete from emanet where kitap_id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setLong(1, id);
        ps.executeUpdate();
    }




    public List<Kitap>  getUyeKitap(Long id) throws SQLException {
        String query = "select k.* from emanet e,uye u,kitap k where e.uye_id=u.id  and e.kitap_id=k.id and e.uye_id=?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        List<Kitap> ls = new ArrayList();

        while (rs.next()) {
            Kitap kitap = new Kitap();
            kitap.setId(rs.getLong("id"));
            kitap.setKitapAdi(rs.getString("kitap_adi"));
            ls.add(kitap);
        }
        return ls;


    }


}

