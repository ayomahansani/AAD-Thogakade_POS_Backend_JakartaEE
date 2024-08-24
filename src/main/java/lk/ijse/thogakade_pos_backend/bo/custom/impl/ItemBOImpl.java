package lk.ijse.thogakade_pos_backend.bo.custom.impl;

import lk.ijse.thogakade_pos_backend.bo.custom.ItemBO;
import lk.ijse.thogakade_pos_backend.dao.custom.ItemDAO;
import lk.ijse.thogakade_pos_backend.dao.custom.impl.ItemDAOImpl;
import lk.ijse.thogakade_pos_backend.dto.ItemDTO;
import lk.ijse.thogakade_pos_backend.entity.Item;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    private ItemDAO itemDAO = new ItemDAOImpl();

    @Override
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, NamingException {
        Item item = new Item(itemDTO.getCode(), itemDTO.getName(), itemDTO.getPrice(), itemDTO.getQty());
        return itemDAO.save(item);
    }

    @Override
    public boolean updateItem(String itemCode, ItemDTO itemDTO) throws SQLException, NamingException {
        Item item = new Item(itemDTO.getCode(), itemDTO.getName(), itemDTO.getPrice(), itemDTO.getQty());
        return itemDAO.update(itemCode, item);
    }

    @Override
    public boolean deleteItem(String itemCode) throws SQLException, NamingException {
        return itemDAO.delete(itemCode);
    }

    @Override
    public List<ItemDTO> getAllItems() throws SQLException, NamingException {

        List<Item> items = itemDAO.get();
        List<ItemDTO> itemDTOS = new ArrayList<>();

        for (Item item : items) {
            ItemDTO itemDTO = new ItemDTO(item.getCode(), item.getName(), item.getPrice(), item.getQty());
            itemDTOS.add(itemDTO);
        }

        return itemDTOS;
    }
}
