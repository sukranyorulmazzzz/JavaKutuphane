package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection { //singleton Sınıf Dizayn Pather

    private static Connection con;

    static {
        String url = "jdbc:postgresql://localhost:5433/Kutuphane";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","2121054");
        try {
            con =  DriverManager.getConnection(url, props);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getInstance(){

        return con;
    }

}