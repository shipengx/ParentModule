package com.shipeng.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * In-order traversal of binary tree
 * 
 * implement an iterative, in-order traversal of a given binary tree,
 * return the list of keys of each node in the tree as it is in-order traversed.
 * 
 * Examples
 * 		5
 *   3     8
 *  1 4      11
 *  
 *  in-order traversal is [1,3,4,5,8,11]
 *  
 *  Corner cases:
 *  	what if the given binary tree is null ? return an empty list in this case.
 *  How is the binary tree represented ?
 *      we use the level order traversal sequence with a special symbol "#" denoting the null node.
 *      
 *      For example:
 *      the sequence [ 1, 2, 3, #, #, 4] represents the following binary tree:
 *        1
 *      2   3
 *     
 *         4
 * 
 */


public class InOrderTraversal {
	
	public List<Integer> inOrder(TreeNode root) {
		
		List<Integer> inorder = new ArrayList<Integer>();
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			// always try to got the left side to see if there is any node should be traversed before the cur node.
			// cur node is stored on stack since it has not been traversed yet.
			if (cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			}else {
				// if can not go left, meaning all the nodes on the left side of top node on stack have been traversed,
				// the next traversing node should be the top node on stack.
				cur = stack.pollFirst();
				inorder.add(cur.key);
				// the next subtree we want to traverse is cur.right;
				cur = cur.right;
			}
			
		}//end while
		
		return inorder;	
	}
}
