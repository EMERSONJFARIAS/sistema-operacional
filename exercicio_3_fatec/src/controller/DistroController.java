package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistroController {
    private static String os() {
        return System.getProperty("os.name");
    }

    public static void exibeDistro() {
        String osName = os();

        if (osName.startsWith("Linux")) {
            try {
                Process process = Runtime.getRuntime().exec("cat /etc/os-release");
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("NAME")) {
                        String[] parts = line.split("=");
                        System.out.println("Nome da distribuição: " + parts[1].replaceAll("\"", ""));
                    } else if (line.startsWith("VERSION")) {
                        String[] parts = line.split("=");
                        System.out.println("Versão da distribuição: " + parts[1].replaceAll("\"", ""));
                    }
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Este programa só funciona em sistemas Linux.");
        }
    }
}
