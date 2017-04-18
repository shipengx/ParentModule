package com.shipeng.tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22.
 * 
 *           5
 *       4       8
 *    11      13    4
 *  7   2         5   1    
 * 
 * return 
 * [
 *     [5,4,11,2],
 *     [5,8,4,5]
 * ]
 * 
 */

public class PathSumII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		helper(root, sum, result, path);
		return result;
	}

	private void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null && root.val == sum) {
			path.add(root.val);
			result.add(new ArrayList<>(path));
			path.remove(path.size() - 1);
			return;
		}
		path.add(root.val);
		helper(root.left, sum - root.val, result, path);
		path.remove(path.size() - 1);

		path.add(root.val);
		helper(root.right, sum - root.val, result, path);
		path.remove(path.size() - 1);
	}

}
