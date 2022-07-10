package App.Client;

import App.Components.GeneratePDFs.ConstantsPDF;
import App.Components.GeneratePDFs.FacadePDF;
import App.Components.SendingEmails.FacadeEMAIL;
import App.Components.SendingEmails.Models.EmailConfig;
import App.Entities.Accounts.Account;
import App.Entities.Accounts.AccountTypes.SavingsAccount;
import App.Entities.Customer.Client;

import java.io.File;

public class MainAux {
    public static void main(String[] args) throws Exception {

//        Account ac = new SavingsAccount(
//                new Client("Bruno", "Rafael", "20/09/2022", "09242681580")
//        );
//        ac.deposit(100);
//        ac.deposit(200);
//        ac.deposit(300);
//        ac.deposit(400);
//        ac.deposit(500);
//        System.out.println(ac);
//        new FacadePDF(ac);

        EmailConfig.fileLocation = new File(ConstantsPDF.directory("1508014-03"));
        new FacadeEMAIL().submitAt();

    }
}
