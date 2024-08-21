package lk.ijse.thogakade_pos_backend.bo;

import lk.ijse.thogakade_pos_backend.dto.CustomerDTO;

import java.sql.Connection;

public interface CustomerBO {

    boolean saveCustomer(CustomerDTO customerDTO, Connection connection);

}
