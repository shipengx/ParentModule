package com.shipeng.Thread.ClassObjectLevelLocking;

/**
 * 
 * @author sxu
 * 
 * Object Level Locking
 * Object level locking is mechanism when you want to synchronize a non-static method or non-static code block such that only one thread will be able to execute the code block on given isntance of the class.
 * this should always be done to make instance level data thread safe.
 * this can be done as below
 *
 */

class ObjectLevelLocking {
	public synchronized void demoMethod() {
		
	}
}


class DemoClass {
	public void demoMethod() {
		synchronized(this) {
			// other thread safe code
		}
	}
}


