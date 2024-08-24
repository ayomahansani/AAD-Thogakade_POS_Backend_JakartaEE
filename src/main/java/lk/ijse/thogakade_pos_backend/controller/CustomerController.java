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
import lk.ijse.thogakade_pos_backend.bo.custom.CustomerBO;
import lk.ijse.thogakade_pos_backend.bo.custom.impl.CustomerBOImpl;
import lk.ijse.thogakade_pos_backend.db.DbConnection;
import lk.ijse.thogakade_pos_backend.dto.CustomerDTO;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet(urlPatterns = "/customer")
public class CustomerController extends HttpServlet {


    Connection connection;

    private CustomerBO customerBO = new CustomerBOImpl();



    @Override
    public void init() throws ServletException {

        // get instance of a db connection
        try {

            connection = DbConnection.getInstance().getConnection();

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }

    }


    // save customer
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);

        try (var writer = resp.getWriter()){

            if(customerBO.saveCustomer(customerDTO, connection)){
                writer.write("Customer saved successfully...");
                resp.setStatus(HttpServletResponse.SC_CREATED);
            } else {
                writer.write("Customer not saved...");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (JsonbException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    // update customer
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        var customerId = req.getParameter("id");

        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);

        try (var writer = resp.getWriter()){

            if(customerBO.updateCustomer(customerId, customerDTO, connection)){
                writer.write("Customer updated successfully...");
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                writer.write("Customer not updated...");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (JsonException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    // delete customer
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var customerId = req.getParameter("id");

        try(var writer = resp.getWriter()) {

            if(customerBO.deleteCustomer(customerId, connection)){
                writer.write("Customer deleted successfully...");
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }else {
                writer.write("Customer not deleted...");
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            throw new RuntimeException(e);
        }
    }


    // get all customers
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (var writer = resp.getWriter()){

            List<CustomerDTO> customerDTOS = customerBO.getAllCustomers(connection);

            resp.setContentType("application/json");

            Jsonb jsonb = JsonbBuilder.create();

            // Serialization
            jsonb.toJson(customerDTOS, writer);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
