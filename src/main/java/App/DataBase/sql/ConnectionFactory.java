package App.DataBase.sql;

import App.DataBase.Private.AccessDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection(){

        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = AccessDB.USER;
        String password = AccessDB.PASSWORD;

        try {

            return DriverManager.getConnection(url,username,password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
