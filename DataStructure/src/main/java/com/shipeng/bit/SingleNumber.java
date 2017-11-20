package com.shipeng.bit;

/*
 * Single Number
 * 
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory ?
 * 
 */

public class SingleNumber {

	public int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int x = 0;
		for (int i = 0; i < nums.length; i++) {
			x = x ^ nums[i];
		}
		return x;
	}
	
}
