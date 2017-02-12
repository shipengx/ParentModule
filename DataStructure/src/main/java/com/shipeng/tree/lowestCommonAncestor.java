package com.shipeng.tree;

/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has 
 * both v and w as descendants (where we allow a node to be a descendant of itself).
 * 
 * return:
 * null -- there is no one or two in the subtree.
 * non null --
 * 1). if there is only one node of one/two in the subtree.
 *     just return the one/two itself.
 * 2). if there both one/two are in the subtree, return the LCA.
 *     a). one is two's descendant, return one
 *     b). two is one's descendant, return two.
 *     c). otherwise, return the lowest node with one and two in the two different subtrees.
 *     
 * 
 */

public class lowestCommonAncestor {

	public static TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}
		// what we get from left and right children
		TreeNode left = LowestCommonAncestor(root.left, p, q);
		TreeNode right = LowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}
	
	public static void main(String[] args) {
		
	}
	
}
