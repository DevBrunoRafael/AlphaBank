package App.Client;

import App.Entities.Accounts.Account;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Intermediation inter = new Intermediation();

        boolean rd1 = true;

        while (rd1){
            System.out.println("""
                     TECH BANK
                     
            (1) Abrir conta
            (2) Acessar conta
            (3) Administrador
            (4) Sair""");
            String op1 = scanner.nextLine();

            switch (op1){
                case "1" -> {
                    System.out.println("""
                                  Tipo da conta
                            1- Poupança  2- Corrente""");
                    String op3 = scanner.nextLine();

                    inter.registarCliente();
                    inter.criarConta(op3);
                }
                case "2" -> {
                    System.out.print("Informe o número da conta: ");
                    String numAc = scanner.nextLine();
                    Account account = inter.buscarConta(numAc);

                    if(account != null){

                        boolean rd2 = true;
                        while (rd2){

                            System.out.println(" Olá, " + account.getClient().getName());
                            System.out.println("""
                            (1) Operações
                            (2) Alterar dados conta
                            (3) consultar saldo
                            (4) Histórico de transações
                            (5) Sair""");
                            String op2 = scanner.next();

                            switch (op2){
                                case "1" ->{
                                    boolean rd3 = true;
                                    while (rd3){
                                        System.out.println("""
                                        \n(1) Depósito
                                        (2) Saque
                                        (3) Transferência
                                        (4) Voltar""");
                                        String op3 = scanner.next();

                                        switch (op3) {
                                            case "1" -> inter.depositar();
                                            case "2" -> inter.sacar();
                                            case "3" -> inter.transferir();
                                            case "4" -> rd3 = false;
                                            default -> System.out.println("Opção inválida!");
                                        }
                                    }
                                }
                                case "2" ->
                                    System.out.println("Implementar...");

                                case "3" -> inter.consultarSaldo();

                                case "4" -> {
                                    scanner.nextLine();
                                    System.out.println("1- imprimir     2- enviar por email");
                                    String op4 = scanner.nextLine();

                                    switch (op4){
                                        case "1" -> inter.gerarExtrato();
                                        case "2" -> inter.enviarExtrato();
                                        default -> System.out.println("Opção inválida");
                                    }
                                }

                                case "5" -> {
                                    scanner.nextLine();
                                    inter.registerLogs();
                                    rd2 = false;
                                }
                                default -> System.out.println("Opção inválida!");
                            }
                        }
                    } else System.out.println("Conta não encontrada!");
                }
                case "3" ->
                    System.out.println("implementar...");

                case "4" -> rd1 = false;

                default -> System.out.println("Opção inválida!");

            }
        }



//        // adm
//        System.out.println("(0) Buscar conta"); // select
//        System.out.println("(0) Listar contas");
//        System.out.println("(0) excluir contas"); // delete
//        System.out.println("(0) render juros");
//        System.out.println("(0) aumentar limite");
//
//         organizar classe de email
    }

}
