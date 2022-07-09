package App.service.repository;

import App.Entities.Customer.Client;
import App.service.sql.ConnectionFactory;
import App.service.sql.Queries;

import java.sql.*;

public class ClientRepository {

    public boolean insert(Client client){ //
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stat = con.prepareStatement(Queries.INSERT_CLIENT);
            stat.setString(1, client.getName());
            stat.setString(2, client.getLastName());
            stat.setString(3, client.getBirthDate());
            stat.setString(4, client.getCpf());

             int rowsAffected = stat.executeUpdate();

            stat.close();
            con.close();
            return rowsAffected > 0;

        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public Client search(String _cpf){
        Client client = null;

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stat = con.prepareStatement(Queries.SELECT_CLIENT);
            stat.setString(1, _cpf);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){

                client = new Client(
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        rs.getString("idade"),
                        rs.getString("cpf")
                );
            }

            stat.close();
            con.close();

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return client;
    }

    public void remove(String cpf){
        // implementar para adm
    }

}
