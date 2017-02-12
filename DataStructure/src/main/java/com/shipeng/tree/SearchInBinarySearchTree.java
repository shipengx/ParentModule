package com.shipeng.tree;

/*
 * Search in binary search tree
 * 
 * Find the target key K in the given binary search tree, return the node that contains the key if K is found,
 * otherwise return null.
 * 
 */

public class SearchInBinarySearchTree {
	
	public TreeNode search(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		
		if (root.key == key) {
			return root;
		}else if (root.key < key) {
			return search(root.right, key);
		}else {
			return search(root.left, key);
		}
	}
	
}
