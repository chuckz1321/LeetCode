package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-07
 */
public class SwapPair {
    /**
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode tmp = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            cur.next = tmp;
            pre = cur;
            cur = tmp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        SwapPair sp = new SwapPair();
        sp.swapPairs(head);
    }
}
