package aa;

/*
 * Transform to Sum tree
 * 
 * Given a binary tree where each node has positive and negative values.
 * Convert this to a tree where each node contains the sum of the left and righ sub trees in the original tree.
 * The values of leaf nodes are changed to 0.
 * 
 * For example, the following tree
 * 		   10
 *    -2        6
 *  8   -4    7   5
 *  
 *  should be changed to 
 *          20 (4-2+12 +6)
 *      4 (8-4)   12 (7 + 5)
 *   0    0     0    0
 * 
 * 
 */

public class ConvertAGivenTreeToItsSumTree {
	public void toSumTree(TreeNode root) {
		if (root == null)
			return;
		toSum(root);
	}

	int toSum(TreeNode node) {
		if (node == null)
			return 0;
		int old_val = node.val;
		node.val = toSum(node.left) + toSum(node.right);
		return node.val + old_val;
	}
}
