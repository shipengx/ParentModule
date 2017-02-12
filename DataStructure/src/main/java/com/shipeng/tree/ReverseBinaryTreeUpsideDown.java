package com.shipeng.tree;

/*
 * Reverse binary tree upside down
 * 
 * Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree
 * with leaf nodes as the root.
 * 
 * Examples
 *        1
 *      2   5
 *    3  4 
 *    is reversed to 
 *        3
 *     2     4
 *  1    5
 *  How is the binary tree represented ?
 *  We use the pre order traversal sequence with a special symbol "#" denoting the null node.
 *  For example:
 *  The sequence [1,2,#,3,4,#,#,#] represents the following binary tree:
 *     1
 *   2   3
 *     4
 * 
 */


public class ReverseBinaryTreeUpsideDown {

	// Method 1: recursion
	public TreeNode reverse(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}
		TreeNode newRoot = reverse(root.left);
		root.left.right = root.right;
		root.left.left = root;
		root.left = null;
		root.right = null;
		return newRoot;
	}
	
	// Method 2: iterative
	public TreeNode reverseI(TreeNode root) {
		TreeNode prev = null;
		TreeNode prevRight = null;
		while (root != null) {
			TreeNode next = root.left;
			TreeNode right = root.right;
			root.right = prevRight;
			root.left = prev;
			prevRight = right;
			prev = root;
			root = next;
		}
		return prev;
	}

}
