package LL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingApp {

    // 1. Get a logger instance, usually by using the current class name
    private static final Logger logger = LogManager.getLogger(LoggingApp.class);

    public static void main(String[] args) {
        // Log messages at different severity levels
        logger.info("Application started successfully.");
        
        try {
            int result = 10 / 0; // This will throw an ArithmeticException
        } catch (ArithmeticException e) {
            // 2. Log an error, often including the exception stack trace
            logger.error("An expected critical error occurred during calculation!", e);
        }

        // 3. Log a warning about a non-critical but important issue
        logger.warn("Configuration file not found. Using default settings.");

        logger.info("Application finished.");
    }
}