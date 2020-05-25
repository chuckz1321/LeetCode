package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-02-24
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;

    }
}

