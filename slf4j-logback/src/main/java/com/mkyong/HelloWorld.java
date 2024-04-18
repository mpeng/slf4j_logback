package com.mkyong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {

    private final Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    private static Logger myLogger = LoggerFactory.getLogger(LogbackFileUtils.MY_LOGGER);
    private static Logger icmsLogger = LoggerFactory.getLogger(LogbackFileUtils.ICMS);

    public static void main(String[] args) {


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



        new HelloWorld().logger.debug("Hello from Logback");

        //while (true)//test rotate file
        new HelloWorld().logger.debug("getNumber() : {}", getNumber());


        new HelloWorld().logger.trace("This is a TRACE message.");
        new HelloWorld().logger.debug("This is a DEBUG message.");
        new HelloWorld().logger.info("This is an INFO message.");
        new HelloWorld().logger.warn("This is a WARN message.");
        new HelloWorld().logger.error("This is an ERROR message.", new RuntimeException("Sample Exception"));

        // Using parameterized logging
        String name = "John";
        int age = 30;
        new HelloWorld().logger.info("User {} is {} years old.", name, age);

    }

    static int getNumber() {
        return 5;
    }

}
