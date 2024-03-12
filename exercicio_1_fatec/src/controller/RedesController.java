package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedesController {

    private static String os() {
        return System.getProperty("os.name").toLowerCase();
    }

    public static void ip() {
        String osName = os();

        try {
            Process process;
            if (osName.contains("win")) {
                process = Runtime.getRuntime().exec("ipconfig");
            } else if (osName.contains("nux") || osName.contains("nix")) {
                process = Runtime.getRuntime().exec("ifconfig");
            } else {
                System.out.println("Sistema Operacional não suportado.");
                return;
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("IPv4")) {
                    String[] parts = line.split(":");
                    System.out.println(parts[0] + ": " + parts[1].trim());
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ping() {
        String osName = os();

        try {
            Process process;
            if (osName.contains("win")) {
                process = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
            } else if (osName.contains("nux") || osName.contains("nix")) {
                process = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
            } else {
                System.out.println("Sistema Operacional não suportado.");
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    String[] parts = line.split("ms", 3);
                    if (parts.length > 2) {
                        System.out.println("Tempo médio de ping: " + parts[2].split(",")[1]);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}