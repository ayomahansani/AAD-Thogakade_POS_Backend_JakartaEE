package lk.ijse.thogakade_pos_backend.dao.custom.impl;

import lk.ijse.thogakade_pos_backend.dao.SQLUtil;
import lk.ijse.thogakade_pos_backend.dao.custom.OrderDAO;
import lk.ijse.thogakade_pos_backend.db.DbConnection;
import lk.ijse.thogakade_pos_backend.entity.Item;
import lk.ijse.thogakade_pos_backend.entity.OrderDetails;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    static String SAVE_ORDER = "INSERT INTO Orders (orderId,orderDate,customerId,totalPrice,discount,subTotal) VALUES (?,?,?,?,?,?)";
    static String GET_ORDER = "SELECT * FROM Orders";

    @Override
    public boolean save(OrderDetails orderDetails) throws SQLException, NamingException {

        //System.out.println("OrderDetails entity" + orderDetails);

        //return SQLUtil.execute(SAVE_ORDER, orderDetails.getOrderId(),orderDetails.getOrderDate(),orderDetails.getCustomerId(),orderDetails.getTotalPrice(),orderDetails.getDiscount(),orderDetails.getSubTotal());

        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement(SAVE_ORDER);

        pstm.setString(1, orderDetails.getOrderId());
        pstm.setDate(2, Date.valueOf(orderDetails.getOrderDate()));
        pstm.setString(3, orderDetails.getCustomerId());
        pstm.setDouble(4, orderDetails.getTotalPrice());
        pstm.setDouble(5, orderDetails.getDiscount());
        pstm.setDouble(6, orderDetails.getSubTotal());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public List<OrderDetails> getAll() throws SQLException, NamingException {

        ResultSet rs = SQLUtil.execute(GET_ORDER);

        List<OrderDetails> orderDetails = new ArrayList<>();

        while (rs.next()) {

            OrderDetails orderDetail = new OrderDetails();

            orderDetail.setOrderId(rs.getString("orderId"));
            orderDetail.setOrderDate(rs.getDate("orderDate").toLocalDate());
            orderDetail.setCustomerId(rs.getString("customerId"));
            orderDetail.setTotalPrice(rs.getDouble("totalPrice"));
            orderDetail.setDiscount(rs.getDouble("discount"));
            orderDetail.setSubTotal(rs.getDouble("subTotal"));

            orderDetails.add(orderDetail);
        }

        return orderDetails;

    }
}
