package lk.ijse.thogakade_pos_backend.controller;

import jakarta.json.JsonException;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.thogakade_pos_backend.bo.custom.ItemBO;
import lk.ijse.thogakade_pos_backend.bo.custom.impl.ItemBOImpl;
import lk.ijse.thogakade_pos_backend.dto.ItemDTO;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/item")
public class ItemController extends HttpServlet {

    private ItemBO itemBO = new ItemBOImpl();


    // save item
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        Jsonb jsonb = JsonbBuilder.create();
        ItemDTO itemDTO = jsonb.fromJson(req.getReader(), ItemDTO.class);

        try (var writer = resp.getWriter()){

            if(itemBO.saveItem(itemDTO)){
                writer.write("Item saved successfully...");
                resp.setStatus(HttpServletResponse.SC_CREATED);
            } else {
                writer.write("Item not saved...");
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


    // update item
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        var itemCode = req.getParameter("code");

        Jsonb jsonb = JsonbBuilder.create();
        ItemDTO itemDTO = jsonb.fromJson(req.getReader(), ItemDTO.class);

        try (var writer = resp.getWriter()){

            if(itemBO.updateItem(itemCode, itemDTO)){
                writer.write("Item updated successfully...");
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                writer.write("Item not updated...");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (JsonException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }


    // delete item
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var itemCode = req.getParameter("code");

        try(var writer = resp.getWriter()) {

            if(itemBO.deleteItem(itemCode)){
                writer.write("Item deleted successfully...");
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }else {
                writer.write("Item not deleted...");
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            throw new RuntimeException(e);
        }
    }


    // get all items
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (var writer = resp.getWriter()){

            List<ItemDTO> itemDTOS = itemBO.getAllItems();

            resp.setContentType("application/json");

            Jsonb jsonb = JsonbBuilder.create();

            // Serialization
            jsonb.toJson(itemDTOS, writer);

        } catch (SQLException | NamingException e) {
            throw new RuntimeException(e);
        }

    }

}
