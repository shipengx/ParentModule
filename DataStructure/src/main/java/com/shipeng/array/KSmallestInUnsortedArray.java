package com.shipeng.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Find the smallest k elements in an unsorted array.
 * Assumptions: 
 *     1). array is not null
 *     2). k >= 0 and k <= array.length
 * 
 */

public class KSmallestInUnsortedArray {
	
	// Method 1: k sized max heap
	public int[] kSmallestI(int[] array, int k) {
		// handle all possible corner cases at the very beginning.
		if (array.length == 0 || k == 0) {
			return new int[0];
		}
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k,
				new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				// do not use "==" here !!!
				if (o1.equals(o2)) {
					return 0;
				}
				return o1 > o2 ? -1 : 1;
			}
		});
		
		for (int i = 0; i < array.length; i++) {
			if (i < k) {
				// offer the first k elements int max heap.
				// NOTICE: if you want to utilize heapify(), the only thing you can do
				// is to call a certain constructor of PriorityQueue
				maxHeap.offer(array[i]);
			}else if (array[i] < maxHeap.peek()) {
				// for the other elements, only offer it into the max heap if it is
				// smaller than the max value in the max heap.
				maxHeap.poll();
				maxHeap.offer(array[i]);
			}
		}
		
		int[] result = new int[k];
		for (int i = k -1; i >= 0; i--) {
			result[i] = maxHeap.poll();
		}
		return result;
		
	}

	
}
