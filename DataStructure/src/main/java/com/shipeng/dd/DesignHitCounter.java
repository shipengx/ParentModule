package com.shipeng.dd;

import java.util.ArrayDeque;

/*
 * Design hit counter
 * 
 * Design a hit counter which counts the number of hits received in the past 5 minutes
 * 
 * Each function accepts a timestamp parameter (in seconds granularity) and you may ssume that calls are being made
 * to the system in chronological order (ie, the timestamp is monotonically increasin).
 * You may assume that the earilies timestamp starts at 1.
 * 
 * it is possible that several hits arrive roughly at the same time.
 * 
 * 
 * HitCounter counter = new HitCounter();
 * hit at timestamp 1.
 * counter.hit(1);
 * 
 * hit at timestamp 2.
 * counter.hit(2);
 *
 * hit at timestamp 3.
 * counter.hit(3);
 * 
 * get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 * 
 * hit at timestamp 300.
 * counter.hit(300);
 * 
 * get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 * 
 * get hits at timestamp 301, should return 3.
 * counter.getHits(301); 
 * 
 * 
 */

public class DesignHitCounter {

	private ArrayDeque<Integer> queue;

    /** Initialize your data structure here. */
    public DesignHitCounter() {
        queue = new ArrayDeque<Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int startTime = timestamp - 300;
        while(!queue.isEmpty() && queue.peek() <= startTime) {
            queue.poll();
        }
        return queue.size();
    }
    
}
