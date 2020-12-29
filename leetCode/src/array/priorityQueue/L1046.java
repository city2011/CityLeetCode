package array.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class L1046 {
    public static void main(String[] args) {
        L1046 m = new L1046();
        int res = m.lastStoneWeight(new int [] {2,7,4,1,8,1});
        System.out.println(res);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
        for(int a : stones){
            queue.offer(a);
        }
        while(queue.size() > 1){
            int a = queue.poll();
            int b = queue.poll();
            if(a > b){
                queue.offer(a - b);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
