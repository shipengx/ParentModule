package com.ti.class06;

import java.util.ArrayList;
import java.util.List;

/*
 * All permutations I
 * 
 * Given a string with no duplicate characters, return a list with all permutations of the characters.
 * 
 * Examples
 *     Set = "abc", all permutations are ["abc", "acb", "bac", "bca", "cab", "cba"]
 *     Set = "", all permutations are [""]
 *     Set = null, all permutations are []
 * 
 * 
 */

public class AllPermutationsI {

	public List<String> permutations(String set) {
		List<String> result = new ArrayList<>();
		if (set == null) {
			return result;
		}
		char[] array = set.toCharArray();
		helper(array, 0, result);
		return result;
	}

	// choose the character to be at the position of "index".
	// all the already chosen positions are (0, index -1)
	// all the candidate characters can be at position "index"
	// are in the subarray of (index, array.length -1)
	private void helper(char[] array, int index, List<String> result) {
		// terminate condition
		// only when we have already chosen the characters for all the position,
		// we can have a complete permutation.
		if (index == array.length) {
			result.add(new String(array));
			return;
		}
		// all the possible characters could be placed at index are
		// the characters in the subarray (index, array.length - 1);
		for (int i = index; i < array.length; i++) {
			swap(array, index, i);
			helper(array, index + 1, result);
			// remember to swap back when back track to previous level
			swap(array, index, i);
		}
	}

	private void swap(char[] array, int left, int right) {
		char tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}

}
