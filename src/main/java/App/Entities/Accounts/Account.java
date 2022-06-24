package App.Entities.Accounts;

import App.Entities.Accounts.BankStatement.Statement;
import App.Entities.Customer.Client;

public abstract class Account {

    protected int numAccount = 0; // a definir...
    protected Client client;
    protected double saldo = 0; // valor inicial...
    protected Statement extrato;

    public Account(Client client) {
        this.client = client;
    }

    public int getNumAccount() {
        return numAccount;
    }

    public Client getClient() {
        return client;
    }

    public double getSaldo() {
        return saldo;
    }

    public Statement getExtrato() {
        return extrato;
    }

    public void setNumAccount(int numAccount) {
        this.numAccount = numAccount;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setExtrato(Statement extrato) {
        this.extrato = extrato;
    }
}
