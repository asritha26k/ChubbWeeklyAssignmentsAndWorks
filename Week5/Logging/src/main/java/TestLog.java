
import org.apache.log4j.Logger;


public class TestLog {
    private static final Logger logger = Logger.getLogger(TestLog.class);

    public static void main(String[] args) {
       
        logger.info("This is INFO log");
        logger.warn("This is WARNING");
        logger.error("This is ERROR");
    }
}
