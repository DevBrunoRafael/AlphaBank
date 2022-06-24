package App.Client;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.AccountTypes.currentAccount;
import App.Entities.Accounts.AccountTypes.savingsAccount;
import App.Entities.Customer.Client;


public class Main {
    public static void main(String[] args) throws Exception {


        Account account1 = new currentAccount(
                new Client("Bruno","Rafael","20/09/200","09242681580")
        );

        Account account2 = new currentAccount(
                new Client("Bruno","Rafael","20/04/1999","09242681580")
        );


        System.out.println(account1);
        System.out.println("");
        System.out.println(account2);
        System.out.println("");




    }
}
