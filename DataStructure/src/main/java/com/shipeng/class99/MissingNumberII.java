package com.shipeng.class99;

/**
 * Missing number II
 * Given an integer array of size N - 1 sorted by ascending order, containing all the numbers
 * from 1 to N except one, find the missing number.
 * 
 * Assumptions:
 *     The given array is not null, and N >= 1.
 *   
 * Examples:
 *     A = {1,2,4}, the missing number is 3
 *     A = {1,2,3}, the missing number is 4
 *     A = {}, the missing number is 1
 *     
 */

public class MissingNumberII {

	public int missing(int[] array) {
		int n = array.length + 1;
		long targetSum = (n + 0L) * (n + 1L) /2;
		long actualSum = 0L;
		for (int num: array) {
			actualSum += num;
		}
		return (int) (targetSum - actualSum);
	}
	
}
