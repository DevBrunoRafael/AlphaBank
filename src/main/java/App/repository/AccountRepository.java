package App.repository;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.AccountTypes.CurrentAccount;
import App.Entities.Accounts.AccountTypes.SavingsAccount;
import App.Support.Utilities;
import App.repository.sql.ConnectionFactory;
import App.repository.sql.Queries;

import java.sql.*;

public class AccountRepository {

    public boolean insert(Account account){
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stat = con.prepareStatement(Queries.INSERT_ACCOUNT);
            stat.setString(1, account.getNumAccount());
            stat.setDouble(2, account.getBalance());
            stat.setString(3, account.getClient().getCpf());
            int rowsAffected = stat.executeUpdate();

            stat.close();
            con.close();
            return rowsAffected > 0;

        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public Account search(String numAc){
        Account account = null;

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stat = con.prepareStatement(Queries.SELECT_ACCOUNT);
            stat.setString(1, numAc);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){

                String type = rs.getString("num_conta");
                String client = rs.getString("cpf_cliente");
                double balance = rs.getDouble("saldo");

                switch (Utilities.TypeChecker(type)){

                    case "Poupança" -> {
                        account = new SavingsAccount(type,new ClientRepository().search(client));
                        account.setBalance(balance);
                    }

                    case "Corrente" -> {
                        account = new CurrentAccount(type,new ClientRepository().search(client));
                        account.setBalance(balance);
                    }

                }
            }

            stat.close();
            con.close();

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return account;
    }

    public boolean update(Account account){
        int rowsAffected = 0;

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stat = con.prepareStatement(Queries.UPDATE_ACCOUNT);
            stat.setDouble(1, account.getBalance());
            stat.setString(2, account.getNumAccount());
            rowsAffected = stat.executeUpdate();

            stat.close();
            con.close();

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return rowsAffected > 0;
    }

    public void Remove(){
        // implementar para adm
    }
}
