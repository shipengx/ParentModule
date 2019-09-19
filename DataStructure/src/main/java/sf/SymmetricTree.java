package sf;

/**
 * Symmetric tree
 *
 * Given a binary tree, check whether it is a mirror of itself
 * (i.e. symmetric around its center).
 *
 * For example, this binary tree [1, 2, 2, 3, 4, 4, 3] is symmetric:
 *
 *               1
 *           2     2
 *         3  4   4  3
 *
 * But the following [1,2,2, null, 3, null, 3] is not:
 *
 *            1
 *         2     2
 *           3     3
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 */


public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.val != two.val) {
            return false;
        }
        return isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
    }

}
