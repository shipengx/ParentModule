package com.shipeng.tree;

/*
 * Path Sum
 * 
 * Give a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up
 * all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22.
 * 
 *             5
 *          4       8
 *       11     13     4
 *     7   2             1
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 */

public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.key == sum && root.left == null && root.right == null) {
			return true;
		}
		boolean left = hasPathSum(root.left, sum - root.key);
		boolean right = hasPathSum(root.right, sum - root.key);
		if (left == true || right == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasPathSumII(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			if (sum == root.key) {
				return true;
			} else {
				return false;
			}
		}
		boolean left = hasPathSum(root.left, sum - root.key);
		boolean right = hasPathSum(root.right, sum - root.key);
		return left || right;
	}

}
