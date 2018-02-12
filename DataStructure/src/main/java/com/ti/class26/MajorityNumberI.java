package com.ti.class26;

/*
 * Majority Number I
 * 
 * Given an integer array of length L, find the number that occurs more than 0.5 * L times.
 * 
 * Assumptions:
 *     The given array is not null or empty
 *     It is guaranteed there exists such a majority number
 *     
 * Examples
 *     A = { 1, 2, 1, 2, 1}, return 1
 * 
 */

public class MajorityNumberI {

	public int majority(int[] array) {
		// write your solution here
		// Assumptions: array is not null and is not empty
		// majority number guarantees to exist.
		int candidate = array[0];
		int count = 1;
		for (int i = 0; i < array.length; i++) {
			if (count == 0) {
				count++;
			} else if (candidate == array[i]) {
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}

}
