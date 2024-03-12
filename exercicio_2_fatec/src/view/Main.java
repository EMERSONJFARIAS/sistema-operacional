package view;

import controller.KillController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Selecione a opção:");
            System.out.println("1 - Listar Processos");
            System.out.println("2 - Matar por PID");
            System.out.println("3 - Matar por Nome");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    KillController.listaProcessos();
                    break;
                case 2:
                    System.out.println("Digite o PID do processo que deseja matar:");
                    int pid = scanner.nextInt();
                    KillController.mataPid(pid);
                    break;
                case 3:
                    System.out.println("Digite o nome do processo que deseja matar:");
                    scanner.nextLine(); // limpa o buffer
                    String nomeProcesso = scanner.nextLine();
                    KillController.mataNome(nomeProcesso);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        scanner.close();
    }
}