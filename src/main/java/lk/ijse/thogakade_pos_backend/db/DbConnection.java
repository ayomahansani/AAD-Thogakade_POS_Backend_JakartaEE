package lk.ijse.thogakade_pos_backend.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConnection {

    private static DbConnection dbConnection;
    private Connection connection;

    private DbConnection() throws NamingException, SQLException {

        var connectionSpace  = new InitialContext();
        DataSource pool = (DataSource) connectionSpace.lookup("java:comp/env/jdbc/thogakadeConnectionPool");
        this.connection = pool.getConnection();
        System.out.println("Connection created");

    }

    public static DbConnection getInstance() throws SQLException, NamingException {
        return (dbConnection == null) ? dbConnection = new DbConnection() : dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
