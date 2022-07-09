package App.repository;

import App.Entities.Accounts.OperationsLogs.Log;
import App.Support.Utilities;
import App.repository.sql.ConnectionFactory;
import App.repository.sql.Queries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogRepository {

    public boolean insert(List<Log> logs){

        int rowsAffected = 0;

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stat = con.prepareStatement(Queries.INSERT_LOGS);

            for (Log log : logs) {
                try {

                    stat.setString(1, log.getNameClient());
                    stat.setDouble(2, log.getValue());
                    stat.setString(3, log.getTypeOp().getOperation());
                    stat.setString(4, log.getDate());
                    stat.setString(5, log.getHours());
                    stat.setString(6, log.getSender_receiver());
                    stat.setString(7, log.getNumAccount());

                    rowsAffected = stat.executeUpdate();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            stat.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rowsAffected > 0;
    }

    public List<Log> search(String numAc){

        List<Log> logs = new ArrayList<>();

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stat = con.prepareStatement(Queries.SELECT_LOGS);
            stat.setString(1,numAc);
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {

                Log log = new Log(
                        rs.getInt("id_log"),
                        rs.getString("num_conta"),
                        rs.getString("nome_cliente"),
                        rs.getDouble("valor"),
                        Utilities.ConvertToEnumTypeOp(rs.getString("tipo_op")),
                        rs.getString("data"),
                        rs.getString("horario"),
                        rs.getString("rem_dest")
                );
                logs.add(log);
            }

            stat.close();
            con.close();

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return logs;
    }

    public void remove(){
        // implementar para adm
    }
}
