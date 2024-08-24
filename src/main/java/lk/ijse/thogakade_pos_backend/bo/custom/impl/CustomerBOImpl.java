package lk.ijse.thogakade_pos_backend.bo.custom.impl;

import lk.ijse.thogakade_pos_backend.bo.custom.CustomerBO;
import lk.ijse.thogakade_pos_backend.dao.custom.CustomerDAO;
import lk.ijse.thogakade_pos_backend.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.thogakade_pos_backend.dto.CustomerDTO;
import lk.ijse.thogakade_pos_backend.entity.Customer;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    private CustomerDAO customerDAO = new CustomerDAOImpl();


    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, NamingException {
        Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getPhone());
        return customerDAO.save(customer);
    }


    @Override
    public boolean updateCustomer(String customerId, CustomerDTO customerDTO) throws SQLException, NamingException {
        Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getPhone());
        return customerDAO.update(customerId, customer);
    }


    @Override
    public boolean deleteCustomer(String customerId) throws SQLException, NamingException {
        return customerDAO.delete(customerId);
    }


    @Override
    public List<CustomerDTO> getAllCustomers() throws SQLException, NamingException {

        List<Customer> customers = customerDAO.getAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getPhone());
            customerDTOS.add(customerDTO);
        }

        return customerDTOS;

    }
}
