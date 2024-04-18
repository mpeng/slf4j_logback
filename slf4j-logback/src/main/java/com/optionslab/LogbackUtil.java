package com.optionslab;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;


public class LogbackUtil {

  FileAppender fileAppender;
  Logger logbackLogger;

  public void test() {
    Logger logbackLogger = getLogger(HelloWorld.class);
    setFileName("ABC3");
  }

  public void setFileName(String logName) {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    this.fileAppender = (FileAppender)loggerContext.getLogger("ICMS_BATCH").getAppender("FILE");
    this.fileAppender.setFile(logName);
    this.fileAppender.start();
    this.logbackLogger.addAppender(this.fileAppender);

  }

  public Logger getLogger(Class<?> obj) {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    this.logbackLogger = loggerContext.getLogger(obj);
    //this.logbackLogger.setLevel(Level.ALL);
    this.logbackLogger.addAppender(loggerContext.getLogger("ICMS_BATCH").getAppender("ASYNC"));
    return this.logbackLogger;
  }



  public void setFileAppender(String logName) {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

    //loggerContext.getLogger("ICMS_BATCH").getAppender("FILE");
    this.fileAppender = new FileAppender();
    this.fileAppender.setContext(loggerContext);
    //this.fileAppender.setName("timestamp");
    // set the file name
    System.out.println( "Appender name = " + loggerContext.getLogger("ICMS_BATCH").getAppender("FILE") );
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
