package lk.ijse.thogakade_pos_backend.dao;

import lk.ijse.thogakade_pos_backend.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public final class CustomerDAOImpl implements CustomerDAO {

    static String SAVE_CUSTOMER = "INSERT INTO Customer (id,name,address,contact) VALUES (?,?,?,?)";

    @Override
    public boolean save(Customer customer, Connection connection) throws SQLException {

        var ps = connection.prepareStatement(SAVE_CUSTOMER);
        ps.setString(1, customer.getId());
        ps.setString(2, customer.getName());
        ps.setString(3, customer.getAddress());
        ps.setString(4, customer.getContact());

        return ps.executeUpdate() != 0;

    }
}
