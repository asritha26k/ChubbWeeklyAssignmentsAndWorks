package com.app.logsstreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogParserApp {

    public static void main(String[] args) {
        String logFile = "logs.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            System.out.println("==== ERROR Logs ====");
            br.lines()
                .filter(line -> line.contains("ERROR"))
                .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            System.out.println("\n==== INFO Logs ====");
            br.lines()
                .filter(line -> line.contains("INFO"))
                .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            System.out.println("\n==== WARN Logs ====");
            br.lines()
                .filter(line -> line.contains("WARN"))
                .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
