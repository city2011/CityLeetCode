package topK;

import java.util.*;

public class L347 {
    public static void main(String[] args) {
        L347 m = new L347();
        int[] input = {1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 7, 8, 8, 8};
        int[] res = m.topKFrequent(input, 3);
        System.out.println(Arrays.toString(res));
    }

    private int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        freqs.forEach((num, count) -> {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (count > freqs.get(pq.peek())) {
                pq.poll();
                pq.offer(num);
            }
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }

//    private int[] topKFrequent2(int[] nums, int k) {
//
//    }
}