package lk.ijse.thogakade_pos_backend.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.thogakade_pos_backend.bo.custom.OrderBO;
import lk.ijse.thogakade_pos_backend.bo.custom.impl.OrderBOImpl;
import lk.ijse.thogakade_pos_backend.dto.ItemDTO;
import lk.ijse.thogakade_pos_backend.dto.OrderDTO;
import lk.ijse.thogakade_pos_backend.dto.OrderDetailsDTO;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/order")
public class OrderController extends HttpServlet {

    private OrderBO orderBO = new OrderBOImpl();

    // save order
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        Jsonb jsonb = JsonbBuilder.create();
        OrderDetailsDTO orderDetailsDTO = jsonb.fromJson(req.getReader(), OrderDetailsDTO.class);
        System.out.println("orderDetailsDTO in controller : " + orderDetailsDTO);

        try (var writer = resp.getWriter()){

            if(orderBO.saveOrder(orderDetailsDTO)){
                writer.write("Order saved successfully...");
                resp.setStatus(HttpServletResponse.SC_CREATED);
            } else {
                writer.write("Order not saved...");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (JsonbException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    // get all orders
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (var writer = resp.getWriter()){

            List<OrderDetailsDTO> orderDetailsDTOS = orderBO.getAllOrders();

            resp.setContentType("application/json");

            Jsonb jsonb = JsonbBuilder.create();

            // Serialization
            jsonb.toJson(orderDetailsDTOS, writer);

        } catch (SQLException | NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
