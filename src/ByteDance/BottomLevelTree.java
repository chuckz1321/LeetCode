package ByteDance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-01
 */
public class BottomLevelTree {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> lis = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                lis.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            } else {
                result.addFirst(lis);
                if (!queue.isEmpty()) queue.offer(null);
                lis = new ArrayList<>();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        BottomLevelTree b  = new BottomLevelTree();
        b.levelOrderBottom(root);
    }
}
