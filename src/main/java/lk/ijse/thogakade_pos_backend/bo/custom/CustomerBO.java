package lk.ijse.thogakade_pos_backend.bo.custom;

import lk.ijse.thogakade_pos_backend.dto.CustomerDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerBO {

    boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, NamingException;

    boolean updateCustomer(String customerId, CustomerDTO customerDTO) throws SQLException, NamingException;

    boolean deleteCustomer(String customerId) throws SQLException, NamingException;

    List<CustomerDTO> getAllCustomers() throws SQLException, NamingException;

}
