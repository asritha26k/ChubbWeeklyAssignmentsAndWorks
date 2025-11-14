package org.example;

import org.apache.log4j.Logger;
import java.io.File; 

public class App {
    private static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
    	new File("logs").mkdirs();
        logger.info("This is an info message");
        logger.error("This is an error message");
    }

    // Add this so the test can pass
    public String getGreeting() {
        return "Hello from App!";
    }
}
