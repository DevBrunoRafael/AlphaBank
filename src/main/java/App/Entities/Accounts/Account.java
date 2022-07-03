package App.Entities.Accounts;

import App.Entities.Accounts.OperationsLogs.Log;
import App.Entities.Customer.Client;
import App.Support.Utilities;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public abstract class Account {

    protected String numAccount;
    protected Client client;
    protected double balance = 0; // inicia zerado
    protected List<Log> historyLogs = new ArrayList<>();

    // abstrair alguns métodos e implementar na classe que herda



//   constructor ================================================================================================
    public Account(String numAccount, Client client) {
        this.numAccount = numAccount;
        this.client = client;
    }
//  =============================================================================================================


//   operations ================================================================================================
    public void deposit(double value) throws Exception {
        balance += value;

        TypeOperations type = TypeOperations.DEPOSIT;
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

    public void withdraw(double value) throws Exception {
        if(value <= balance){
            this.subtractAccountValue(value);

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

        } else {
            throw new Exception("Erro: saldo insuficientes para saque.");
        }
    }

    public void transfer(Account receiver, double value) throws Exception{
        if(balance >= value){
            this.subtractAccountValue(value);

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

        } else {
            throw new Exception("Erro: saldo e limite insuficientes para transferência.");
        }
    }


    public void generateExtract() throws Exception {
        List<Log> hist = historyLogs;
        hist.forEach(System.out::println);

        // alterar posteriormente
    }
//   =========================================================================================================


//   getters and setters =====================================================================================
    public String getNumAccount() {
        return numAccount;
    }
    public void setNumAccount(String numAccount) {
        this.numAccount = numAccount;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public List<Log> getHistoryLogs() {
        return historyLogs;
    }
    public void setHistoryLogs(List<Log> historyLogs) {
        this.historyLogs = historyLogs;
    }
    //  ===========================================================================================================


//  auxiliary method ==========================================================================================
    public void setSaldoTransfer(String sender, double value){
        this.balance += value;

        TypeOperations type = TypeOperations.TRANSFER_RECEIVED;
        Log log = new Log(
                this.numAccount,
                this.client.getName(),
                value,
                type,
                Utilities.CurrentDate(),
                Utilities.CurrentTime(),
                sender
        );

        historyLogs.add(log);
    }

    protected void subtractAccountValue(double value){
        balance -= value;
    };
//  ===========================================================================================================



    Locale ptBr = new Locale("pt", "BR");
    @Override
    public String toString() {
        return "\nCliente" + this.client.toString() +
                "\n{ "+
                "\n\tN° Conta: " + this.numAccount +
                "\n\tSaldo: " + NumberFormat.getCurrencyInstance(ptBr).format(this.balance) +
                "\n} ";
    }
}
