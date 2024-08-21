package lk.ijse.thogakade_pos_backend.bo;

import lk.ijse.thogakade_pos_backend.dao.CustomerDAO;
import lk.ijse.thogakade_pos_backend.dao.CustomerDAOImpl;
import lk.ijse.thogakade_pos_backend.dto.CustomerDTO;
import lk.ijse.thogakade_pos_backend.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO{

    private CustomerDAO customerDAO = new CustomerDAOImpl();


    @Override
    public boolean saveCustomer(CustomerDTO customerDTO, Connection connection) throws SQLException {
        Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getContact());
        return customerDAO.save(customer, connection);
    }
}
