package aa;

import java.util.LinkedList;

/*
 * Serialize and Deserialize BST
 * 
 * Serialization is the process of converting a data structure or object into a sequence of bits so that 
 * it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later
 * in the same or another conmputer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree.
 * There is not restriction on how your serialization/deserialization algorithm should work.
 * 
 * You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * 
 * the encoded string should be as compact as possible.
 * 
 * 
 * 
 * 
 */

public class SerializeAndDeserializeBST {

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode t = queue.poll();
			if (t != null) {
				sb.append(String.valueOf(t.val) + ",");
				queue.add(t.left);
				queue.add(t.right);
			} else {
				sb.append("#,");
			}
		}

		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}
		String[] arr = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		int i = 1;
		while (!queue.isEmpty()) {
			TreeNode t = queue.poll();
			if (t == null) {
				continue;
			}
			if (!arr[i].equals("#")) {
				t.left = new TreeNode(Integer.parseInt(arr[i]));
				queue.offer(t.left);
			} else {
				t.left = null;
				queue.offer(null);
			}
			i++;

			if (!arr[i].equals("#")) {
				t.right = new TreeNode(Integer.parseInt(arr[i]));
				queue.offer(t.right);
			} else {
				t.right = null;
				queue.offer(null);
			}
			i++;
		}
		return root;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		serialize(root);
	}

}
