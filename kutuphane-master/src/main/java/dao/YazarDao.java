package dao;

import util.BaseDao;
import model.Yazar;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class YazarDao  implements BaseDao<Yazar,Long> {

    static Connection con = DatabaseConnection.getInstance();
    @Override
    public Yazar save(Yazar yazar) throws SQLException {

        String query= "insert into yazar (adi,soyadi,email) values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,yazar.getAdi());
        ps.setString(2,yazar.getSoyadi());
        ps.setString(3,yazar.getEmail());
        ps.execute();
        return yazar;
    }

    @Override
    public List<Yazar> getList() throws SQLException {

        String query = "select * from yazar";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Yazar> ls = new ArrayList();

        while (rs.next()) {
            Yazar yazar = new Yazar();
            yazar.setId(rs.getLong("id"));
            yazar.setAdi(rs.getString("adi"));
            yazar.setSoyadi(rs.getString("soyadi"));
            yazar.setEmail(rs.getString("email"));
            ls.add(yazar);
        }
        return ls;
    }

    @Override
    public void delete(Yazar yazar) throws SQLException {
        String query
                = "delete from yazar where id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setLong(1, yazar.getId());
        ps.executeUpdate();
    }
}
