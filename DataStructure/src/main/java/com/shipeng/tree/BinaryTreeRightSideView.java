package com.shipeng.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Binary tree right side view
 * 
 * Given a binary tree, imagine yourself standing on the right side of it.
 * return the values of nodes you can see ordered from top to bottom.
 * 
 * For example:
 * given the following binary tree,
 * 
 *       1        <----
 *     2   3      <----
 *      5   4     <----
 * 
 * You should return [1,3,4]
 * 
 */


public class BinaryTreeRightSideView {
	
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		rightView(result, root, 0);
		return result;
	}
	
	private void rightView(List<Integer> result, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (level == result.size()) {
			result.add(root.val);
		}
		rightView(result, root.right, level+1);
		rightView(result, root.left, level+1);
	}
	
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	} //end class
	
	public List<Integer> rightSizeView1(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			result.add(queue.peek().val);
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
			}
		}//end while
		return result;
	}
	
}
