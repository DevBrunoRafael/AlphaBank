package App.service.sql;

import App.Private.DataBaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/tech_bank";

        return DriverManager.getConnection(
                url,
                DataBaseAccess.USER,
                DataBaseAccess.PASSWORD
        );
    }


}
