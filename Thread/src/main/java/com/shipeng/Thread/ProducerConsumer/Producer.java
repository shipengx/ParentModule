package com.shipeng.Thread.ProducerConsumer;

public class Producer extends Thread {
	private MyLock lock;
	private int number;
	public Producer(MyLock lock, int number) {
		this.lock = lock;
		this.number = number;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			lock.put(i);
			System.out.println("Producer # " + this.number + " put: " + i);
			try {
				sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				
			}
		}
	}
}
