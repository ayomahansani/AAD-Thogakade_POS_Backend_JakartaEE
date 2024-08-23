package lk.ijse.thogakade_pos_backend.bo;

import lk.ijse.thogakade_pos_backend.dao.ItemDAO;
import lk.ijse.thogakade_pos_backend.dao.ItemDAOImpl;
import lk.ijse.thogakade_pos_backend.dto.ItemDTO;
import lk.ijse.thogakade_pos_backend.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO{

    private ItemDAO itemDAO = new ItemDAOImpl();

    @Override
    public boolean saveItem(ItemDTO itemDTO, Connection connection) throws SQLException {
        Item item = new Item(itemDTO.getCode(), itemDTO.getName(), itemDTO.getPrice(), itemDTO.getQty());
        return itemDAO.save(item, connection);
    }

    @Override
    public boolean updateItem(String itemCode, ItemDTO itemDTO, Connection connection) throws SQLException {
        Item item = new Item(itemDTO.getCode(), itemDTO.getName(), itemDTO.getPrice(), itemDTO.getQty());
        return itemDAO.update(itemCode, item, connection);
    }

    @Override
    public boolean deleteItem(String itemCode, Connection connection) throws SQLException {
        return itemDAO.delete(itemCode, connection);
    }

    @Override
    public List<ItemDTO> getAllItems(Connection connection) throws SQLException {

        List<Item> items = itemDAO.get(connection);
        List<ItemDTO> itemDTOS = new ArrayList<>();

        for (Item item : items) {
            ItemDTO itemDTO = new ItemDTO(item.getCode(), item.getName(), item.getPrice(), item.getQty());
            itemDTOS.add(itemDTO);
        }

        return itemDTOS;
    }
}
