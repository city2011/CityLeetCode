package array.priorityQueue;

import java.util.PriorityQueue;

public class L703KthLargest {

    public static void main(String[] args) {
        L703KthLargest m = new L703KthLargest();
        m.KthLargest(3, new int [] {4,5,8,2});
        System.out.println(m.add(3));
        System.out.println(m.add(5));
        System.out.println(m.add(10));
        System.out.println(m.add(9));
        System.out.println(m.add(4));
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int k = 0;

    public void KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        if(queue.size() < k - 1){
            queue.offer(val);
            return -1;
        } else if(queue.size() == k - 1){
            queue.offer(val);
            return queue.peek();
        } else {
            if(val < queue.peek()){
                return queue.peek();
            } else {
                queue.poll();
                queue.add(val);
                return queue.peek();
            }
        }
    }
}
