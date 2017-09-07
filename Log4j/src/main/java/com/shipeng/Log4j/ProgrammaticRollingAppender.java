package com.shipeng.Log4j;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.apache.log4j.RollingFileAppender;

public class ProgrammaticRollingAppender {

	private static final Logger LOG = Logger.getLogger(ProgrammaticRollingAppender.class);
	
	public static void main(String[] args) {
		
		// This is the root logger provided by log4j
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.DEBUG);
		
		// Define log pattern layout
		PatternLayout layout = new PatternLayout("%m%n");
		
		// Add console appender to root logger
		rootLogger.addAppender(new ConsoleAppender(layout));
		
		try {
			// Define file appender with layout and output log file name
			RollingFileAppender fileAppender = new RollingFileAppender(layout, "test.info.log");
			fileAppender.setBufferedIO(false);
			fileAppender.setMaxBackupIndex(1);
			fileAppender.setMaxFileSize("1MB");
			fileAppender.setThreshold(Priority.INFO);
			
			// Add the appender to root logger
			rootLogger.addAppender(fileAppender);
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		
		// let's verify our rollingAppender
	    for (int i = 0; i < 100000; i++) {
			LOG.info("haha rolling appender.");
		}
		
	}
	
}
