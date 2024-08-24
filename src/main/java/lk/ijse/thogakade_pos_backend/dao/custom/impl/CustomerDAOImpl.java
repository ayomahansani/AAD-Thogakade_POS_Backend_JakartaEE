package lk.ijse.thogakade_pos_backend.dao.custom.impl;

import lk.ijse.thogakade_pos_backend.dao.SQLUtil;
import lk.ijse.thogakade_pos_backend.dao.custom.CustomerDAO;
import lk.ijse.thogakade_pos_backend.entity.Customer;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class CustomerDAOImpl implements CustomerDAO {

    static String SAVE_CUSTOMER = "INSERT INTO Customer (id,name,address,phone) VALUES (?,?,?,?)";
    static String UPDATE_CUSTOMER = "UPDATE Customer SET name=?,address=?,phone=? WHERE id=?";
    static String DELETE_CUSTOMER = "DELETE FROM Customer WHERE id=?";
    static String GET_CUSTOMER = "SELECT * FROM Customer";

    @Override
    public boolean save(Customer customer, Connection connection) throws SQLException, NamingException {

        /*var ps = connection.prepareStatement(SAVE_CUSTOMER);

        ps.setString(1, customer.getId());
        ps.setString(2, customer.getName());
        ps.setString(3, customer.getAddress());
        ps.setString(4, customer.getPhone());

        return ps.executeUpdate() != 0;*/

        return SQLUtil.execute(SAVE_CUSTOMER, customer.getId(),customer.getName(), customer.getAddress(), customer.getPhone());

    }

    @Override
    public boolean update(String customerId, Customer customer, Connection connection) throws SQLException, NamingException {

        /*var ps = connection.prepareStatement(UPDATE_CUSTOMER);

        ps.setString(1, customer.getName());
        ps.setString(2, customer.getAddress());
        ps.setString(3, customer.getPhone());
        ps.setString(4, customerId);

        return ps.executeUpdate() != 0;*/

        return SQLUtil.execute(UPDATE_CUSTOMER, customer.getName(), customer.getAddress(), customer.getPhone(), customerId);

    }

    @Override
    public boolean delete(String customerId, Connection connection) throws SQLException, NamingException {

        /*var ps = connection.prepareStatement(DELETE_CUSTOMER);

        ps.setString(1, customerId);

        return ps.executeUpdate() != 0;*/

        return SQLUtil.execute(DELETE_CUSTOMER, customerId);
    }

    @Override
    public List<Customer> get(Connection connection) throws SQLException {

        List<Customer> customers = new ArrayList<>();

        var ps = connection.prepareStatement(GET_CUSTOMER);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Customer customer = new Customer();

            customer.setId(rs.getString("id"));
            customer.setName(rs.getString("name"));
            customer.setAddress(rs.getString("address"));
            customer.setPhone(rs.getString("phone"));

            customers.add(customer);
        }

        return customers;
    }
}
