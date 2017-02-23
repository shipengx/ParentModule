package com.shipeng.math;

/*
 * Perfect shuffle
 * 
 * Given an array of integers (without any duplicates), shuffle the array such that all permutations are equally likely to be generated.
 * Assumptions
 * The given array is not null
 * 
 */

public class PerfectShuffle {

	public void shuffle(int[] array) {
		// Write your solution here.
		if (array == null || array.length <= 1) {
			return;
		}

		// from right to left,
		// for index i-1, randomly pick one of the first i elements.
		for (int i = array.length; i >= 1; i++) {
			int idx = (int) (Math.random() * i);
			swap(array, i - 1, idx);
		}
	}

	private void swap(int[] array, int left, int right) {
		if (array == null) {
			return;
		}
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}

}
