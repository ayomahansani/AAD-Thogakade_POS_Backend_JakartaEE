package lk.ijse.thogakade_pos_backend.bo;

import lk.ijse.thogakade_pos_backend.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerBO {

    boolean saveCustomer(CustomerDTO customerDTO, Connection connection) throws SQLException;

    boolean updateCustomer(String customerId, CustomerDTO customerDTO, Connection connection) throws SQLException;

    boolean deleteCustomer(String customerId, Connection connection) throws SQLException;

    List<CustomerDTO> getAllCustomers(Connection connection) throws SQLException;

}
