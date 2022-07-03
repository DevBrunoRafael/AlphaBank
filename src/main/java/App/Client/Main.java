package App.Client;

import App.Components.GeneratePDFs.FacadePDF;
import App.Components.SendingEmails.FacadeEMAIL;
import App.Entities.Accounts.Account;
import App.Entities.Accounts.AccountTypes.currentAccount;
import App.Entities.Accounts.AccountTypes.savingsAccount;
import App.Entities.Customer.Client;
import App.repository.ClientRepository;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        boolean rd1 = true;
//        Client c1 = new Client("Bruno","Rafael", "20/09/2002", "092.426.815-80");
//        System.out.println(ClientRepository.Insert(c1));

//        System.out.println(ClientRepository.Search("092.426.815-80"));




//        while (rd1){
//            System.out.println("\n\tTECH BANK");
//            System.out.println("""
//            (1) Abrir conta
//            (2) Acessar conta
//            (3) Administrador
//            (4) Sair""");
//            String op1 = scanner.nextLine();
//
//            switch (op1){
//                case "1" -> {
//                    System.out.println("""
//                            \tTipo da conta
//                            1- Poupança  2- Corrente""");
//                    String op3 = scanner.nextLine();
//
//                    Account ac = null;
//                    switch (op3){
//                        case "1" -> ac = new savingsAccount(MethodsAux.registerCustomer());
//                        case "2" -> ac = new currentAccount(MethodsAux.registerCustomer());
//
//                        default -> System.out.println("Opção Inválida!");
//                    }
//                    MethodsAux.insert(ac);
//                    System.out.println(ac);
//                }
//                case "2" -> {
//                    System.out.print("Informe o número da conta: ");
//                    String numAc = scanner.nextLine();
//                    Account ac = MethodsAux.select(numAc);
//
//                    if(ac != null){
//
//                        boolean rd2 = true;
//                        while (rd2){
//
//                            System.out.println("Olá, " + ac.getClient().getName());
//                            System.out.println("""
//                            (1) Operações
//                            (2) Alterar dados conta
//                            (3) consultar saldo
//                            (4) Histórico de transações
//                            (5) Sair""");
//                            String op2 = scanner.next();
//
//                            switch (op2){
//                                case "1" ->{
//                                    boolean rd3 = true;
//                                    while (rd3){
//                                        System.out.println("""
//                                        \n(1) Depósito
//                                        (2) Saque
//                                        (3) Transferência
//                                        (4) Voltar""");
//                                        String op3 = scanner.next();
//
//                                        switch (op3){
//                                            case "1" -> {
//                                                System.out.print("Valor: ");
//                                                double valor = scanner.nextDouble();
//                                                ac.deposit(valor);
//                                            }
//                                            case "2" -> {
//                                                System.out.print("Valor: ");
//                                                double valor = scanner.nextDouble();
//                                                ac.withdraw(valor);
//                                            }
//                                            case "3" -> {
//                                                scanner.nextLine();
//                                                System.out.print("Informe o destinatário: ");
//                                                String numAcc = scanner.nextLine();
//                                                Account dest = MethodsAux.select(numAcc);
//
//                                                if(dest != null){
//                                                    System.out.print("Valor: ");
//                                                    double valor = scanner.nextDouble();
//                                                    ac.transfer(dest,valor);
//
//                                                } else System.out.println("Destinatário não encontrado!");
//                                            }
//
//                                            case "4" -> rd3 = false;
//                                            default -> System.out.println("Opção inválida!");
//                                        }
//                                    }
//                                }
//                                case "2" -> {
//                                    System.out.println("Implementar...");
//                                }
//                                case "3" -> {
//                                    Locale ptBr = new Locale("pt", "BR");
//                                    System.out.println("Saldo: " +
//                                                    NumberFormat.getCurrencyInstance(ptBr).format(ac.getBalance())
//                                            );
//                                }
//                                case "4" -> {
//                                    scanner.nextLine();
//                                    System.out.println("1- imprimir     2- enviar por email");
//                                    String op4 = scanner.nextLine();
//
//                                    switch (op4){
//                                        case "1" -> new FacadePDF(ac);
//                                        case "2" -> new FacadeEMAIL().submitAt();
//                                        default -> System.out.println("Opção inválida");
//                                    }
//                                }
//
//                                case "5" -> {
//                                    scanner.nextLine();
//                                    rd2 = false;
//                                }
//                                default -> System.out.println("Opção inválida!");
//                            }
//                        }
//                    } else System.out.println("Conta não encontrada!");
//                }
//                case "3" -> {
//                    System.out.println("implementar...");
//                }
//                case "4" -> rd1 = false;
//
//                default -> System.out.println("Opção inválida!");
//
//            }
//        }



//        // adm
//        System.out.println("(0) Buscar conta"); // select
//        System.out.println("(0) Listar contas");
//        System.out.println("(0) excluir contas"); // delete
//        System.out.println("(0) render juros");
//        System.out.println("(0) aumentar limite");

        // organizar classe de email
    }

}
