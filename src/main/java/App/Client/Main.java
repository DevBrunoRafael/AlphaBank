package App.Client;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.AccountTypes.currentAccount;
import App.Entities.Customer.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);



        boolean rodando = true;
        while (rodando){


            System.out.println("Abrir Conta");
            String op = input.nextLine();
            switch (op) {
                case "1" -> {
                    System.out.print("Informe o nome: ");
                    String nome = input.nextLine();
                    System.out.print("Informe o sobrenome: ");
                    String sobrenome = input.nextLine();
                    System.out.print("Informe a idade: ");
                    int idade = input.nextInt();
                    input.next();
                    System.out.print("Informe o cpf: ");
                    String cpf = input.nextLine();

                    Account account = new currentAccount(new Client(nome,sobrenome,idade,cpf));
                    System.out.println(account);

                }
                case "2" -> {
                    rodando = false;
                }
                default -> System.out.println("Opção inválida");
            }
        }


    }
}
