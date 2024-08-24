package lk.ijse.thogakade_pos_backend.dao.custom.impl;

import lk.ijse.thogakade_pos_backend.dao.SQLUtil;
import lk.ijse.thogakade_pos_backend.dao.custom.ItemDAO;
import lk.ijse.thogakade_pos_backend.entity.Item;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ItemDAOImpl implements ItemDAO {

    static String SAVE_ITEM = "INSERT INTO Item (code,name,price,qty) VALUES (?,?,?,?)";
    static String UPDATE_ITEM = "UPDATE Item SET name=?,price=?,qty=? WHERE code=?";
    static String DELETE_ITEM = "DELETE FROM Item WHERE code=?";
    static String GET_ITEM = "SELECT * FROM Item";

    @Override
    public boolean save(Item item, Connection connection) throws SQLException, NamingException {

        /*var ps = connection.prepareStatement(SAVE_ITEM);

        ps.setString(1, item.getCode());
        ps.setString(2, item.getName());
        ps.setString(3, String.valueOf(item.getPrice()));
        ps.setString(4, String.valueOf(item.getQty()));

        return ps.executeUpdate() != 0;*/

        return SQLUtil.execute(SAVE_ITEM, item.getCode(), item.getName(), item.getPrice(), item.getQty());
    }

    @Override
    public boolean update(String itemCode, Item item, Connection connection) throws SQLException, NamingException {

        /*var ps = connection.prepareStatement(UPDATE_ITEM);

        ps.setString(1, item.getName());
        ps.setString(2, String.valueOf(item.getPrice()));
        ps.setString(3, String.valueOf(item.getQty()));
        ps.setString(4, itemCode);

        return ps.executeUpdate() != 0;*/

        return SQLUtil.execute(UPDATE_ITEM, item.getName(), item.getPrice(), item.getQty(), itemCode);
    }

    @Override
    public boolean delete(String itemCode, Connection connection) throws SQLException, NamingException {

        /*var ps = connection.prepareStatement(DELETE_ITEM);

        ps.setString(1, itemCode);

        return ps.executeUpdate() != 0;*/

        return SQLUtil.execute(DELETE_ITEM, itemCode);
    }

    @Override
    public List<Item> get(Connection connection) throws SQLException, NamingException {

        /*List<Item> items = new ArrayList<>();

        var ps = connection.prepareStatement(GET_ITEM);*/

        ResultSet rs = SQLUtil.execute(GET_ITEM);

        List<Item> items = new ArrayList<>();

        while (rs.next()) {

            Item item = new Item();

            item.setCode(rs.getString("code"));
            item.setName(rs.getString("name"));
            item.setPrice(Double.parseDouble(rs.getString("price")));
            item.setQty(Integer.parseInt(rs.getString("qty")));

            items.add(item);
        }

        return items;
    }
}
