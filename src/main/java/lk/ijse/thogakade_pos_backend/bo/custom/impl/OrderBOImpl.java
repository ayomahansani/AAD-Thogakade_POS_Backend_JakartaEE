package lk.ijse.thogakade_pos_backend.bo.custom.impl;

import lk.ijse.thogakade_pos_backend.bo.custom.OrderBO;
import lk.ijse.thogakade_pos_backend.dao.custom.OrderDAO;
import lk.ijse.thogakade_pos_backend.dao.custom.impl.OrderDAOImpl;
import lk.ijse.thogakade_pos_backend.dto.ItemDTO;
import lk.ijse.thogakade_pos_backend.dto.OrderDTO;
import lk.ijse.thogakade_pos_backend.dto.OrderDetailsDTO;
import lk.ijse.thogakade_pos_backend.entity.Item;
import lk.ijse.thogakade_pos_backend.entity.OrderDetails;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderBOImpl implements OrderBO {

    private OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public boolean saveOrder(OrderDetailsDTO orderDetailsDTO) throws SQLException, NamingException {

        OrderDetails orderDetails = new OrderDetails(
                orderDetailsDTO.getOrderId(), orderDetailsDTO.getOrderDate(), orderDetailsDTO.getCustomerId(),
                orderDetailsDTO.getTotalPrice(), orderDetailsDTO.getDiscount(), orderDetailsDTO.getSubTotal()
        );
        return orderDAO.save(orderDetails);
    }

    @Override
    public List<OrderDetailsDTO> getAllOrders() throws SQLException, NamingException {

        List<OrderDetails> orders = orderDAO.getAll();
        List<OrderDetailsDTO> orderDetailsDTOS = new ArrayList<>();

        List<OrderDTO> orderItems = new ArrayList<>();

        for (OrderDetails orderDetails : orders) {
            OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO(
                    orderDetails.getOrderId(),orderDetails.getOrderDate(),orderDetails.getCustomerId(),
                    orderItems,orderDetails.getTotalPrice(),orderDetails.getDiscount(),orderDetails.getSubTotal()

            );
            orderDetailsDTOS.add(orderDetailsDTO);
        }

        return orderDetailsDTOS;
    }
}
