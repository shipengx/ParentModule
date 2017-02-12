package com.shipeng.tree;

/*
 * Insert in binary search tree
 * Insert a key in a binary search tree if the binary search tree doesn't already contain the key.
 * Return the root of the binary search tree.
 * 
 * Assumptions:
 *     There are no duplicate keys in the binary search tree.
 *     If the key is already existed in the binary search tree, you do not need to do anything.
 *     
 * Examples:
 *          5
 *       3     8
 *    1     4
 *     insert 11, the tree becomes
 *         5
 *      3     8
 *   1    4     11
 *     insert 6, the tree becomes
 *         5
 *      3       8
 *    1   4   6  11
 * 
 */


public class InsertInBinarySearchTree {

	public TreeNode insert(TreeNode root, int key) {
		if (root == null) {
			return new TreeNode(key);
		}
		
		TreeNode cur = root;
		TreeNode last = null;
		
		while (cur != null) {
			last = cur;
			if (cur.key > key) {
				cur = cur.left;
			}else if (cur.key < key) {
				cur = cur.right;
			}else {
				return root;
			}
		}//end while
		
		if (last != null) {
			if (last.key > key) {
				last.left = new TreeNode(key);
			}else {
				last.right = new TreeNode(key);
			}
		}
		
		return root;
		
	}
	
}
