package com.optionslab;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.AsyncAppender;
import org.slf4j.LoggerFactory;


public class LogbackUtil {

  public static final String ICMS_BATCH_LOGGER = "ICMS_BATCH";
  public static final String FILE_APPENDER = "FILE";
  public static final String ASYNC_APPENDER = "ASYNC";

  private FileAppender fileAppender;
  private Logger logbackLogger;

  public void initialize() {
    this.logbackLogger = getLogger(HelloWorld.class);
  }

  public void setLogname(String logname) {
    setFileName(logname, logbackLogger);
  }

  public void setFileName(String logName, Logger logger) {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    this.fileAppender = (FileAppender)loggerContext.getLogger(ICMS_BATCH_LOGGER).getAppender(FILE_APPENDER);
    this.fileAppender.setFile(logName);
    this.fileAppender.start();
    logger.addAppender(this.fileAppender);
  }

  public Logger getLogger(Class<?> obj) {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    this.logbackLogger = loggerContext.getLogger(obj);
    AsyncAppender asyncAppender = (AsyncAppender)loggerContext.getLogger(ICMS_BATCH_LOGGER).getAppender(ASYNC_APPENDER);
    asyncAppender.start();
    this.logbackLogger.addAppender(asyncAppender);
    return this.logbackLogger;
  }



  public void setFileAppender(String logName) {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

    //loggerContext.getLogger(ICMS_BATCH_LOGGER).getAppender("FILE");
    this.fileAppender = new FileAppender();
    this.fileAppender.setContext(loggerContext);
    //this.fileAppender.setName("timestamp");
    // set the file name
    System.out.println( "Appender name = " + loggerContext.getLogger(ICMS_BATCH_LOGGER).getAppender(FILE_APPENDER) );
    this.fileAppender.setFile(logName);

    PatternLayoutEncoder encoder = new PatternLayoutEncoder();
    encoder.setContext(loggerContext);
    encoder.setPattern("%r %thread %level - %msg%n");
    encoder.start();

    this.fileAppender.setEncoder(encoder);
    this.fileAppender.start();
    this.logbackLogger.addAppender(this.fileAppender);
  }
}
