package LL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Assuming this is part of the LoggingTest class
public class LoggingTest { 
    
    private static final Logger logger = LogManager.getLogger(LoggingTest.class);

    public static void main(String[] args) {
        
        logger.debug("testing logging statemenys"); 
        logger.trace("Trace Message - Verbose details for debugging");
        logger.debug("Debug Message - For developer analysis");
        logger.info("Info Message - Normal flow information");
        logger.warn("Warning Message - Something might be off");
        logger.error("Error Message - Something failed");
        logger.fatal("Fatal Message - Critical system failure");

        int i = 10 / 0; // This line will not execute successfully; likely causes an exception

        try {
            String name = null;
            name.toLowerCase(); // This will throw a NullPointerException
        } catch(Exception ex) {
            // The image shows an overly complex and likely incorrect logger.error call 
            // We will use a standard, correct logging pattern here:
            logger.error("An exception occurred during processing.", ex);
            
            // The exact, overly verbose call shown in the image is:
            // logger.error(null, null, ex, ex, ex, ex, ex, ex, args, ex); 
        }
    }
}