package ByteDance;

import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-05-25
 */
public class PostOrder {

    public List<Integer> postOrder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        stack.add(root);
        while (stack.size() > 0) {
            TreeNode tmp = stack.pollLast();
            res.addFirst(tmp.val);
            if (tmp.left != null) stack.add(tmp.left);
            if (tmp.right != null) stack.add(tmp.right);
        }
        return res;
    }
}
