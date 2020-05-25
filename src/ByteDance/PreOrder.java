package ByteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-05-25
 */
public class PreOrder {

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode tmp = stack.peek();
            res.add(tmp.val);
            if (tmp.right != null) stack.push(tmp.right);
            if (tmp.left != null) stack.push(tmp.left);
        }
        return res;
    }
}
