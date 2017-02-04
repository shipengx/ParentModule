package com.shipeng.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * Get keys in Binary Tree Layer by Layer
 * Get the list of list of keys in a given binary tree layer by layer.
 * Each layer is represented by a list of keys and the keys are traversed from left to right.
 * 
 * Example:
 *               5
 *             3     8
 *          1   4       11
 *          
 *      the result is [[5], [3,8], [1,4,11]
 *      Corner cases:
 *          what if the binary tree is null ?  Return an empty list of list in this case.
 *          
 * 
 */



public class GetKeysInBinaryTreeLayerByLayer {

	public List<List<Integer>> layerByLayer(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				list.add(tmp.key);
				if (tmp.left != null) {
					queue.add(tmp.left);
				}
				if (tmp.right != null) {
					queue.add(tmp.right);
				}
			} // end for loop
			result.add(list);
		}//end while
		
		return result;
	}
}
