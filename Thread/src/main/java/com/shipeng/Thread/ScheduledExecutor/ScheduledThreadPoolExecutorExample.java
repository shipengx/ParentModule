package com.shipeng.Thread.ScheduledExecutor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorExample {

	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		Task task1 = new Task("Demo Task 1");
		Task1 task2 = new Task1("Demo Task 2");

		System.out.println("The time is : " + new Date());

		// the method accepts four parameters:
		// 1. the task you want to execute periodically
		// 2. the delay of time until the first execution of the task
		// 3. the period between two executions
		// 4. and the time unit of hte second and third parameters
		
		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task1, 1, 1, TimeUnit.SECONDS);
		ScheduledFuture<?> result2 = executor.scheduleAtFixedRate(task2, 1, 1, TimeUnit.SECONDS);

		try {
			TimeUnit.MILLISECONDS.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		executor.shutdown();
	}

}

/*
 * ScheduledThreadPoolExecutor provides other methods to schedule periodic tasks.
 * it is the scheduledWithFixedRate() method. it has the same parameters as the scheduledAtFixedRate()
 * method, but there is a difference worth noticing. In the scheduledAtFixedRate() method, the third parameter
 * determines the period of time between the starting of two executions. In the scheduledWithFixedRate() method,
 * parameter determines the period of time between the end of an execution of the task and the beginning of the 
 * next execution.
 */
