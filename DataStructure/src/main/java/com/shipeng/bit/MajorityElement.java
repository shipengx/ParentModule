package com.shipeng.bit;

/*
 * Majority Element
 * 
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than [ n/2 ] times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * 
 */

public class MajorityElement {

	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int candidate = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				count++;
				candidate = nums[i];
			} else if (candidate == nums[i]) {
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}
	
}
