package dao;

import model.Raf;
import model.Raf;
import util.BaseDao;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RafDao implements BaseDao<Raf, Long> {
    static Connection con = DatabaseConnection.getInstance();

    @Override
    public Raf save(Raf raf) throws SQLException {
        String query = "insert into raf (rafCode) values (?) ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, raf.getRafCode());
        ps.execute();
        return raf;
    }

    @Override
    public List<Raf> getList() throws SQLException {
        String query = "select * from raf";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Raf> list = new ArrayList();

        while (rs.next()) {
            Raf raf = new Raf();
            raf.setId(rs.getLong("id"));
            raf.setRafCode(rs.getString("raf_code"));
            list.add(raf);
        }
        return list;
    }

    @Override
    public void delete(Raf raf) throws SQLException {

        String query
                = "delete from raf where id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setLong(1, raf.getId());
        ps.executeUpdate();
    }
}
