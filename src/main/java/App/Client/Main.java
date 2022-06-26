package App.Client;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.AccountTypes.currentAccount;
import App.Entities.Accounts.AccountTypes.savingsAccount;
import App.Entities.Accounts.BankStatement.ExtractLog;
import App.Entities.Accounts.BankStatement.PDF.ExtractPDF;
import App.Entities.Accounts.TypeOperations;
import App.Entities.Customer.Client;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {


        // testes


        Account account1 = new savingsAccount(
                new Client("Bruno Rafael Nascimento dos Santos","Sobrenome","20/09/200","09242681580")
        );
        Account account2 = new savingsAccount(
                new Client("Nilton César","Sobrenome","20/09/200","09242681580")
        );
        account2.deposit(200);
        account1.deposit(100);
        account2.transfer(account1,37.6);
        account1.withdraw(50);
        account1.deposit(300);
        account1.deposit(425);
        account1.withdraw(150);
        account1.deposit(400);
        account1.deposit(400);
        account1.transfer(account2, 50);


//        List<ExtractLog> logs = account2.getHistLogs();
//
//        for (ExtractLog log: logs) {
//            System.out.println(log.getSender_receiver());
//        }

        //System.out.println(account1.getHistLogs());

        ExtractPDF extrato = new ExtractPDF(account1, account1.getHistLogs());
        extrato.header();
        extrato.body2();
        extrato.footer();
        extrato.printOut();










//        Account account1 = new savingsAccount(
//                new Client("Bruno","Rafael","20/09/200","09242681580")
//        );
//
//        Account account2 = new currentAccount(
//                new Client("Rafael","Santos","20/04/1999","09994578032")
//        );
//
//
//        Account account3 = new savingsAccount(
//                new Client("Maria","Santos","20/04/1999","09994578032")
//        );
//
//        Account account4 = new currentAccount(
//                new Client("Joana","Santos","20/04/1999","09994578032")
//        );
//
//
//        account1.deposit(100);
//        account1.deposit(200);
//        account1.withdraw(50);
//        // account 1 = 300 reais e 4 logs
//
//        account2.deposit(100);
//        account2.transfer(account1, 50);
//        account2.transfer(account3, 25);
//        // account 2 = 25 reais e 3 logs
//
//        // account 3 = 175 e 2 logs
//
//
//        account4.deposit(200);
//        account4.transfer(account3, 150);
//        // account 4 = 50 e 2 logs
//
//
//        System.out.println("---------------------------------1-------------------------------------------");
//        account1.generateExtract();
//        System.out.println("---------------------------------2-------------------------------------------");
//        account2.generateExtract();
//        System.out.println("---------------------------------3-------------------------------------------");
//        account3.generateExtract();
//        System.out.println("---------------------------------4-------------------------------------------");
//        account4.generateExtract();
//
//
//        System.out.println("\nValores atualizados");
//        System.out.println("Conta1: " + account1.getBalance());
//        System.out.println("Conta2: " + account2.getBalance());
//        System.out.println("Conta3: " + account3.getBalance());
//        System.out.println("Conta4: " + account4.getBalance());
//
//        ((currentAccount)account2).setLimite(1000);
//        account2.withdraw(300);
//        System.out.println(((currentAccount)account2).getLimite());




    }
}
