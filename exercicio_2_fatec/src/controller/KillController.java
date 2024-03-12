package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
    private static String os() {
        return System.getProperty("os.name").toLowerCase();
    }
    public static void listaProcessos() {
        try {
            String command;
            if (os().contains("win")) {
                command = "TASKLIST /FO TABLE";
            } else {
                command = "ps -ef";
            }
            Process process = Runtime.getRuntime().exec(command);
            printProcessOutput(process.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mataPid(int pid) {
        try {
            String command;
            if (os().contains("win")) {
                command = "TASKKILL /PID " + pid;
            } else {
                command = "kill -9 " + pid;
            }
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            System.out.println("Kill Process: " + pid + " with success" );
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void mataNome(String nomeProcesso) {
        try {
            String command;
            if (os().contains("win")) {
                command = "TASKKILL /IM " + nomeProcesso;
            } else {
                command = "pkill -f " + nomeProcesso;
            }
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printProcessOutput(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
