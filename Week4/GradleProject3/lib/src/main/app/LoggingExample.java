package _GradleProject3;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingExample {
    private static final Logger logger = LogManager.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.info("App started successfully");
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            logger.error("Division failed!", e);
        }
        logger.warn("This is a warning message");
        logger.info("App finished");
    }
}
