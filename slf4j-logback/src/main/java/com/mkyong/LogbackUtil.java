package com.mkyong;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;


public class LogbackUtil {

  public void test() {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

    FileAppender fileAppender = new FileAppender();
    fileAppender.setContext(loggerContext);
    fileAppender.setName("timestamp");
    // set the file name
    fileAppender.setFile("log/" + System.currentTimeMillis()+".log");

    PatternLayoutEncoder encoder = new PatternLayoutEncoder();
    encoder.setContext(loggerContext);
    encoder.setPattern("%r %thread %level - %msg%n");
    encoder.start();

    fileAppender.setEncoder(encoder);
    fileAppender.start();

    // attach the rolling file appender to the logger of your choice
    Logger logbackLogger = loggerContext.getLogger("icms");
    logbackLogger.addAppender(fileAppender);

    // log something
    logbackLogger.debug("hello");
  }

  public Logger getLogger() {
    return null;
  }
}
