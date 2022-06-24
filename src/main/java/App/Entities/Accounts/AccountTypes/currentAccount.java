package App.Entities.Accounts.AccountTypes;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.BankStatement.Statement;
import App.Entities.Accounts.Operations;
import App.Entities.Customer.Client;
import App.Support.GenerateId;

public class currentAccount extends Account implements Operations {

    private double Limite = 0; // a definir

    public currentAccount(Client client) {
        super(GenerateId.getInstance().gerarId(1), client);
    }

    @Override
    public void deposit() {
        setExtrato(new Statement());
    }

    @Override
    public void withdraw() {
        setExtrato(new Statement());
    }

    @Override
    public void transfer() {
        setExtrato(new Statement());
    }

    @Override
    public void generateExtract() {
        setExtrato(new Statement());
    }



    public double getLimite() {
        return Limite;
    }
    public void setLimite(double limite) {
        Limite = limite;
    }
}