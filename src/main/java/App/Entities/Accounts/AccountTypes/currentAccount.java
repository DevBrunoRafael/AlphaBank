package App.Entities.Accounts.AccountTypes;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.BankStatement.ExtractLog;
import App.Entities.Accounts.Operations;
import App.Entities.Accounts.TypeOperations;
import App.Entities.Customer.Client;
import App.Support.Utilities;

public class currentAccount extends Account implements Operations {

    private double limite; // a definir

//   constructor ================================================================================================
    public currentAccount(Client client) {
        super(Utilities.generateId(1), client);
    }
//  =============================================================================================================


//   operations =================================================================================================

    @Override
    public void withdraw(double value)throws Exception {
        if(value <= balance){
            super.subtractAccountValue(value);
            TypeOperations type = TypeOperations.WITHDRAW;
            ExtractLog log = new ExtractLog(
                    this.numAccount, this.client.getName(), value, type
            );

            histLogs.add(log);

        }
        else if(value <= (balance + limite)){
            double valueExceeded = value - balance;
            this.balance = 0;
            limite = limite - valueExceeded;

            TypeOperations type = TypeOperations.WITHDRAW;
            ExtractLog log = new ExtractLog(
                    this.numAccount, this.client.getName(), value, type
            );

            histLogs.add(log);

        }
        else {
            throw new Exception("Erro: saldo e limite insuficientes para saque.");
        }
    }

    @Override
    public void transfer(Account receiver, double value)throws Exception {
        if(value <= balance) {
            super.subtractAccountValue(value);
            receiver.setSaldoTransfer(this.client.getName(), value);

            TypeOperations type = TypeOperations.TRANSFER_SENT;
            ExtractLog log = new ExtractLog(
                    this.numAccount, this.client.getName(), value, type, receiver.getClient().getName()
            );

            histLogs.add(log);

        }
        else if(value <= (balance + limite)){
            double valueExceeded = value - balance;
            this.balance = 0;
            limite = limite - valueExceeded;
            receiver.setSaldoTransfer(this.client.getName(), value);

            TypeOperations type = TypeOperations.TRANSFER_SENT;
            ExtractLog log = new ExtractLog(
                    this.numAccount, this.client.getName(), value, type, receiver.getClient().getName()
            );

            histLogs.add(log);

        }
        else {
            throw new Exception("Erro: saldo e limite insuficientes para transferência.");
        }
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
