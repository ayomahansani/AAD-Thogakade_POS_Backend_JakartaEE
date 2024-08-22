package lk.ijse.thogakade_pos_backend.dao;

import lk.ijse.thogakade_pos_backend.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public final class CustomerDAOImpl implements CustomerDAO {

    static String SAVE_CUSTOMER = "INSERT INTO Customer (id,name,address,phone) VALUES (?,?,?,?)";
    static String UPDATE_CUSTOMER = "UPDATE Customer SET name=?,address=?,phone=? WHERE id=?";
    static String DELETE_CUSTOMER = "DELETE FROM Customer WHERE id=?";

    @Override
    public boolean save(Customer customer, Connection connection) throws SQLException {

        var ps = connection.prepareStatement(SAVE_CUSTOMER);

        ps.setString(1, customer.getId());
        ps.setString(2, customer.getName());
        ps.setString(3, customer.getAddress());
        ps.setString(4, customer.getPhone());

        return ps.executeUpdate() != 0;

    }

    @Override
    public boolean update(String customerId, Customer customer, Connection connection) throws SQLException {

        var ps = connection.prepareStatement(UPDATE_CUSTOMER);

        ps.setString(1, customer.getName());
        ps.setString(2, customer.getAddress());
        ps.setString(3, customer.getPhone());
        ps.setString(4, customerId);

        return ps.executeUpdate() != 0;

    }

    @Override
    public boolean delete(String customerId, Connection connection) throws SQLException {

        var ps = connection.prepareStatement(DELETE_CUSTOMER);

        ps.setString(1, customerId);

        return ps.executeUpdate() != 0;
    }
}
