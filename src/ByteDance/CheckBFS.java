package ByteDance;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-01
 */
public class CheckBFS {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int tmp = Integer.MIN_VALUE;
        while (stack.size() > 0 || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= tmp) return false;
            tmp = root.val;
            root = root.right;
        }
        return true;
    }
}
