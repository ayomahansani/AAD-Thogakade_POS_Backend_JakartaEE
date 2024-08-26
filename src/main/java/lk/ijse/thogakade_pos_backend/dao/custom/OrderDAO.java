package lk.ijse.thogakade_pos_backend.dao.custom;

import lk.ijse.thogakade_pos_backend.entity.OrderDetails;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    boolean save(OrderDetails orderDetails) throws SQLException, NamingException;

    List<OrderDetails> getAll() throws SQLException, NamingException;

}
