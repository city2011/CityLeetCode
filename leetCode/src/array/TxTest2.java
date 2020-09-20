package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TxTest2 {
    public static void main(String[] args) {
        TxTest2 tx = new TxTest2();
        int [] nums = {1,2,3,4,5,6,7};
        tx.rotate(nums, 7, 3);
    }

    private ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2){
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int nextNum = 0;
        while(listNode1 != null || listNode2 != null){
            int x = listNode1 == null ? 0 : listNode1.value;
            int y = listNode1 == null ? 0 : listNode1.value;
            int sum = x + y + nextNum;

            nextNum = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(listNode1 != null){
                listNode1 = listNode1.next;
            }
            if(listNode2 != null){
                listNode2 = listNode2.next;
            }
        }
        if(nextNum == 1){
            cur.next = new ListNode(nextNum);
        }
        return head.next;
    }

    class ListNode {
        int value;
        ListNode next;
        ListNode(int v){
            value = v;
        }
    }

    private void rotate(int[] nums, int numsSize, int k){
        // 这里的numsize 在java中可以用 length代替
        int n = nums.length;
        if(k % n == 0){
            return;
        }
        k = k % n;
        int [] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = nums[i];
        }

        for (int i = 0; i < n - k; i++) {
            nums[i] = nums[i + k];
        }

        for(int i = 0; i < k; i++){
            nums[i + k + 1] = tmp[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    private void rotate2(int[] nums, int numsSize, int k) {
        // 这里的numsize 在java中可以用 length代替
        int n = nums.length;
        if (k % n == 0) {
            return;
        }
        k = k % n;

        for (int i = 0; i < k; i++) {
            swap(nums, i, i + n - k);
        }
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private int lengthOfLongestSubstring(char [] s){
        Map<Character, Integer> mem = new HashMap<>();
        int last = -1;
        int res = 0;
        for (int i = 0; i < s.length; i++) {
            if(mem.containsKey(s[i])){
                last = Math.max(last, mem.get(s[i]));
            }
            mem.put(s[i], i);
            res = Math.max(res, i - last);
        }
        return res;
    }
}
