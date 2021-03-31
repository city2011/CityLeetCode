package linkedlist;

import datastructure.ListNode;

// Todo:Revert linked list need to use recursive
public class L92RevertLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int step = right - left - 1;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;

        for(int i = 0; i < left - 1; i++){
            slow = slow.next;
        }
        ListNode pre = slow;

        pre.next = revertSub(slow.next, step);

        return dummy.next;
    }

    private ListNode revertSub(ListNode x, int step){
        ListNode y = x.next;
        ListNode dummy = x;
        ListNode nHead = x;
        for(int i = 0; i < step; i++){
            ListNode tmp = y.next;
            y.next = x;
            x = y;
            y = tmp;
        }
        dummy.next = y;
        return x;
    }
}
