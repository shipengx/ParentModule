package com.shipeng.Thread.ProducerConsumer;

public class ProducerConsumerTest {
	
	public static void main(String[] args) {
		MyLock lock = new MyLock();
		Producer p1 = new Producer(lock, 1);
		Consumer c1 = new Consumer(lock, 1);
		p1.start();
		c1.start();
	}
	
}
