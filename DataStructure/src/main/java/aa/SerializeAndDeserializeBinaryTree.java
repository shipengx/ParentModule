package aa;

import java.util.LinkedList;

/*
 * Serialize and Deserialize Binary Tree
 * 
 * serialization is the process of converting a data struture or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized 
 * to the original tree structure.
 * 
 * For example, you may serialize the following tree
 * 
 *       1
 *     2    3  
 *        4   5
 * 
 * as "[1,2,3,null,null,4,5]".
 * You do not necessarily need to follow this format, so please be creative and come up with different approaches your self.
 * 
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithm should be stateless.
 * 
 * 
 */

public class SerializeAndDeserializeBinaryTree {

	// Encodes a tree to a single string
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode t = queue.poll();
			if (t != null) {
				sb.append(String.valueOf(t.val + ","));
				queue.add(t.left);
				queue.add(t.right);
			}else {
				sb.append("#,");
			}
		}//end while
		
		sb.deleteCharAt(sb.length() -1);
		return sb.toString();
	}
	
	// Decodes your encoded data to a tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}
		
		String[] array = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(array[0]));
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		int i = 1;
		while (!queue.isEmpty()) {
			TreeNode t = queue.poll();
			
			if (t == null) {
				continue;
			}
			
			if (!array[i].equals("#")) {
				t.left = new TreeNode(Integer.parseInt(array[i]));
				queue.offer(t.left);
			}else {
				t.left = null;
				queue.offer(null);
			}
			i++;
			
			if (!array[i].equals("#")) {
				t.right = new TreeNode(Integer.parseInt(array[i]));
				queue.offer(t.right);
			}else {
				t.right = null;
				queue.offer(null);
			}
			i++;
		}//end while
		
		return root;
	}
}
