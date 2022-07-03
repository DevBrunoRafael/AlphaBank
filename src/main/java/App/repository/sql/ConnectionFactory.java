package App.repository.sql;

import App.repository.Private.AccessDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/mysql";

        return DriverManager.getConnection(
                url,
                AccessDB.USER,
                AccessDB.PASSWORD
        );
    }


}
