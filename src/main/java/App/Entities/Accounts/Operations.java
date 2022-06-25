package App.Entities.Accounts;

public interface Operations {
    void deposit(double valor) throws Exception;

    void withdraw(double valor) throws Exception;

    void transfer(Account dest, double valor) throws Exception;

}