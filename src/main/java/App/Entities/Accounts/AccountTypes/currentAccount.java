package App.Entities.Accounts.AccountTypes;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.BankStatement.ExtractLog;
import App.Entities.Accounts.Operations;
import App.Entities.Accounts.TypeOperations;
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

            TypeOperations type = TypeOperations.WITHDRAW;
            ExtractLog log = new ExtractLog(
                    this.numAccount, this.client.getNome(), valor, type
            );

        } else if(valor <= (saldo + limite)){
            double valueExceeded = valor - saldo;
            this.saldo = 0;
            limite = limite - valueExceeded;

            TypeOperations type = TypeOperations.WITHDRAW;
            ExtractLog log = new ExtractLog(
                    this.numAccount, this.client.getNome(), valor, type
            );

        } else {
            throw new Exception("Erro: saldo e limite insuficientes para saque.");
        }

        // ADD ARRAYLIST FOR CLASS
    }

    @Override
    public void transfer(Account dest, double valor)throws Exception {
        if(valor <= saldo) {
            saldo -= valor;
            dest.setSaldoTransfer(this.client.getNome(), valor);

            TypeOperations type = TypeOperations.TRANSFER_SENT;
            ExtractLog log = new ExtractLog(
                    this.numAccount, this.client.getNome(), valor, type, dest.getClient().getNome()
            );

            // ADD ARRAYLIST FOR CLASS
        }
        else if(valor <= (saldo + limite)){
            double quantiaExcedida = valor - saldo;
            this.saldo = 0;
            limite = limite - quantiaExcedida;
            dest.setSaldoTransfer(this.client.getNome(), valor);

            TypeOperations type = TypeOperations.TRANSFER_SENT;
            ExtractLog log = new ExtractLog(
                    this.numAccount, this.client.getNome(), valor, type, dest.getClient().getNome()
            );

            // ADD ARRAYLIST FOR CLASS

        } else {
            throw new Exception("Erro: saldo e limite insuficientes para transferência.");
        }
    }

    @Override
    public void generateExtract()throws Exception {
        //implementar
    }
//  =============================================================================================================



//  getters and setters =========================================================================================
    public double getLimite() {
        return limite;
    }
    public void setLimite(double limite) {
        this.limite = limite;
    }
//  =============================================================================================================
}
