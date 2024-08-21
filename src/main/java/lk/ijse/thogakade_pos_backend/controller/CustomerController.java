package lk.ijse.thogakade_pos_backend.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.thogakade_pos_backend.bo.CustomerBO;
import lk.ijse.thogakade_pos_backend.bo.CustomerBOImpl;
import lk.ijse.thogakade_pos_backend.dto.CustomerDTO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/customer")
public class CustomerController extends HttpServlet {


    Connection connection;

    private CustomerBO customerBO = new CustomerBOImpl();



    @Override
    public void init() throws ServletException {

        // create a connection
        try {

            var connectionSpace  = new InitialContext();
            DataSource pool = (DataSource) connectionSpace.lookup("java:comp/env/jdbc/thogakadeConnectionPool");
            this.connection = pool.getConnection();
            System.out.println("Connection created");

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
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (JsonbException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }

    }

}
