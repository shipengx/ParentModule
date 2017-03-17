package org.Guava;

import java.util.Date;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterTest {

	public static void main(String[] args) {
		RateLimiter rateLimiter = RateLimiter.create(2.0);
		int i = 3;
		while (i > 2) {
			performOperation(rateLimiter);
		}
		
	}
	
	private static void performOperation(RateLimiter limiter) {
		limiter.acquire();
		System.out.println(new Date() + ": Beep");
	}
}
