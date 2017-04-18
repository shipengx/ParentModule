package com.shipeng.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary tree level order traversal II
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root). For
 * example, Given binary tree [3,9,20,null,null,15,7],
 * 
 * 3 9 20 15 7
 * 
 * return its bottom-up level order traversal as: [ [15,7], [9,20], [3] ]
 *
 */

public class BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> tmpList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.pollFirst();
				if (tmp.left != null) {
					queue.add(tmp.left);
				}
				if (tmp.right != null) {
					queue.add(tmp.right);
				}
				tmpList.add(tmp.key);
			}
			result.add(tmpList);
		}
		Collections.reverse(result);
		return result;
	}

}
