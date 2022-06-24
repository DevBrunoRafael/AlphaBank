package App.Entities.Accounts;

import App.Entities.Accounts.BankStatement.Statement;
import App.Entities.Customer.Client;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Account {

    protected String numAccount = null; // a definir...
    protected Client client;
    protected double saldo = 0; // valor inicial...
    protected Statement extrato;

    public Account(String numAccount, Client client) {
        this.numAccount = numAccount;
        this.client = client;
    }

    public String getNumAccount() {
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



    public void setNumAccount(String numAccount) {
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



    Locale ptBr = new Locale("pt", "BR");
    @Override
    public String toString() {
        return "\nCliente" + this.client.toString() +
                "\n{ "+
                "\n\tN° Conta: " + this.numAccount +
                "\n\tSaldo: " + NumberFormat.getCurrencyInstance(ptBr).format(this.saldo) +
                "\n} ";
    }
}
