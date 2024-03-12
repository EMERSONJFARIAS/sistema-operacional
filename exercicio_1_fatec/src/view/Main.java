package view;

import controller.RedesController;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String[] options = {"Configurar IP", "Ping", "Sair"};
        int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Redes Controller", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                RedesController.ip();
                break;
            case 1:
                RedesController.ping();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}

