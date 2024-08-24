package lk.ijse.thogakade_pos_backend.bo.custom;

import lk.ijse.thogakade_pos_backend.bo.SuperBO;
import lk.ijse.thogakade_pos_backend.dto.ItemDTO;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface ItemBO extends SuperBO {

    boolean saveItem(ItemDTO itemDTO) throws SQLException, NamingException;

    boolean updateItem(String itemCode, ItemDTO itemDTO) throws SQLException, NamingException;

    boolean deleteItem(String itemCode) throws SQLException, NamingException;

    List<ItemDTO> getAllItems() throws SQLException, NamingException;
}
