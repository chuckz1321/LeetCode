package ByteDance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-07
 */
public class PathSum {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        int total = 0;
        LinkedList<Integer> list = new LinkedList<>();
        dfs(root, sum, total, list);
        return res;
    }

    private void dfs(TreeNode root, int sum, int total, LinkedList<Integer> list) {
        if (root == null) return;
        if (total + root.val == sum && root.left == null && root.right == null) {
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.removeLast();
            return;
        }
        list.add(root.val);
        dfs(root.left, sum, total + root.val, list);
        dfs(root.right, sum, total + root.val, list);
        list.removeLast();
    }

    public static void main(String[] args) {
        PathSum p = new PathSum();
        TreeNode tree = new TreeNode(-2);
        tree.right = new TreeNode(-3);
        p.pathSum(tree, -5);
    }
}
