package com.shipeng.class99;

/**
 * Diameter of binary tree Given a binary tree, you need to compute the length
 * of the diameter of the tree. The diameter of a binary tree is the length of
 * the longest path between any two nodes in a tree. this path may or may not
 * pass through the root.
 * 
 * Example: Given a binary tree 1 2 3 4 5
 * 
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * 
 * Note: The length of path between two nodes is represented by the number of
 * edges between them.
 * 
 */

public class DiameterOfBinaryTree {

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] max = new int[1];
		maxDepth(root, max);
		return max[0];
	}

	private int maxDepth(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left, max);
		int right = maxDepth(root.right, max);
		max[0] = Math.max(max[0], left + right);
		return Math.max(left, right) + 1;
	}

	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
}
