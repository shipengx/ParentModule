package com.ti.class13;

/*
 * Array Hopper II
 * Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
 * A[i] means the maximum jump distance from index i (you can only jump towards the end of the array).
 * Determine the minimum number of jumps you need to reach the end of array.
 * If you can not reach the end of the array, return -1.
 * 
 * Assumptions
 *     The given array is not null and has length of at least 1.
 *     
 * Examples
 *     {3,3,1,0,4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array).
 *     {2,1,1,0,2}, you are not able to reach the end of array, return -1 in this case.
 * 
 */

public class ArrayHopperII {

	public int minJump(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int[] m = new int[array.length];
		m[0] = 0;
		for (int i = 1; i < array.length; i++) {
			m[i] = -1;
			for (int j = 0; j < i; j++) {
				if (j + array[j] >= i && m[j] != -1) {
					if (m[i] == -1 || m[i] > m[j] + 1) {
						m[i] = m[j] + 1;
					}
				}
			}
		}
		return m[array.length - 1];
	}

	// solution 2:
	public int minJump2(int[] array) {
		// Assumptions: array is not null and is not empty
		int length = array.length;
		// minJump record the min number of jumps from 0 to each of the indices
		int[] minJump = new int[length];
		// we do not need to jump for index 0.
		minJump[0] = 0;
		for (int i = 1; i < length; i++) {
			minJump[i] = -1; // initialized as unreachable
			for (int j = i - 1; j >= 0; j--) {
				if (j + array[j] >= i && minJump[j] != -1) {
					if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) {
						minJump[i] = minJump[j] + 1;
					}
				}
			}
		}
		return minJump[length - 1];
	}

}
