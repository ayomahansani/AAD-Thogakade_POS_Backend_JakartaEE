package lk.ijse.thogakade_pos_backend.bo;

import lk.ijse.thogakade_pos_backend.dao.CustomerDAO;
import lk.ijse.thogakade_pos_backend.dao.CustomerDAOImpl;
import lk.ijse.thogakade_pos_backend.dto.CustomerDTO;
import lk.ijse.thogakade_pos_backend.entity.Customer;

import java.sql.Connection;

public class CustomerBOImpl implements CustomerBO{

    private CustomerDAO customerDAO = new CustomerDAOImpl();


    @Override
    public boolean saveCustomer(CustomerDTO customerDTO, Connection connection) {
        Customer customer = new Customer();
        customerDAO.save(customer, connection);

    }
}
