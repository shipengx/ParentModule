package com.shipeng.Thread.ScheduledExecutor;

import java.util.Date;

public class Task1 implements Runnable {
	private String name;
	
	public Task1(String name) {
		this.name = name;
	}
		
	public String getName() {
		return name;
	}
	
	public void run() {
		try {
			System.out.println("Doing another task1 during: " + name + " - time - " + new Date());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

