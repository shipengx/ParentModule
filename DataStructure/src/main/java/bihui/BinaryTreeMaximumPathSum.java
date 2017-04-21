package bihui;

/**
 * Binary Tree Maximum Path Sum
 * 
 * Given a binary tree, find the maximum path sum. For this problem, a path is
 * defined as any sequence of nodes from some starting node to any node in the
 * tree along the parent-child connections. The path must contain at least one
 * node and does not need to go through the root.
 * 
 * For example: Given the below binary tree,
 * Vertical maximum subarray sum.
 * 
 * 1 2 3
 * 
 * Return 6.
 *
 */

public class BinaryTreeMaximumPathSum {

	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
	
	public int maxPathSum(TreeNode root) {
		// Assumptions: root is not null.
		// max stores the global maximum path sum and will be updated during the
		// recursion.
		int[] max = new int[] { Integer.MIN_VALUE };
		helper(root, max);
		return max[0];
	}

	// return the maximum path sum of the "single" path
	private int helper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		left = left < 0 ? 0 : left;
		right = right < 0 ? 0 : right;
		max[0] = Math.max(root.val + left + right, max[0]);
		return root.val + Math.max(left, right);
	}

}
