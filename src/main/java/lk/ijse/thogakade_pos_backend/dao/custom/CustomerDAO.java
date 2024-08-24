package lk.ijse.thogakade_pos_backend.dao.custom;

import lk.ijse.thogakade_pos_backend.entity.Customer;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {

    boolean save(Customer customer, Connection connection) throws SQLException, NamingException;

    boolean update(String customerId, Customer customer, Connection connection) throws SQLException, NamingException;

    boolean delete(String customerId, Connection connection) throws SQLException, NamingException;

    List<Customer> get(Connection connection) throws SQLException;

}
