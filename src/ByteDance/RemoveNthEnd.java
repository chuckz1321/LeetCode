package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-03-04
 */
public class RemoveNthEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int now = 1;
        ListNode pre = dummy;
        while(head.next != null) {
            if (now >= n) {
                pre = pre.next;
            }
            head = head.next;
            now ++;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        RemoveNthEnd r = new RemoveNthEnd();
        r.removeNthFromEnd(l1, 3);
    }
}
