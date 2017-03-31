package ff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
 * Binary tree vertical order traversal
 * 
 * Given a binary tree, return the vertical order traversal of its nodes't values.
 * (i.e. from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * Examples:
 * 1. Given binary tree [ 3,9,20,null,null,15,7].
 *        3
 *     9      20
 *         15    7
 * 
 * return its vertical order traversal as:
 * [
 *   [9],
 *   [3,15],
 *   [20],
 *   [7]
 * ]
 * 
 * 2. Given binary tree [ 3,9,8,4,0,1,7]
 *            3
 *        9      8
 *      4    01     7
 * return its vertical order traversal as:
 * [ 
 *   [4],
 *   [9],
 *   [3,0,1],
 *   [8],
 *   [7]
 * ]
 * 
 * 3. Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
 *           3
 *        9     8
 *      4    01    7
 *        5     2
 * 
 * return its vertical order traversal as:
 * [
 *   [4],
 *   [9,5],
 *   [3,0,1],
 *   [8,2],
 *   [7]
 * ]
 * 
 */

public class BinaryTreeVerticalOrderTraversal {

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private class Cell {
		TreeNode node;
		int col;

		public Cell(TreeNode n, int col) {
			this.node = n;
			this.col = col;
		}
	}

	// solution 1:
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		Queue<Cell> queue = new LinkedList<Cell>();
		queue.add(new Cell(root, 0));
		List<Integer> tmpList = new ArrayList<Integer>();
		tmpList.add(root.val);

		while (!queue.isEmpty()) {
			Cell cur = queue.poll();
			if (cur.node.left != null) {
				queue.offer(new Cell(cur.node.left, cur.col - 1));
			}
			if (cur.node.right != null) {
				queue.offer(new Cell(cur.node.right, cur.col + 1));
			}
			int currentCol = cur.col;
			if (!map.containsKey(currentCol)) {
				// create a new arraylist
				ArrayList<Integer> newList = new ArrayList<Integer>();
				newList.add(cur.node.val);
				map.put(currentCol, newList);
			} else {
				ArrayList<Integer> oldList = map.get(currentCol);
				oldList.add(cur.node.val);
				map.put(currentCol, oldList);
			}
		} // end while

		result.addAll(map.values());
		return result;
	}

	/**
	 * Solution 2 (better time complexity)
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> verticalOrder2(TreeNode root) {
		List<List<Integer>> cols = new ArrayList<>();
		if (root == null) {
			return cols;
		}

		int[] range = new int[] { 0, 0 };
		getRange(root, range, 0);

		for (int i = range[0]; i <= range[1]; i++) {
			cols.add(new ArrayList<Integer>());
		}

		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> colQueue = new LinkedList<>();

		queue.add(root);
		colQueue.add(-range[0]);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int col = colQueue.poll();

			cols.get(col).add(node.val);

			if (node.left != null) {
				queue.add(node.left);
				colQueue.add(col - 1);
			}
			if (node.right != null) {
				queue.add(node.right);
				colQueue.add(col + 1);
			}
		}

		return cols;
	}

	public void getRange(TreeNode root, int[] range, int col) {
		if (root == null) {
			return;
		}
		range[0] = Math.min(range[0], col);
		range[1] = Math.max(range[1], col);

		getRange(root.left, range, col - 1);
		getRange(root.right, range, col + 1);
	}

	/**
	 * Solution 3, BFS as well
	 */
	public List<List<Integer>> verticalOrder3(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();

		q.add(root);
		cols.add(0);

		int min = 0;
		int max = 0;

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int col = cols.poll();

			if (!map.containsKey(col)) {
				map.put(col, new ArrayList<Integer>());
			}
			map.get(col).add(node.val);

			if (node.left != null) {
				q.add(node.left);
				cols.add(col - 1);
				min = Math.min(min, col - 1);
			}

			if (node.right != null) {
				q.add(node.right);
				cols.add(col + 1);
				max = Math.max(max, col + 1);
			}
		}

		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}

		return res;
	}

}
