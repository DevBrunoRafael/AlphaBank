package App.Client;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.AccountTypes.currentAccount;
import App.Entities.Accounts.AccountTypes.savingsAccount;
import App.Entities.Accounts.BankStatement.ExtractLog;
import App.Entities.Accounts.TypeOperations;
import App.Entities.Customer.Client;


public class Main {
    public static void main(String[] args) throws Exception {


        Account account1 = new currentAccount(
                new Client("Bruno","Rafael","20/09/200","09242681580")
        );

        Account account2 = new currentAccount(
                new Client("Rafael","Santos","20/04/1999","09994578032")
        );

        account1.setSaldo(2000);
        ((currentAccount) account1).setLimite(1000);
        account2.setSaldo(200);

        account1.transfer(account2, 2300);
        account1.withdraw(650);
        account1.withdraw(650);
        System.out.println(((currentAccount) account1).getLimite());


        System.out.println(account1);
        System.out.println("");
        System.out.println(account2);
        System.out.println("");








    }
}
