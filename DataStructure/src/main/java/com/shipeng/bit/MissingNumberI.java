package com.shipeng.bit;

/*
 * Missing number
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ...., n,
 * find the one that is missing from the array.
 * 
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you please implement it using only constant extra space complexity ?
 * 
 */

public class MissingNumberI {

	// bit manipulation solution
	public int missingNumber(int[] nums) {
		int miss = 0;
		for (int i = 0; i < nums.length; i++) {
			// go through 0 ~ nums.length-1, not missing number would become 0 after ^ operation.
			miss ^= (i + 1) ^ nums[i];
		}
		return miss;
	}
	
}
