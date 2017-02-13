package aa;

/*
 * Lowest common ancestor of a binary search tree
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * 
 * The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has 
 * both v and w as descendants (where we allow a node to be a descendant of itself).
 * 
 *           6
 *      2         8
 *    0   4     7   9
 *      3   5
 *      
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
 * Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to LCA definition.
 * 
 */


public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        return left!= null?left:right;
    }
}
