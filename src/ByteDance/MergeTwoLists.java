package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-02-24
 */
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rtn = new ListNode(-1);
        ListNode k = rtn;
        while (l1 != null || l2 != null) {
            ListNode temp = null;
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    temp = l2;
                    l2 = l2.next;
                    temp.next = null;
                } else {
                    temp = l1;
                    l1 = l1.next;
                    temp.next = null;
                }
            } else if (l1 == null) {
                temp = l2;
                l2 = l2.next;
                temp.next = null;
            } else {
                temp = l1;
                l1 = l1.next;
                temp.next = null;
            }
            rtn.next = temp;
            rtn = rtn.next;
        }
        return k.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        MergeTwoLists.mergeTwoLists(l1, l4);
    }
}
