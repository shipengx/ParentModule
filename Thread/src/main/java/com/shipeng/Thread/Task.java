package com.shipeng.Thread;

import java.util.Date;

public class Task implements Runnable {
	private String name;
	
	public Task(String name) {
		this.name = name;
	}
		
	public String getName() {
		return name;
	}
	
	public void run() {
		try {
			System.out.println("Doing a task during: " + name + " - time - " + new Date());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
