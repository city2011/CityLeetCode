package linkedlist;

public class L328OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode s1 = head;
        ListNode s2 = head.next;
        ListNode dummy = s2;
        while (s2 != null && s2.next != null) {
            s1.next = s2.next;
            s1 = s1.next;

            if(s1.next != null) {
                s2.next = s1.next;
                s2 = s2.next;
            }
        }
        s1.next = dummy;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
