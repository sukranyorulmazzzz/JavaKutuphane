package dao;

import model.Kategori;
import model.Yazar;
import util.BaseDao;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KategoriDao implements BaseDao<Kategori, Long> {

    static Connection con = DatabaseConnection.getInstance();


    @Override
    public Kategori save(Kategori kategori) throws SQLException {
        String query= "insert into kategori(adi) values (?) ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,kategori.getAdi());
        ps.execute();
        return kategori;
    }

    @Override
    public List<Kategori> getList() throws SQLException {
        String query = "select * from kategori";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Kategori> list = new ArrayList();

        while (rs.next()) {
            Kategori kategori = new Kategori();
            kategori.setId(rs.getLong("id"));
            kategori.setAdi(rs.getString("adi"));
            list.add(kategori);
        }
        return list;
    }

    @Override
    public void delete(Kategori kategori) throws SQLException {

        String query
                = "delete from kategori where id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setLong(1, kategori.getId());
        ps.executeUpdate();
    }
}
