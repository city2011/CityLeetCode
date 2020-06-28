package crackingTCI.mid16.base2;

import datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class B0201RemovingDuplicateNumber {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode pre = head;
        ListNode root = head;
        Set<Integer> sets = new HashSet<>();

        while(head != null){
            if(sets.contains(head.val)){
                pre.next = head.next;
            } else {
                sets.add(head.val);
                pre = head;

            }
            head = head.next;
        }
        return root;
    }

    // 不用额外的缓存空间
    // 两个指针，两次遍历，O(N^2)
    public ListNode removeDuplicateNodes2(ListNode head) {
        ListNode pre = head;

        while(pre != null){
            ListNode nc = pre;
            while(nc.next != null){
                if(pre.val == nc.next.val){
                    nc.next = nc.next.next;
                } else {
                    nc = nc.next;
                }
            }
            pre = pre.next;
        }
        return head;
    }
}
