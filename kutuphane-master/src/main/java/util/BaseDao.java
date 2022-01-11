package util;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T,R> {  // Java_ Generics

    T save(T t) throws SQLException;

    List<T> getList() throws SQLException;

    void delete(T t) throws SQLException;

}
