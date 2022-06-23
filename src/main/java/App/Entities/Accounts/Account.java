package App.Entities.Accounts;

import App.Entities.Accounts.BankStatement.Statement;
import App.Entities.Customer.Client;

public abstract class Account {

    protected int numAccount;
    protected Client client;
    protected double saldo;
    protected Statement extrato;

}
