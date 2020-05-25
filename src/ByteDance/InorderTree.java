package ByteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-01
 */
class InorderTree {
    public static List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        result.add(root.val);
        dfs(root.right);
    }
}
