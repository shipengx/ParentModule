package com.shipeng.tree;

/*
 * Recover binary search tree
 * 
 * Given a binary search tree with only two nodes swapped. 
 * Try to find them and recover the binary search tree.
 * 
 * Input:
 *            4
 *       2         6
 *    1    5    3     7
 *    
 * Output:
 *            4
 *         2      6
 *      1    3  5   7
 * 
 */

public class RecoverBinarySearchTree {
	
	TreeNode node1 = null;
	TreeNode node2 = null;
	
	public void recoverTree(TreeNode root) {
		inorderTraverse(root);
		int tmp = node1.val;
		node1.val = node2.val;
		node2.val = tmp;
	}
	
	TreeNode prev = null;
	private void inorderTraverse(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraverse(root.left);
		if (prev != null) {
			if (root.val <= prev.val) {
				if (node1 == null) {
					node1 = prev;
				}
				node2 = root;
			}
		}
		prev = root;
		inorderTraverse(root.right);
	}
	
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
}



