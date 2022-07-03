package App.repository;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.AccountTypes.currentAccount;
import App.Entities.Accounts.AccountTypes.savingsAccount;
import App.Entities.Customer.Client;
import App.Support.Utilities;
import App.repository.sql.ConnectionFactory;
import App.repository.sql.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {

    public static boolean Insert(Account account){
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

    public static Account Search(String numAc){
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
                            account = new savingsAccount(ClientRepository.Search(client));
                            account.setBalance(balance);
                        }

                        case "Corrente" -> {
                            account = new currentAccount(ClientRepository.Search(client));
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

    public static void Update(){

    }

    public static void Remove(){

    }
}
