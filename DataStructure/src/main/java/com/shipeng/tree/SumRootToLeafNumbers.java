package com.shipeng.tree;

/**
 * Sum root to leaf numbers Given a binary tree containing digits from 0-9 only,
 * reach root-to-leaf path could represent a number. An example is the
 * root-to-leaf path 1->2->3 which represents the number 123. Find the total sum
 * of all root-to-leaf numbers.
 * 
 * For example 1 2 3 The root-to-leaf path 1->2 represents the number 12. The
 * root-to-leaf path 1->3 represents the number 13. Return the sum = 12 + 13 =
 * 25.
 *
 */

public class SumRootToLeafNumbers {

	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}

	public int sumNumbers(TreeNode root) {
		int[] result = new int[1];
		helper(root, 0, result);
		return result[0];
	}

	private void helper(TreeNode root, int curSum, int[] result) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			result[0] += curSum * 10 + root.val;
			return;
		}
		curSum = curSum * 10 + root.val;
		helper(root.left, curSum, result);
		helper(root.right, curSum, result);
	}
}
