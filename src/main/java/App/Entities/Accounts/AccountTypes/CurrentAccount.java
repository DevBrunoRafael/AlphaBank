package App.Entities.Accounts.AccountTypes;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.OperationsLogs.Log;
import App.Entities.Accounts.Operations;
import App.Entities.Accounts.TypeOperations;
import App.Entities.Customer.Client;
import App.Support.Utilities;

public class CurrentAccount extends Account implements Operations {

    private double limite; // a definir

//   constructor ================================================================================================
    public CurrentAccount(Client client) {
        super(Utilities.generateId(1), client);
    }

    public CurrentAccount(String numAccount,Client client) {
        super(numAccount, client);
    }
//  =============================================================================================================


//   operations =================================================================================================

    @Override
    public void withdraw(double value)throws Exception {
        if(value <= balance){
            super.subtractAccountValue(value);
            TypeOperations type = TypeOperations.WITHDRAW;
            Log log = new Log(
                    this.numAccount,
                    this.client.getName(),
                    value,
                    type,
                    Utilities.CurrentDate(),
                    Utilities.CurrentTime(),
                    null
            );

            historyLogs.add(log);

        }
        else if(value <= (balance + limite)){
            double valueExceeded = value - balance;
            this.balance = 0;
            limite = limite - valueExceeded;

            TypeOperations type = TypeOperations.WITHDRAW;
            Log log = new Log(
                    this.numAccount,
                    this.client.getName(),
                    value,
                    type,
                    Utilities.CurrentDate(),
                    Utilities.CurrentTime(),
                    null
            );

            historyLogs.add(log);

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
            Log log = new Log(
                    this.numAccount,
                    this.client.getName(),
                    value,
                    type,
                    Utilities.CurrentDate(),
                    Utilities.CurrentTime(),
                    receiver.getClient().getName()
            );

            historyLogs.add(log);

        }
        else if(value <= (balance + limite)){
            double valueExceeded = value - balance;
            this.balance = 0;
            limite = limite - valueExceeded;
            receiver.setSaldoTransfer(this.client.getName(), value);

            TypeOperations type = TypeOperations.TRANSFER_SENT;
            Log log = new Log(
                    this.numAccount,
                    this.client.getName(),
                    value,
                    type,
                    Utilities.CurrentDate(),
                    Utilities.CurrentTime(),
                    receiver.getClient().getName()
            );

            historyLogs.add(log);

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
