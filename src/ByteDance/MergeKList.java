package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-02-26
 */
public class MergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int len = lists.length;
        int inteval = 1;
        while (len > inteval) {
            for (int i = 0; i < len; i = i + inteval * 2) {
                if (i + inteval < len) {
                    lists[i] = mergeTwoNode(lists[i], lists[i + inteval]);
                }
            }
            inteval *= 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoNode(ListNode f, ListNode s) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (f != null && s != null) {
            if (f.val < s.val) {
                cur.next = f;
                f = f.next;
                cur = cur.next;
            } else {
                cur.next = s;
                s = s.next;
                cur = cur.next;
            }
        }
        if (f != null) {
            cur.next = f;
        }
        if (s != null) {
            cur.next = s;
        }
        return head.next;
    }

    public static void main(String[] args) {
        //[[-10,-9,-9,-3,-1,-1,0],[-5],[4],[-8],[],[-9,-6,-5,-4,-2,2,3],[-3,-3,-2,-1,0]]
        ListNode l10 = new ListNode(-10);
        ListNode l11 = new ListNode(-9);
        ListNode l12 = new ListNode(-9);
        ListNode l13 = new ListNode(-3);
        ListNode l14 = new ListNode(-1);
        ListNode l15 = new ListNode(-1);
        ListNode l16 = new ListNode(0);
        l10.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        ListNode l20 = new ListNode(-5);
        ListNode l30 = new ListNode(4);
        ListNode l40 = new ListNode(-8);
        ListNode l50 = null;
        ListNode l60 = new ListNode(-9);
        ListNode l61 = new ListNode(-6);
        ListNode l62 = new ListNode(-5);
        ListNode l63 = new ListNode(-4);
        ListNode l64 = new ListNode(-2);
        ListNode l65 = new ListNode(2);
        ListNode l66 = new ListNode(3);
        l60.next = l61;
        l61.next = l62;
        l62.next = l63;
        l63.next = l64;
        l64.next = l65;
        l65.next = l66;
        ListNode l70 = new ListNode(-3);
        ListNode l71 = new ListNode(-3);
        ListNode l72 = new ListNode(-2);
        ListNode l73 = new ListNode(1);
        ListNode l74 = new ListNode(0);
        l70.next = l71;
        l71.next = l72;
        l72.next = l73;
        l73.next = l74;
        ListNode[] lists = {l10,l20,l30,l40,l50,l60,l70};
        MergeKList m = new MergeKList();
        m.mergeKLists(lists);
    }
}
