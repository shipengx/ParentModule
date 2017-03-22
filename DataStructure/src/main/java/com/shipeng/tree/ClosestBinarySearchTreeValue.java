package com.shipeng.tree;

/*
 * Closest binary search tree value
 * 
 * Given a non-empty binary search tree and a target value, 
 * find the value in the BST that is closest to the target.
 * 
 * Note:
 * 	given target value is a floating point.
 *  you are guaranteed to have only one unique value in the BST that is closest to the target.
 * 
 */

public class ClosestBinarySearchTreeValue {

	public int closestValue(TreeNode root, double target) {
		// Assumptions: the given binary search tree is not null.
		int result = root.val;
		// the closest number has to be on the path of finding
		// the target value in the binary search tree.
		while (root != null) {
			if (root.val == target) {
				return root.val;
			} else {
				if (Math.abs(root.val - target) < Math.abs(result - target)) {
					result = root.val;
				}
				if (root.val < target) {
					root = root.right;
				} else {
					root = root.left;
				}
			}
		}
		return result;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
