package lk.ijse.thogakade_pos_backend.dao;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> {

    boolean save(T entity) throws SQLException, NamingException;

    boolean update(String id, T entity) throws SQLException, NamingException;

    boolean delete(String id) throws SQLException, NamingException;

    List<T> getAll() throws SQLException, NamingException;
}
