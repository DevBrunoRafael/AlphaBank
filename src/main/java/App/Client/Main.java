package App.Client;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.AccountTypes.currentAccount;
import App.Entities.Accounts.AccountTypes.savingsAccount;
import App.Entities.Accounts.BankStatement.ExtractLog;
import App.Entities.Accounts.TypeOperations;
import App.Entities.Customer.Client;


public class Main {
    public static void main(String[] args) throws Exception {


        Account account1 = new savingsAccount(
                new Client("Bruno","Rafael","20/09/200","09242681580")
        );

        Account account2 = new savingsAccount(
                new Client("Rafael","Santos","20/04/1999","09994578032")
        );
        account2.deposit(500);
        account2.transfer(account1, 300);


        account1.deposit(200);
        account1.deposit(300);
        account1.withdraw(400);
        account1.deposit(100);



        account1.generateExtract();
        System.out.println("==================================================================");
        account2.generateExtract();
//        account1.transfer(account2, 150);
//
//        System.out.println(account1.getSaldo());// 50
//        System.out.println(account2.getSaldo());// 150





//        System.out.println(account1);
//        System.out.println("");
//        System.out.println(account2);
//        System.out.println("");











    }
}
