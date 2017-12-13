package com.shipeng.bit;

/*
 * Single Number III
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 * 
 * For example:
 * Given nums = [1,2,1,3,2,5], return [3,5].
 * 
 * Note:
 *     1. the order of the result is not important, so in the above example, [5,3] is also correct.
 *     2. Your algorithm should run in linear runtime complexity. 
 *        Could you implement it using only constant space complexity ?
 * 
 */

public class SingleNumberIII {

	// bit manipulation, find the first kth bit in xor to separate nums array into two separate parts
	public static int[] singleNumber(int[] nums) {
		int[] result = new int[2];
		if (nums == null || nums.length == 0) {
			return result;
		}
		int xor = 0;
		for (int i = 0; i < nums.length; i++) {
			xor = xor ^ nums[i];
		}
		// xor is b ^ c
		int index;
		for (index = 0; index < 32; index++) {
			if (((xor >> index) & 1) == 1) {
				break;
			}
		}
		int num1 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (((nums[i] >> index) & 1) == 1) {
				num1 = num1 ^ nums[i];
			}
		}

		int num2 = num1 ^ xor;

		result[0] = num1;
		result[1] = num2;

		return result;
	}

}
