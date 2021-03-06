package com.shipeng.tree;

/*
 * Delete in binary search tree
 * 
 * Delete the target key K in the given binary search tree if the binary search tree contains K.
 * Return the root of the binary search tree.
 * 
 * Find your own way to delete the node from the binary search tree, after deletion the binary search tree's
 * property should be maintained.
 * 
 * Assumptions:
 *     There are no duplicate keys in the binary search tree.
 * 
 */

public class DeleteInBinarySearchTree {

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else {
			// we found the target node to delete
			if (root.left == null && root.right == null) {
				// case 1: delete leaf node
				return null;
			} else if (root.left == null || root.right == null) {
				// case 2: delete a node with one child
				return root.left != null ? root.left : root.right;
			} else {
				// case 3: delete a node with two children
				TreeNode smallest = findSmallest(root.right);
				root.val = smallest.val;
				root.right = deleteNode(root.right, smallest.val);
			}
		}
		return root;
	}

	private TreeNode findSmallest(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode prev = null;
		TreeNode cur = root;
		while (cur != null) {
			prev = cur;
			cur = cur.left;
		}
		return prev;
	}

	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
    }
}
