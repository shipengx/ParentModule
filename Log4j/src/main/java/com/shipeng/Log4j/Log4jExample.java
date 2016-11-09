package com.shipeng.Log4j;

import org.apache.log4j.Logger;

public class Log4jExample {
	
		final static Logger logger = Logger.getLogger(Log4jExample.class);
		
		public static void main(String[] args) {
			
			Log4jExample l1 = new Log4jExample();
			try {
				l1.divide();
			} catch (ArithmeticException ex) {
				logger.error("[Log4jExample.main] - Divide by zero exception.", ex);
			}
			
		}//end main
			
		private void divide() {
			int i = 10 / 0;
			System.out.println("i = " + i);
		}
	
	
} //end class Log4jUtil
