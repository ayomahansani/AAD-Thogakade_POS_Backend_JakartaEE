package lk.ijse.thogakade_pos_backend.bo.custom;

import lk.ijse.thogakade_pos_backend.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ItemBO {

    boolean saveItem(ItemDTO itemDTO, Connection connection) throws SQLException;

    boolean updateItem(String itemCode, ItemDTO itemDTO, Connection connection) throws SQLException;

    boolean deleteItem(String itemCode, Connection connection) throws SQLException;

    List<ItemDTO> getAllItems(Connection connection) throws SQLException;
}
