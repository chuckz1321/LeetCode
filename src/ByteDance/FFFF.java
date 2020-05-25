package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-10
 */
class FFFF {

    /**
     * 把从前向后数第 key 个节点与从后向前数第 key 个节点进行交换
     *
     * @param head 头结点
     * @param key 值
     * @return 交换后的链表
     */
    public ListNode swap(ListNode head, int key) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = dummy;
        while (fast.next != null && count != key) {
            fast = fast.next;
            count++;
        }
        ListNode first2Swap = fast;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode second2Swap = slow;
        int tmp = first2Swap.val;
        first2Swap.val = second2Swap.val;
        second2Swap.val = tmp;
        return dummy.next;
    }

}