package App.Client;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.AccountTypes.currentAccount;
import App.Entities.Accounts.AccountTypes.savingsAccount;


public class Main {
    public static void main(String[] args) throws Exception {


//        // testes
//
//        Account account1 = new savingsAccount(
//                new Client("Bruno Rafael Nascimento dos Santos","Sobrenome","20/09/200","09242681580")
//        );
//        Account account2 = new savingsAccount(
//                new Client("Nilton César","Sobrenome","20/09/200","09242681580")
//        );
//        account2.deposit(200);
//        account1.deposit(100);
//        account2.transfer(account1,37.6);
//        account1.withdraw(50);
//        account1.deposit(300);
//        account1.deposit(425);
//        account1.withdraw(150);
//        account1.withdraw(150);
//        account1.withdraw(13.41);
//        account1.deposit(400);
//        account1.deposit(500);
//        account1.transfer(account2, 21.90);
//        account2.transfer(account1, 23.50);
//        account1.withdraw(127);
//        account1.withdraw(117);
//        account1.withdraw(147);


        //new FacadePDF(account1);
        //new FacadeEMAIL().submitAt();

        Account act1 = new currentAccount(MethodsAux.registerCustomer());
        Account act2 = new savingsAccount(MethodsAux.registerCustomer());


//        // user
//        System.out.println("(1) Abrir conta"); // insert
//
//
//        System.out.println("(3) Acessar conta"); // select
//        System.out.println("(1) Operações"); // update
//        System.out.println("(1) Depósito");
//        System.out.println("(2) Saque");
//        System.out.println("(3) Transferência");
//        System.out.println("(4) consultar saldo");
//        System.out.println("(2) Alterar dados conta");
//        System.out.println("(3) Histórico de transações");
//        System.out.println("(1) download    (2) enviar por email");
//
//
//        // adm
//        System.out.println("(0) Buscar conta"); // select
//        System.out.println("(0) Listar contas");
//        System.out.println("(0) excluir contas"); // delete
//        System.out.println("(0) render juros");
//        System.out.println("(0) aumentar limite");

        // organizar classe de email
    }

}
