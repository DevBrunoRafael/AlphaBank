package App.Entities.Accounts.BankStatement;

import App.Entities.Accounts.TypeOperations;
import App.Support.Utilities;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static App.Entities.Accounts.TypeOperations.*;

public class ExtractLog {

    private String numAccount;
    private String nameClient;
    private double value;
    private TypeOperations typeOp;
    private String date;
    private String hours;

    protected String sender_receiver;


    public ExtractLog(String numAccount, String nameClient, double value, TypeOperations typeOp) {
        this.numAccount = numAccount;
        this.nameClient = nameClient;
        this.value = value;
        this.typeOp = typeOp;
        this.date = Utilities.CurrentDate();
        this.hours = Utilities.CurrentTime();
    }

    public ExtractLog(String numAccount, String nameClient, double value, TypeOperations typeOp, String sender_receiver) {
        this.numAccount = numAccount;
        this.nameClient = nameClient;
        this.value = value;
        this.typeOp = typeOp;
        this.sender_receiver = sender_receiver;
        this.date = Utilities.CurrentDate();
        this.hours = Utilities.CurrentTime();
    }


    public String toString(){

        Locale ptBr = new Locale("pt", "BR");

        StringBuilder log = new StringBuilder("\n" + date + "\t" + hours + "\tOp: ");

        switch (this.typeOp){
            case DEPOSIT -> log
                    .append(DEPOSIT.getOperation())
                    .append("\t")
                    .append(NumberFormat.getCurrencyInstance(ptBr).format(this.value));

            case WITHDRAW -> log
                    .append(WITHDRAW.getOperation())
                    .append("\t")
                    .append(NumberFormat.getCurrencyInstance(ptBr).format(this.value));

            case TRANSFER_SENT -> log
                    .append(TRANSFER_SENT.getOperation())
                    .append("\t")
                    .append(NumberFormat.getCurrencyInstance(ptBr).format(this.value))
                    .append("\tDest: ")
                    .append(this.sender_receiver);

            case TRANSFER_RECEIVED -> log
                    .append(TRANSFER_RECEIVED.getOperation())
                    .append("\t")
                    .append(NumberFormat.getCurrencyInstance(ptBr).format(this.value))
                    .append("\tRem: ").append(this.sender_receiver);

            default -> log.append("Unknown");
        }
        return log.toString();
    }

    public String getNumAccount() {
        return numAccount;
    }
    public String getNameClient() {
        return nameClient;
    }
    public double getValue() {
        return value;
    }
    public TypeOperations getTypeOp() {
        return typeOp;
    }
    public String getDate() {
        return date;
    }
    public String getHours() {
        return hours;
    }
    public String getSender_receiver() {
        return sender_receiver;
    }

    public void setNumAccount(String numAccount) {
        this.numAccount = numAccount;
    }
    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public void setTypeOp(TypeOperations typeOp) {
        this.typeOp = typeOp;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setHours(String hours) {
        this.hours = hours;
    }
    public void setSender_receiver(String sender_receiver) {
        this.sender_receiver = sender_receiver;
    }
}
