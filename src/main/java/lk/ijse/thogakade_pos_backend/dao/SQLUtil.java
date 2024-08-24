package lk.ijse.thogakade_pos_backend.dao;

import lk.ijse.thogakade_pos_backend.db.DbConnection;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {

    public static <T>T execute(String sql, Object... objects) throws SQLException, NamingException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < objects.length; i++) {
            preparedStatement.setObject(i + 1, objects[i]);
        }

        if(sql.startsWith("SELECT")){
            return (T) preparedStatement.executeQuery();
        } else {
            return (T) (Boolean) (preparedStatement.executeUpdate()>0);
        }

    }
}
