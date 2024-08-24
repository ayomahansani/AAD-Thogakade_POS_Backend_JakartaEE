package lk.ijse.thogakade_pos_backend.bo.custom.impl;

import lk.ijse.thogakade_pos_backend.bo.custom.CustomerBO;
import lk.ijse.thogakade_pos_backend.dao.custom.CustomerDAO;
import lk.ijse.thogakade_pos_backend.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.thogakade_pos_backend.dto.CustomerDTO;
import lk.ijse.thogakade_pos_backend.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    private CustomerDAO customerDAO = new CustomerDAOImpl();


    @Override
    public boolean saveCustomer(CustomerDTO customerDTO, Connection connection) throws SQLException {
        Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getPhone());
        return customerDAO.save(customer, connection);
    }


    @Override
    public boolean updateCustomer(String customerId, CustomerDTO customerDTO, Connection connection) throws SQLException {
        Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getPhone());
        return customerDAO.update(customerId, customer, connection);
    }


    @Override
    public boolean deleteCustomer(String customerId, Connection connection) throws SQLException {
        return customerDAO.delete(customerId, connection);
    }


    @Override
    public List<CustomerDTO> getAllCustomers(Connection connection) throws SQLException {

        List<Customer> customers = customerDAO.get(connection);
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getPhone());
            customerDTOS.add(customerDTO);
        }

        return customerDTOS;

    }
}
