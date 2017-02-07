package com.shipeng.tree;

/* 
 * check if two given binary trees are identical.
 * Identical means the equal valued keys are at the same position in the two binary trees.
 * 
 * Example:
 * 
 * 			5
 *        3   8
 *     and 
 *     		 5
 *        3    8
 *     are identical trees.
 *     How is the binary tree represented ?
 *     We use the level order traversal sequence with a special symbol "#" denoting the null node.
 *     For example:
 *     the sequence [1,2,3,#,#,4] represents the following binary tree:
 *         1
 *       2    3
 *          4
 * 
 */



public class IdenticalBinaryTree {

	public boolean isIdentical(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		}
		if (one == null || two == null) {
			return false;
		}
		if (one.key != two.key) {
			return false;
		}
		return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
	}
	
}
