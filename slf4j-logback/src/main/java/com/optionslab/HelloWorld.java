package com.optionslab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {

    //private static final Logger logger = new LogbackUtil().getLogger(HelloWorld.class);
    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    //private static Logger myLogger = LoggerFactory.getLogger(LogbackFileUtils.MY_LOGGER);
    //private static Logger icmsLogger = LoggerFactory.getLogger(LogbackFileUtils.ICMS);

    public static void main(String[] args) {

        LogbackUtil logbackUtil = new LogbackUtil(HelloWorld.class);

        logger.debug("GO to batch log 1 only before logfile name is set");
        logger.debug("GO to batch log 1 only before logfile name is set");

        logbackUtil.setLogname("BBBB");

        logger.info("---------------START----------------");
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
        logger.info("---------------END----------------");

        logbackUtil.setLogname("CCCC");
        logger.debug("This is a CCCC DEBUG message.");
        logger.info("This is a CCCC INFO message.");
        logger.warn("This is a CCCC WARN message.");

        logbackUtil.setLogname("DDDD");
        logger.debug("This is a DDDD DEBUG message.");
        logger.info("This is a DDDD INFO message.");
        logger.warn("This is a DDDD WARN message.");

    }

    static int getNumber() {
        return 5;
    }

}
