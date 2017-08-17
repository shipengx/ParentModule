package org.Guava;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterTest {

	public static void main(String[] args) {
		RateLimiter rateLimiter = RateLimiter.create(1);
		int i = 3;
		while (i > 2) {
			performOperation(rateLimiter);
			try {
			    Thread.sleep(333);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	private static void performOperation(RateLimiter limiter) {
		//limiter.acquire();
		if (limiter.tryAcquire()) {
			System.out.println(new Date() + ": Beep");
		}else {
			System.out.println("QPSThrottled.");
		}
	}
}
