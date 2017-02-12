package aa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Binary Tree Right Side View
 * 
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of nodes you can see ordered from top to bottom.
 * 
 * For example,
 * Given the following binary tree,
 * 
 *         1         <------
 *     2      3      <------
 *       5      4    <------
 *       
 * You should return [1,3,4].
 * 
 * 
 */

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		
		if (root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			// get size here
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				
				// the first element in the queue (right-most of the tree)
				if (i == 0) {
					result.add(tmp.val);
				}
				
				// add right first
				if (tmp.right != null) {
					queue.add(tmp.right);
				}
				// add left 
				if (tmp.left != null) {
					queue.add(tmp.left);
				}
			}
		} // end while
		
		return result;
	}
	
}
