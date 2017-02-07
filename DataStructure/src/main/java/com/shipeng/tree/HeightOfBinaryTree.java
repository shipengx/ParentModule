package com.shipeng.tree;

public class HeightOfBinaryTree {

	public int findHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
