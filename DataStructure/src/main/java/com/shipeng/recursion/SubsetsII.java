package com.shipeng.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * All Subsets II
 * Given a set of characters represented by a string, return a list of all subsets of the characters.
 * 
 * Assumptions:
 *     There could be duplicate characters in the original set.
 *     
 * Examples:
 *     set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
 *     set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
 *     set = "",    all the subsets are [""]
 *     set = null,  all the subsets are []
 * 
 */

public class SubsetsII {

	public List<String> subSets(String set) {
		// Write your solution here.
		List<String> result = new ArrayList<String>();

		if (set == null) {
			return result;
		}

		char[] arraySet = set.toCharArray();
		// make sure the multi-set is sorted so that we can dedup.
		Arrays.sort(arraySet);
		StringBuilder sb = new StringBuilder();
		helper(arraySet, sb, 0, result);
		return result;
	}

	// index: at current level, determine if the element at "index" should be
	// included in the subset or not.

	private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
		if (index == set.length) {
			result.add(sb.toString());
			return;
		}
		helper(set, sb.append(set[index]), index + 1, result);
		sb.deleteCharAt(sb.length() - 1);
		// skip all the consecutive and duplicate elements.
		while (index < set.length - 1 && set[index] == set[index + 1]) {
			index++;
		}
		helper(set, sb, index + 1, result);
	}

}
