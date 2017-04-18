package com.shipeng.backtracking;

/*
 * Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1...n.
 * For example,
 * if n = 4 and k = 2, a solution is:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 
 */


import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if (n <= 0 || k <= 0) {
			return result;
		}
		List<Integer> path = new ArrayList<Integer>();
		helper(result, path, 1, k, n);
		return result;
	}

	private static void helper(List<List<Integer>> result, List<Integer> path, int index, int k, int n) {
		if (path.size() == k) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = index; i <= n; i++) {
			path.add(i);
			helper(result, path, i + 1, k, n);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(combine(4, 2));
	}

}
