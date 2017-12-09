package com.shipeng.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * CombinationSum III
 * 
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * 
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * 
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 */

public class CombinationSumIII {

	// Solution 1
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		if (k > n || n <= 0) {
			return result;
		}
		List<Integer> path = new ArrayList<Integer>();
		helper(result, path, 1, k, n);
		return result;
	}

	private void helper(List<List<Integer>> result, List<Integer> path, int index, int k, int target) {
		if (target < 0 || path.size() > k) {
			return;
		} else if (target == 0) {
			if (path.size() == k) {
				result.add(new ArrayList<Integer>(path));
				return;
			}
		} else {
			for (int i = index; i <= 9; i++) {
				path.add(i);
				helper(result, path, i + 1, k, target - i);
				path.remove(path.size() - 1);
			}
		}
	}

}
