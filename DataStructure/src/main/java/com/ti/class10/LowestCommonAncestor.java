package com.ti.class10;

/*
 * Lowest Common Ancestor I
 * Given two nodes in a binary tree, find their lowest common ancestor.
 * 
 * Assumptions
 *     There is no parent pointer for the nodes in the binary tree
 *     The given two nodes are guaranteed to be in the binary tree
 *    
 * Examples
 *       5
 *   9      12
 * 2  3       14
 * 
 * The lowest common ancestor of 2 and 14 is 5
 * The lowest common ancestor of 2 and 9 is 9
 * 
 */

public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null) {
			return null;
		}
		// if root is one or two, we can ignore the later recursions
		if (root == one || root == two) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, one, two);
		TreeNode right = lowestCommonAncestor(root.right, one, two);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

}


/*
 * Solution:
 * return null -- if there is no one or two in the subtree.
 * 1) if there is only one node of one/two in the subtree,
 *     just return the one/two itself.
 * 2) if there both one/two are in the subtree, return the LCA
 *     a) one is two's descendant, return one
 *     b) two is one's descendant, return two
 *     c) otherwise, return the lowest node with one and two in the two different subtrees.
 * 
 */


