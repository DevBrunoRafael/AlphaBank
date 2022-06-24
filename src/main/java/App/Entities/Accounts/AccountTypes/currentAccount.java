package App.Entities.Accounts.AccountTypes;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.BankStatement.Statement;
import App.Entities.Accounts.Operations;
import App.Entities.Customer.Client;
import App.Support.GenerateId;

public class currentAccount extends Account implements Operations {

    private double limite; // a definir

//   constructor ================================================================================================
    public currentAccount(Client client) {
        super(GenerateId.getInstance().gerarId(1), client);
    }
//  =============================================================================================================


//   operations =================================================================================================

    @Override
    public void withdraw(double valor)throws Exception {
        if(valor <= saldo){
            saldo -= valor;
        } else if(valor <= (saldo + limite)){
            double valueExceeded = valor - saldo;
            this.saldo = 0;
            limite = limite - valueExceeded;
        } else {
            throw new Exception("Erro: saldo e limite insuficientes para saque.");
        }

        setExtrato(new Statement());
    }

    @Override
    public void transfer(Account dest, double valor)throws Exception {
        if(valor <= saldo) {
            saldo = saldo - valor;
            dest.deposit(valor);
        }
        else if(valor <= (saldo + limite)){
            double quantiaExcedida = valor - saldo;
            this.saldo = 0;
            limite = limite - quantiaExcedida;
            dest.deposit(valor);
        } else {
            throw new Exception("Erro: saldo e limite insuficientes para transferência.");
        }

        setExtrato(new Statement());
    }

    @Override
    public void generateExtract()throws Exception {
        setExtrato(new Statement());
    }
//  =============================================================================================================



//  getters and setters =========================================================================================
    public double getLimite() {
        return limite;
    }
    public void setLimite(double limite) {
        limite = limite;
    }
}
//  =============================================================================================================
