package lk.ijse.thogakade_pos_backend.dao.custom;

import lk.ijse.thogakade_pos_backend.entity.Item;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {

    boolean save(Item item) throws SQLException, NamingException;

    boolean update(String itemCode, Item item) throws SQLException, NamingException;

    boolean delete(String itemCode) throws SQLException, NamingException;

    List<Item> get() throws SQLException, NamingException;
}
