package com.shipeng.Thread.ProducerConsumer;

public class Consumer extends Thread {
	private MyLock lock;
	private int number;
	
	public Consumer(MyLock lock, int number) {
		this.lock = lock;
		this.number = number;
	}
	
	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			value = lock.get();
			System.out.println("Consumer #" + this.number + " got: " + value);
		}
	}
	
}
