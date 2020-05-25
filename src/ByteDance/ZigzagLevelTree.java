package ByteDance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-03-18
 */
public class ZigzagLevelTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 1;
        LinkedList<Integer> tempList = new LinkedList<>();
        while (queue.size() > 0) {
            TreeNode curNode = queue.poll();
            if (curNode != null) {
                if (level % 2 == 0) {
                    tempList.addFirst(curNode.val);
                } else {
                    tempList.addLast(curNode.val);
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            } else {
                result.add(tempList);
                tempList = new LinkedList<>();
                if (queue.size() > 0) {
                    queue.add(null);
                    level ++;
                }
            }
        }
        return result;
    }
}
