package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-02-26
 */
class ReverseKgroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            cur = reverseK(cur, k);
        }
        return dummy.next;
    }

    private ListNode reverseK(ListNode start, int k) {
        ListNode pre = start.next;
        ListNode cur = pre.next;
        boolean unfi = false;
        for (int i = 1; i < k; i++) {
            if (cur ==  null){
                unfi = true;
                break;
            }
            ListNode temp = cur.next;
            cur = pre;
            pre = cur;
            cur = temp;
        }
        return null;
    }
}
