package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-02
 */
public class List2BST {
    public ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next !=null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        return slow;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        ListNode mid = findMid(head);
        TreeNode res = new TreeNode(mid.val);
        if (head == mid) {
            return res;
        }
        res.left = sortedListToBST(head);
        res.right = sortedListToBST(mid.next);
        return res;
    }
}
