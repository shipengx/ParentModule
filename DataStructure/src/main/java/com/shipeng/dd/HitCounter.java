package com.shipeng.dd;

import java.util.Arrays;

public class HitCounter {

	int[] counts;
	int prevSecond;
	int cacheSum;

	/** Initialize your data structure here. */
	public HitCounter() {
		counts = new int[300];
		prevSecond = (int) System.currentTimeMillis() / 1000;
		cacheSum = 0;
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		update(timestamp, counts);
		counts[timestamp % 300]++;
		cacheSum++;
		prevSecond = timestamp;
	}

	private void update(int timestamp, int[] counts) {
		if (timestamp - prevSecond >= 300) {
			Arrays.fill(counts, 0);
			cacheSum = 0;
		} else {
			for (int i = prevSecond + 1; i <= timestamp; i++) {
				cacheSum = cacheSum - counts[i % 300];
				counts[i % 300] = 0;
			}
		}
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		update(timestamp, counts);
		prevSecond = timestamp;
		return cacheSum;
	}

	public static void main(String[] args) {
		HitCounter counter = new HitCounter();

		// hit at timestamp 1.
		counter.hit(1);

		// hit at timestamp 2.
		counter.hit(2);

		// hit at timestamp 3.
		counter.hit(3);

		// get hits at timestamp 4, should return 3.
		System.out.println("counter.getHits(4)" + counter.getHits(4));

		// hit at timestamp 300.
		counter.hit(300);
		
		
		// get hits at timestamp 300, should return 4.
		System.out.println("counter.getHits(300)" + counter.getHits(300));

		// get hits at timestamp 301, should return 3.
		System.out.println("counter.getHits(301)" + counter.getHits(301));
	}

}
