package App.Entities.Accounts.BankStatement;

import App.Entities.Accounts.TypeOperations;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static App.Entities.Accounts.TypeOperations.*;

public class ExtractLog {

    protected String numAccount;
    protected String nomeCliente;
    protected double valor;
    protected TypeOperations typeOp;
    protected String date;
    protected String hours;

    protected String nomeDest;
    protected String nomeRem;

    public ExtractLog(String numAccount, String nomeCliente, double valor, TypeOperations typeOp) {
        this.numAccount = numAccount;
        this.nomeCliente = nomeCliente;
        this.valor = valor;
        this.typeOp = typeOp;

        Date current = new Date();
        this.date = new SimpleDateFormat("dd/MM/yyyy").format(current);
        this.hours = new SimpleDateFormat("HH:mm:ss").format(current);
    }

    public ExtractLog(String numAccount, String nomeCliente, double valor, TypeOperations typeOp, String nomeDest) {
        this.numAccount = numAccount;
        this.nomeCliente = nomeCliente;
        this.valor = valor;
        this.typeOp = typeOp;
        this.nomeDest = nomeDest;

        Date current = new Date();
        this.date = new SimpleDateFormat("dd/MM/yyyy").format(current);
        this.hours = new SimpleDateFormat("HH:mm:ss").format(current);
    }


    public String toString(){

        Locale ptBr = new Locale("pt", "BR");

        StringBuilder log = new StringBuilder(numAccount + "\n" + date + "\t" + hours + "\tOp: ");

        switch (this.typeOp){
            case DEPOSIT -> log
                    .append(DEPOSIT.getOperation())
                    .append("\t")
                    .append(NumberFormat.getCurrencyInstance(ptBr).format(this.valor));

            case WITHDRAW -> log
                    .append(WITHDRAW.getOperation())
                    .append("\t")
                    .append(NumberFormat.getCurrencyInstance(ptBr).format(this.valor));

            case TRANSFER_SENT -> log
                    .append(TRANSFER_SENT.getOperation())
                    .append("\t")
                    .append(NumberFormat.getCurrencyInstance(ptBr).format(this.valor))
                    .append("\tDest: ")
                    .append(this.nomeDest);

            case TRANSFER_RECEIVED -> log
                    .append(TRANSFER_RECEIVED.getOperation())
                    .append("\t")
                    .append(NumberFormat.getCurrencyInstance(ptBr).format(this.valor))
                    .append("\tRem: ").append(this.nomeRem);

            default -> log.append("Unknown");
        }
        return log.toString();
    }
}
