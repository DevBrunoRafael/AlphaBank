package App.Client;

import App.Entities.Accounts.Account;
import App.Entities.Customer.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class MethodsAux {

    static Scanner scanner =  new Scanner(System.in);

    public static List<Account> accounts = new ArrayList<>();

    public static Client registerCustomer(){

        System.out.println("\nPREENCHA AS INFORMAÇÕES PARA REALIZAR O CADASTRO");
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String lastname = scanner.nextLine();
        System.out.print("Data de nascimento: ");
        String birthDate = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        return new Client(name,lastname, birthDate, cpf);
    }

    public static void insert(Account account){
        accounts.add(account);
    }

    public static Account select(String numAccount){

        Account account = null;

        for (Account ac: accounts) {
            if(ac.getNumAccount().equals(numAccount)) account = ac;
        }
        return account;
    }

    public static void delete(String numAccount){

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getNumAccount().equals(numAccount)){
                accounts.remove(i);
                break;
            }
        }
    }

    public static Account update(){
        return null;
    }
}
