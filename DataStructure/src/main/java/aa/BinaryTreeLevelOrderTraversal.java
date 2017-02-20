package aa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Binary tree level order traversal
 * 
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (i.e from left to right, level by level).
 * 
 * For example:
 * Given binary tree: [3,9,20,null,null,15,7]
 *     3
 *   9   20
 *     15  7
 *     
 * return its level order traversal as:
 * [
 *    [3],
 *    [9,20],
 *    [15,7]
 * ]
 * 
 */

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> path = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				if (tmp.left != null) {
					queue.add(tmp.left);
				}
				if (tmp.right != null) {
					queue.add(tmp.right);
				}
				path.add(tmp.val);
			}
			result.add(path);
		}

		return result;
	}

}
