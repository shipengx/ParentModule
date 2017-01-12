package com.shipeng.Thread.PrintEvenOdd;

public class TaskEvenOdd implements Runnable {
	
	private int max;
	private Printer print;
	private boolean isEvenNumber;
	
	TaskEvenOdd(Printer print, int max, boolean isEvenNumber) {
		this.print = print;
		this.max = max;
		this.isEvenNumber = isEvenNumber;
	}
	
	public void run() {
		
		//System.out.println("Run method");
		int number = isEvenNumber == true ? 2 : 1;
		while (number <= max) {
			if (isEvenNumber) {
				print.printEven(number);
			}else {
				print.printOdd(number);
			}
			number += 2;
		}//end while
	}
	
}
