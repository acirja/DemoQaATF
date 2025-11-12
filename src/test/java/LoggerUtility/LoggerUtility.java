package LoggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    //trebuie sa definim o instanta de logger
    //trebuie sa definim o metoda care sa porneasca un test
    //trebuie sa definim o metoda care sa opresca un test
    //metoda de info, metoda de error

    private static final Logger logger = LogManager.getLogger(); //instanta care va tine info de care am nevoie

    public static void startTestCase(String testName){
        logger.info("****** Execution started: " + testName + " ******" );
    }

    public static void finishTestCase(String testName){
        logger.info("****** Execution finished: " + testName + " ******" );
    }

    public static void infoTest(String message){
        logger.info(message);
    }

    public static void errorTest(String message){
        logger.error(message);
    }
}
