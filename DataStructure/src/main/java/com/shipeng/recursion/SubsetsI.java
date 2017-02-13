package com.shipeng.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * All subsets I
 * Given a set of characters represented by a string, return a list containing all subsets of the characters.
 * Assumptions:
 *     There are no duplicate characters in the original set.
 *     
 * Examples
 * Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
 * Set = "", all the subsets are [""]
 * Set = null, all the subsets are []
 * 
 */


public class SubsetsI {

	public List<String> subSets(String set) {
		List<String> result = new ArrayList<String>();
		if (set == null) {
			return result;
		}
		char[] arraySet = set.toCharArray();
		// record the current subset
		StringBuilder sb = new StringBuilder();
		helper(arraySet, sb, 0, result);
		return result;
	}
	
	// at each level, determine the character at the position "index" to be picked or not.
	private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
		// termination condition:
		// when we finishes determining for all the characters pick or not,
		// we have a complete subset.
		if (index == set.length) {
			result.add(sb.toString());
			return;
		}
		// 1. not pick the character at index.
		helper(set, sb, index+1, result);
		
		// 2. pick the character at index
		sb.append(set[index]);
		helper(set, sb, index+1, result);
		
		// remember to remove the added character when back tracking to the previous level
		sb.deleteCharAt(sb.length() -1);
	}
	
	
}
