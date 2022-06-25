package App.Entities.Accounts;

import App.Entities.Accounts.BankStatement.ExtractLog;
import App.Entities.Customer.Client;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Account {

    protected String numAccount = null; // a definir...
    protected Client client;
    protected double saldo; // valor inicial...
    protected ExtractLog extrato; // arrayList


//   constructor ================================================================================================
    public Account(String numAccount, Client client) {
        this.numAccount = numAccount;
        this.client = client;
    }
//  =============================================================================================================


//   operations ================================================================================================

    public void deposit(double valor) throws Exception {
        saldo += valor;

        TypeOperations type = TypeOperations.DEPOSIT;
        ExtractLog log = new ExtractLog(
            this.numAccount, this.client.getNome(), valor, type
        );

        // ADD ARRAYLIST FOR CLASS

        System.out.println(log);

    }


    public void withdraw(double valor) throws Exception {
        if(valor <= saldo){
            saldo -= valor;

            TypeOperations type = TypeOperations.WITHDRAW;
            ExtractLog log = new ExtractLog(
                    this.numAccount, this.client.getNome(), valor, type
            );

            // ADD ARRAYLIST FOR CLASS

        } else {
            throw new Exception("Erro: saldo insuficientes para saque.");
        }
    }


    public void transfer(Account dest, double valor) throws Exception{
        if(saldo >= valor){
            saldo -= valor;

            dest.setSaldoTransfer(this.client.getNome(), valor);

            TypeOperations type = TypeOperations.TRANSFER_SENT;
            ExtractLog log = new ExtractLog(
                    this.numAccount, this.client.getNome(), valor, type, dest.getClient().getNome()
            );

            System.out.println(log);

            // ADD ARRAYLIST FOR CLASS

        } else {
            throw new Exception("Erro: saldo e limite insuficientes para transferência.");
        }
    }


    public void generateExtract() throws Exception {
        //implementar
    }
//   =========================================================================================================


//   getters and setters =====================================================================================
    public String getNumAccount() {
        return numAccount;
    }
    public Client getClient() {
        return client;
    }
    public double getSaldo() {
        return saldo;
    }
    public ExtractLog getExtrato() {
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
    public void setExtrato(ExtractLog extrato) {
        this.extrato = extrato;
    }
//  ===========================================================================================================


//  auxiliary method ==========================================================================================
    public void setSaldoTransfer(String rem, double valor){
        this.saldo += valor;

        TypeOperations type = TypeOperations.TRANSFER_RECEIVED;
        ExtractLog log = new ExtractLog(
                this.numAccount, this.client.getNome(), valor, type, rem
        );

        System.out.println(log);
    }
//  ===========================================================================================================



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
