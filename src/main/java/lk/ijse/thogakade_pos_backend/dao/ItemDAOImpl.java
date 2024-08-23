package lk.ijse.thogakade_pos_backend.dao;

import lk.ijse.thogakade_pos_backend.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public final class ItemDAOImpl implements ItemDAO {

    static String SAVE_CUSTOMER = "INSERT INTO Customer (id,name,address,phone) VALUES (?,?,?,?)";
    static String UPDATE_CUSTOMER = "UPDATE Customer SET name=?,address=?,phone=? WHERE id=?";
    static String DELETE_CUSTOMER = "DELETE FROM Customer WHERE id=?";
    static String GET_CUSTOMER = "SELECT * FROM Customer";

    @Override
    public boolean save(Item item, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean update(String itemCode, Item item, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String itemCode, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public List<Item> get(Connection connection) throws SQLException {
        return List.of();
    }
}
