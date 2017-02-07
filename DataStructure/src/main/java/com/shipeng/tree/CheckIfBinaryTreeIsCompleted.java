package com.shipeng.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Check if binary tree is complete
 * 
 * Check if a given binary tree is completed, a complete binary tree is one in which every level of the binary tree 
 * is completely filled except possibly the last level. 
 * Furthermore, all nodes are as far left as possible.
 * 
 * Examples
 *       5
 *    3     8
 *  1   4
 *  is completed.
 *       5
 *    3    8
 * 1   4     11
 *  is not completed.
 *  
 *  Corner cases:
 *      what if the binary tree is null? return true in this case.
 *  How is the binary tree represented ?
 *  we use the level order traversal sequence with a special symbol "#" denoting the null node.
 *  For example:
 *  the sequence [1,2,3,#,#,4] represents the following binary tree:
 *      1
 *   2    3
 *      4
 * 
 */

public class CheckIfBinaryTreeIsCompleted {

	public boolean isCompleted(TreeNode root) {

		if (root == null) {
			return true;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		// if flag is set true, there should not be any child nodes afterwards.
		boolean flag = false;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			// if any of the child is not present, set the flag to true.
			if (cur.left == null) {
				flag = true;
			} else if (flag) {
				// if flag is set but we still see cur has a left child,
				// the binary tree is not a completed one.
				return false;
			} else {
				// if flag is not set and left child is present.
				queue.offer(cur.left);
			}
			
			// same logic applied to the right child.
			if (cur.right == null) {
				flag = true;
			}else if (flag) {
				return false;
			}else {
				queue.offer(cur.right);
			}
		} //end while
		
		return true;
	}
}


