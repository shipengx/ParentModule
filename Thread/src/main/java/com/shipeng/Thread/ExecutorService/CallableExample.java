package com.shipeng.Thread.ExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

	/*
	 * An Executor that provides methods to manage termination and methods that can
	 * produce a Future for tracking progress of one or more asynchronous tasks.
	 * 
	 * An ExecutorService can be shut down, which will cause it to reject new tasks.
	 * The Shutdown() method will allow previously submitted tasks to execute before
	 * terminating, while the shutdownNow() method prevents waiting tasks from
	 * starting and attempts to stop currently executing tasks. An unused
	 * ExecutorService should be shut down to allow reclaimation of its resources.
	 * 
	 * submit(Callable<T> task) === submits a value-returning task for execution and
	 * returns a Future representing the pending results of the task.
	 * submit(Runnable task) === submits a Runnable task for execution and returns a
	 * Future representing that task.
	 * 
	 * With Callable The Callable interface is a generic interface containing a
	 * single call() method -- which returns a generic value V.
	 * 
	 * public interface Callable<V>> { V call() throws Exception; }
	 * 
	 * The result of call() method is returned within a Future object.
	 * 
	 * The Future interface
	 * the submit() and invokeAll() methods return an object or a collection of objects of type Future,
	 * which allows us to get the result of a task's execution or to check the task's status (is it running or executed).
	 * 
	 * The Future interface provides a special blocking method get() which returns an actual result of the Callable task's execution
	 * or null in case of Runnable task. Calling the get() method while the task is still running will cause execution to block
	 * until the task is properly executed and the result is available.
	 * 
	 * Even despite teh relative simplicity of ExecutorService, there are a few common pitfalls, 
	 * let's summarize them:
	 * 
	 * Keep an unused ExecutorService alive : there is a detailed explanation in section 4 of this article about how to 
	 * shut down an executorService
	 * 
	 * Wrong thread-pool capacity while using fixed length thread-pool : it is very important to determine how many threads 
	 * the application will need to execute tasks efficiently. A thread-pool that is too large will cause unnecessary overhead
	 * just to create threads which mostly will be in the waiting mode. Too few can make an application seem unresponsive because
	 * of long waiting periods for tasks in the queue
	 * 
	 * Calling a Future's get() method after task cancellation: An attempt to get the result of an already cancelled task will
	 * trigger a CancellationException.
	 * 
	 * Unexpectedly-long blocking with Future's get() method: Timeouts should be used to avoid unexpected waits.
	 * 
	 * 
	 */

	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		List<Future<String>> futureResponses = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			Future<String> futureResponse = executorService.submit(new CallableExample.PrintTask("task " + i));	
			futureResponses.add(futureResponse);
		}
		
		try {
			Thread.sleep(3000);
			
			for (int i = 0; i < futureResponses.size(); i++) {
				System.out.println("Future response is : " + futureResponses.get(i).get());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		executorService.shutdown();
	}

	private static class PrintTask implements Callable<String> {
		private String taskName;

		public PrintTask(String taskName) {
			this.taskName = taskName;
		}

		public String call() throws Exception {

			for (int i = 0; i < 3; i++) {
				System.out.println(taskName + ", number is : " + i);
				Thread.sleep(1000);
			}
			return taskName + " is done.";
		}
	}

}
