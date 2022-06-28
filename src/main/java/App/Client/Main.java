package App.Client;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.AccountTypes.savingsAccount;
import App.Entities.Accounts.BankStatement.PDF.ExtractFacade;
import App.Entities.Customer.Client;


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
        account1.withdraw(150);
        account1.withdraw(13.41);
        account1.deposit(400);
        account1.deposit(500);
        account1.transfer(account2, 21.90);
        account2.transfer(account1, 23.50);
        account1.withdraw(127);
        account1.withdraw(117);
        account1.withdraw(147);


        new ExtractFacade(account1);

    }

}
