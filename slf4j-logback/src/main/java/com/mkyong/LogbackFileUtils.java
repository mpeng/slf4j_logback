package com.mkyong;

import ch.qos.logback.classic.Level;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;

class LogbackFileUtils {

  public static final String MY_LOGGER = "MY_LOGGER";
  public static final String ICMS = "ICMS_BATCH";
  private static FileAppender<ILoggingEvent> fileAppender;
  private static boolean initialized = false;

  private org.slf4j.Logger logger;

  LogbackFileUtils(org.slf4j.Logger logger) {
    this.logger = logger;
  }

  public static void init() {
    if (!initialized) {
      LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
      Logger myLogger = loggerContext.getLogger(MY_LOGGER);
      org.slf4j.Logger icmsLogger = LoggerFactory.getLogger(ICMS); //loggerContext.getLogger(ICMS);
      System.out.println( "========================myLogger======" + myLogger );
      System.out.println( "========================icmsLogger======" + icmsLogger );

      PatternLayoutEncoder encoder = new PatternLayoutEncoder();
      encoder.setContext(loggerContext);
      encoder.setPattern("%d{HH:mm:ss.SSS} [%-5level] %msg %n");
      encoder.start();

      fileAppender = new FileAppender<ILoggingEvent>();
      fileAppender.setContext(loggerContext);
      fileAppender.setName("MY_FILE_LOGGER");
      fileAppender.setAppend(true);
      fileAppender.setEncoder(encoder);
      myLogger.addAppender(fileAppender);
      myLogger.setLevel(Level.ALL);

      initialized = true;
    }
  }

  public static void start(String filePath) {
    init();
    stop();
    fileAppender.setFile(filePath);
    fileAppender.start();
  }

  public static void stop() {
    if (fileAppender.isStarted()) {
      fileAppender.stop();
    }
  }
}