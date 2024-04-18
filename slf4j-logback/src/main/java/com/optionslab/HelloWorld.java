package com.optionslab;

//import org.slf4j.Logger;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {

    private static final Logger logger = new LogbackUtil().getLogger(HelloWorld.class);
    //private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    //private static Logger myLogger = LoggerFactory.getLogger(LogbackFileUtils.MY_LOGGER);
    //private static Logger icmsLogger = LoggerFactory.getLogger(LogbackFileUtils.ICMS);

    public static void main(String[] args) {

        //new LogbackUtil().test();

        //icmsLogger.info( "Welcome" );
        //icmsLogger.debug( "From ICMS Logger");

        /*
        System.setProperty("log.name",
          "C:\\Work\\PCAICMSBATCH\\ICMS_Batch\\business_processes\\qa2\\temp\\himrk_daily_incoming_15p20230923.09-23-2023_0503.03-27-2024_1004_qa2_java_log.2");

        icmsLogger.info( "Welcome" );
        LogbackFileUtils.start("first.log");
        myLogger.info("1st file - This is an info message");
        myLogger.debug("1st file - This is a debug message");
        myLogger.error("1st file - This is an error message");
        LogbackFileUtils.stop();

        LogbackFileUtils.start("second.log");
        myLogger.info("2nd file - This is an info message");
        myLogger.debug("2nd file - This is a debug message");
        myLogger.error("2nd file - This is an error message");
        LogbackFileUtils.stop();
        */

        new LogbackUtil().setFileName( "ABCD", logger );

        logger.debug("Hello from Logback");
        logger.debug("getNumber() : {}", getNumber());
        logger.trace("This is a TRACE message.");
        logger.debug("This is a DEBUG message.");
        logger.info("This is an INFO message.");
        logger.warn("This is a WARN message.");
        logger.error("This is an ERROR message.", new RuntimeException("Sample Exception"));
        String name = "John";
        int age = 30;
        logger.info("User {} is {} years old.", name, age);

    }

    static int getNumber() {
        return 5;
    }

}
