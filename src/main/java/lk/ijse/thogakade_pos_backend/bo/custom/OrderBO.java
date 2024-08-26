package lk.ijse.thogakade_pos_backend.bo.custom;

import lk.ijse.thogakade_pos_backend.bo.SuperBO;
import lk.ijse.thogakade_pos_backend.dto.OrderDetailsDTO;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface OrderBO extends SuperBO {
    boolean saveOrder(OrderDetailsDTO orderDetailsDTO) throws SQLException, NamingException;

    List<OrderDetailsDTO> getAllOrders() throws SQLException, NamingException;
}
