package App.Entities.Accounts.AccountTypes;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.BankStatement.Statement;
import App.Entities.Accounts.Operations;
import App.Entities.Customer.Client;
import App.Support.GenerateId;

public class savingsAccount extends Account implements Operations {

    private double juros = 0;

    public savingsAccount(Client client) {
        super(GenerateId.getInstance().gerarId(0), client);
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


    public double getJuros() {
        return juros;
    }
    public void setJuros(double juros) {
        this.juros = juros;
    }
}