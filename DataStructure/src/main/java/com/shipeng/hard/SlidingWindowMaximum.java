package com.shipeng.hard;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Sliding window maximum
 * 
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * 
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * Window position               Max
 * [1 3 -1] -3 5 3 6 7           3
 * 1 [3 -1 -3] 5 3 6 7           3
 * 1 3 [-1 -3 5] 3 6 7           5
 * 1 3 -1 [-3 5 3] 6 7           5
 * 1 3 -1 -3 [5 3 6] 7           6
 * 1 3 -1 -3 5 [3 6 7]           7 
 * 
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * Note: 
 * You may assume k is always valid, i.e. 1 <= k <= input array's size for non-empty array.
 *
 */


public class SlidingWindowMaximum {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null) {
			return null;
		}
		
		List<Integer> max = new ArrayList<Integer>();
		// use a descending deque to solve this problem
		// we store the index instead of the actual value in the deque,
		// and we make sure:
		// 1. the deque only contains index in the current sliding window
		// 2. for any index, the previous index with smaller value is discarded from the deque.
		
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			// discard any index with smaller value than index i.
			while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
				deque.pollLast();
			}
			// it is possible the head element is out of the current
			// sliding window so we might need to discard it as well.
			if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}
			deque.offerLast(i);
			if (i >= k - 1) {
				max.add(nums[deque.peekFirst()]);
			}
		}
		int[] result = new int[max.size()];
		for (int i = 0; i < max.size(); i++) {
			result[i] = max.get(i);
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7};
		int k = 3;
		int[] result = maxSlidingWindow(nums, k);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
}
