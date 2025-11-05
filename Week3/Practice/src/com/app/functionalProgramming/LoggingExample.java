package com.app.functionalProgramming;

import java.util.Arrays;
import java.util.List;

public class LoggingExample {
    public static void main(String[] args) {
        List<String> logs = Arrays.asList(
            "User logged in",
            "Data saved to DB",
            "Error occurred"
        );

        // Lambda way
        logs.forEach(msg -> System.out.println("[LOG] " + msg));

        // Better: Create a helper and use method reference
        logs.forEach(LoggingExample::logMessage);
    }

    static void logMessage(String message) {
        System.out.println("[LOG] " + message);
    }
}
