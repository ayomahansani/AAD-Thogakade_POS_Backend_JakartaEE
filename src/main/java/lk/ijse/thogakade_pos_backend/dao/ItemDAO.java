package lk.ijse.thogakade_pos_backend.dao;

import lk.ijse.thogakade_pos_backend.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {

    boolean save(Item item, Connection connection) throws SQLException;

    boolean update(String itemCode, Item item, Connection connection) throws SQLException;

    boolean delete(String itemCode, Connection connection) throws SQLException;

    List<Item> get(Connection connection) throws SQLException;
}
