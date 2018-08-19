package com.uwo.leetcode.SwapNodesinPairs;

//attention pls


// null have not subclass, so do not user object.equals()
public class Solution {

    private int temp;

    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;
        return swap(newHead).next;
    }

    public ListNode swap(ListNode head){
        if( head.next != null) {
            if( head.next.next != null){

                //swap
                ListNode tempNode = head.next;
                head.next = head.next.next;
                tempNode.next = head.next.next;
                head.next.next = tempNode;
                swap(head.next.next);
            }
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Solution s = new Solution();
        s.swapPairs(head);

    }
}

 class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
