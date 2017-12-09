package com.shipeng.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
 * A solution set is: 
 * [
 *   [7],
 *   [2, 2, 3]
 * ]
 * 
 */

public class CombinationSumI {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return result;
		}
		List<Integer> path = new ArrayList<Integer>();
		helper(result, path, 0, 0, target, candidates);
		return result;
	}

	private void helper(List<List<Integer>> result, List<Integer> path, int index, int sum, int target,
			int[] candidates) {
		if (sum > target) {
			return;
		}
		if (sum == target) {
			result.add(new ArrayList<Integer>(path));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			path.add(candidates[i]);
			helper(result, path, i, candidates[i] + sum, target, candidates);
			path.remove(path.size() - 1);
		}
	}

}
