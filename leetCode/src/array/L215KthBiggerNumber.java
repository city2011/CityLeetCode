package array;

import java.util.*;

public class L215KthBiggerNumber {

        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for(int num : nums){
                if (queue.size() < k)
                    queue.offer(num);
                else if (num > queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }

            return queue.peek();

        }

}
