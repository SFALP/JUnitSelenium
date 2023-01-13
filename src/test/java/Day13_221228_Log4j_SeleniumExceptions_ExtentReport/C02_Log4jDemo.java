package Day13_221228_Log4j_SeleniumExceptions_ExtentReport;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class C02_Log4jDemo {

    public static void main(String[] args) {

        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(C02_Log4jDemo.class.getName());

        logger.trace("Trace");
        logger.debug("Debug");
        logger.info("Info");
        logger.warn("Warn");
        logger.error("Error");
        logger.fatal("Fatal");

    }
}