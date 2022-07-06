package App.Client;

import App.Components.GeneratePDFs.FacadePDF;
import App.Components.SendingEmails.FacadeEMAIL;
import App.Entities.Accounts.Account;
import App.Entities.Accounts.AccountTypes.CurrentAccount;
import App.Entities.Accounts.OperationsLogs.Log;
import App.Entities.Customer.Client;
import App.repository.AccountRepository;
import App.repository.ClientRepository;
import App.repository.LogRepository;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.List;

public class MainAux {
    public static void main(String[] args) throws Exception {

//        Client c1 = new Client("Bruno","Rafael", "20/09/2002", "092.426.815-80");
//        System.out.println("Cliente: " + ClientRepository.Insert(c1));
//
//        Account ac = new CurrentAccount(c1);
//        System.out.println("Conta: " + AccountRepository.Insert(ac));
//
//        System.out.println(ac);
//        ac.deposit(200);
//        ac.withdraw(50);
//        ac.deposit(200);
//        ac.withdraw(100);
//        ac.withdraw(100);
//        ac.deposit(100);
//        ac.withdraw(100);
//
//        LogRepository.Insert(ac.getHistoryLogs());
//
//        List<Log> logs = LogRepository.Search(ac.getNumAccount());
//        logs.forEach(System.out::println);

        Account c = AccountRepository.Search("1618441-05");
        System.out.println(c);

        List<Log> logs = LogRepository.Search(c.getNumAccount());
        c.setHistoryLogs(logs);

        logs.forEach(System.out::println);

        //new FacadePDF(c);
        new FacadeEMAIL().submitAt();




    }
}
