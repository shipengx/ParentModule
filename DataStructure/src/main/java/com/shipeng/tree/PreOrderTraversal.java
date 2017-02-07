package com.shipeng.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * In-order traversal of Binary Tree
 * Implement an iterative, in-order traversal of a given binary tree,
 * return the list of keys of each node in the tree as it is in-order traversed.
 * Examples:
 *                    5
 *               3        8
 *            1    4        11
 *           in-order traversal is [1,3,4,5,8,11]
 *           Corner cases
 *               What if the given binary tree is null ? return an empty list in this case.
 *           How is the binary tree represented ?
 *           we use the level order traversal sequence with a special symbol "#" denoting the null node.
 *           For example:
 *           The sequence [1,2,3,#,#,4] represents the following binary tree:
 *           
 *               1
 *            2     3
 *               4
 *               
 */


public class PreOrderTraversal {
	
	public List<Integer> preOrder(TreeNode root) {
		List<Integer> preorder = new ArrayList<Integer>();
		if (root == null) {
			return preorder;
		}
		
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.offerFirst(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			// the left subtree should be traversed before right subtree.
			// since stack is LIFO, we should push right into the stack first,
			// so for the next the top element of the stack is the left subtree.
			if (cur.right != null) {
				stack.offerFirst(cur.right);
			}
			if (cur.left != null) {
				stack.offerFirst(cur.left);
			}
			preorder.add(cur.key);
		}//end while
		
		return preorder;
	}
}
