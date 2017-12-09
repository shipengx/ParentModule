package com.shipeng.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Combination Sum II
 * 
 * 
 * 
 */

public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> ret = new ArrayList<>();
		List<Integer> sol = new ArrayList<>();
		helper(candidates, 0, target, sol, ret);
		return ret;
	}

	private void helper(int[] candidates, int idx, int target, List<Integer> sol, List<List<Integer>> ret) {
		if (target == 0) {
			ret.add(new ArrayList<>(sol));
			return;
		} else if (target > 0) {
			for (int i = idx; i < candidates.length; ++i) {
				if (candidates[i] > target) {
					break;
				}
				if (i > idx && candidates[i - 1] == candidates[i]) {
					continue;
				}
				sol.add(candidates[i]);
				helper(candidates, i + 1, target - candidates[i], sol, ret);
				sol.remove(sol.size() - 1);
			}
		}
	}

}
