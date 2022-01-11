package dao;

import model.BasimEvi;
import model.BasimEvi;
import util.BaseDao;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasimEviDao implements BaseDao<BasimEvi,Long> {
    static Connection con = DatabaseConnection.getInstance();

    @Override
    public BasimEvi save(BasimEvi basimEvi) throws SQLException {
        String query = "insert into basim_evi (adi,adres,tel_no) values (?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,basimEvi.getAdi());
        ps.setString(2,basimEvi.getAdresi());
        ps.setString(3,basimEvi.getTelNo());
        ps.execute();
        return basimEvi;
    }

    @Override
    public List<BasimEvi> getList() throws SQLException {
        String query = "select * from basim_evi";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<BasimEvi> list = new ArrayList();

        while (rs.next()) {
            BasimEvi basimEvi = new BasimEvi();
            basimEvi.setId(rs.getLong("id"));
            basimEvi.setAdi(rs.getString("adi"));
            basimEvi.setAdresi(rs.getString("adresi"));
            basimEvi.setTelNo(rs.getString("tel_no"));
            list.add(basimEvi);
        }
        return list;
    }

    @Override
    public void delete(BasimEvi basimEvi) throws SQLException {

        String query
                = "delete from basim_evi where id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setLong(1, basimEvi.getId());
        ps.executeUpdate();
    }
}
