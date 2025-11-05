package com.app.process;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TransferProcessor {

    public static void main(String[] args) {
        String fileName = "transfers.txt"; 
        double totalHDFCPaid = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 11) { 
                    System.out.println("Invalid record: " + line);
                    continue;
                }

                // Sender details
                Account sender = new Account(
                        data[0],                         // Name
                        data[1],                         // Country
                        Long.parseLong(data[2]),         // Account No
                        data[3],                         // IFSC
                        Double.parseDouble(data[4])      // Balance
                );

                double transferAmount = Double.parseDouble(data[5]);
                String transferType = data[6];

                // Receiver details (initial balance = 0)
                Account receiver = new Account(
                        data[7],
                        data[8],
                        Long.parseLong(data[9]),
                        data[10],
                        0
                );

                // Transfer rules
                if (transferAmount <= 0) {
                    System.out.println("Invalid transfer amount: " + transferAmount + " for " + sender.accountHolderName);
                    continue;
                }

                if (sender.balance < transferAmount) {
                    System.out.println("Insufficient balance for " + sender.accountHolderName);
                    continue;
                }

                // Process transaction
                sender.balance -= transferAmount;
                receiver.balance += transferAmount;

                System.out.println("Transferred " + transferAmount + " from " + sender.accountHolderName +
                        " to " + receiver.accountHolderName + " (" + transferType + ")");

                // Track HDFC payments
                if (sender.ifscCode.startsWith("HDFC")) {
                    totalHDFCPaid += transferAmount;
                }
            }

            System.out.println("\nTotal amount paid by HDFC Bank: ₹" + totalHDFCPaid);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
