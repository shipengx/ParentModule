package com.shipeng.Thread.PrintEvenOdd;

/**
 * 
 * @author sxu
 * 
 * Create two threads, one print even, one print odd numbers.
 * Two threads were synchronized by a "Printer" object.
 * Odd thread calls "printer" object's printOdd() method.
 * Even thread calls "printer" object's printEven() method.
 *
 */

public class PrintEvenOddTester {
	
	public static void main(String[] args) {
		Printer print = new Printer();
		Thread t1 = new Thread(new TaskEvenOdd(print, 10, false));
		Thread t2 = new Thread(new TaskEvenOdd(print, 10, true));
		t1.start();
		t2.start();
		
	}
	
}
