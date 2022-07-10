package App.Client;

import App.Components.GeneratePDFs.FacadePDF;
import App.Components.SendingEmails.FacadeEMAIL;
import App.Components.SendingEmails.Models.EmailConfig;
import App.Entities.Accounts.Account;
import App.Entities.Accounts.AccountTypes.CurrentAccount;
import App.Entities.Accounts.AccountTypes.SavingsAccount;
import App.Entities.Customer.Client;
import App.Service.AccountService;
import App.Service.ClientService;
import App.Service.LogService;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Intermediation {

    static Scanner scanner = new Scanner(System.in);

    private Account account;
    private Client client;

    public void registarCliente(){
        System.out.println("\nPREENCHA AS INFORMAÇÕES PARA REALIZAR O CADASTRO");
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String lastname = scanner.nextLine();
        System.out.print("Data de nascimento: ");
        String birthDate = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        this.client = new Client(name,lastname,birthDate,cpf);
        new ClientService().registerCustomer(this.client);
    }

    public void criarConta(String type){
        Account account = null;
        switch (type){
            case "p" -> account = new SavingsAccount(this.client);
            case "c" -> account = new CurrentAccount(this.client);
        }
        new AccountService().registerAccount(account);
    }

    public Account buscarConta(String number){
        Account ac = new AccountService().findByNumber(number);
        this.account = ac;
        return ac;
    }

    public void depositar() throws Exception {
        System.out.print("Informe o valor do depósito: ");
        double valor = scanner.nextDouble();
        account.deposit(valor);
        new AccountService().updateBalance(this.account);
    }

    public void sacar() throws Exception {
        System.out.print("Informe o valor do depósito: ");
        double valor = scanner.nextDouble();
        account.withdraw(valor);
        new AccountService().updateBalance(this.account);
    }
    public void transferir () throws Exception {
        System.out.print("Informe o n° da conta do destinatário: ");
        String numAc = scanner.nextLine();
        Account dest = new AccountService().findByNumber(numAc);

        if(dest != null){
            System.out.print("Informe o valor da transferência: ");
            double valor = scanner.nextDouble();
            account.transfer(dest, valor);
        }

        new AccountService().updateBalance(account);
        new AccountService().updateBalance(dest);
    }

    public void consultarSaldo(){
        Locale ptBr = new Locale("pt", "BR");
        System.out.println("Saldo: " +
                NumberFormat.getCurrencyInstance(ptBr).format(account.getBalance())
        );
    }

    public void gerarExtrato() throws DocumentException, IOException {
        new FacadePDF(account);
    }

    public void enviarExtrato() {
        System.out.print("Informe o seu email: ");
        EmailConfig.recipient = scanner.next();
        new FacadeEMAIL().submitAt();
    }

    public void registerLogs(){
        new LogService().registerLogs(account.getHistoryLogs());
    }
}
