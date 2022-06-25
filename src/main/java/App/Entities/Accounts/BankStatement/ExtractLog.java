package App.Entities.Accounts.BankStatement;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ExtractLog {

    protected String numAccount;
    protected String nomeCliente;
    protected double valor;
    protected String information;
    protected int operation;

    protected String date;
    protected String hours;

    public ExtractLog() {
    }

    public ExtractLog(String numAccount, String nomeCliente, double valor, int operation) {
        this.numAccount = numAccount;
        this.nomeCliente = nomeCliente;
        this.valor = valor;
        this.operation = operation;
        this.information = this.LogInformation(); // pensando em tirar isso

        Date dataHoraAtual = new Date();
        this.date = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        this.hours = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
    }

    public String LogInformation(){

        Locale ptBr = new Locale("pt", "BR");

        StringBuilder log = new StringBuilder(
                "Cliente: " + this.nomeCliente + "\tConta: " + this.numAccount +
                "\n" + date + "\t" + hours + "\tOp: "
        );

        switch (this.operation){
            case 1 -> {
                log.append("Depósito").append("\t").append(
                        NumberFormat.getCurrencyInstance(ptBr).format(this.valor)
                );
            }
            case 2 -> {
                log.append("Saque").append("\t").append(
                        NumberFormat.getCurrencyInstance(ptBr).format(this.valor)
                );
            }
            case 3 -> {
                log.append("Transferência"); // implementar
            }
        }
        return log.toString();
    }
}
