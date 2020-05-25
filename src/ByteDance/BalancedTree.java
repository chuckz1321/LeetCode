package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-03-23
 */
public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
