package array.priorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L1723 {
    public static void main(String[] args) {
        L1723 m = new L1723();
        int ans = m.minimumTimeRequired(new int[] {2,4,5,7,2,7,9,4,6}, 5);
        System.out.println(ans);
    }

    public int minimumTimeRequired(int[] jobs, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            priorityQueue.add(0);
        }
        Arrays.sort(jobs);
        for (int i = jobs.length - 1; i >= 0; i++) {
            int tmpMin = priorityQueue.poll();
            priorityQueue.add(jobs[i] + tmpMin);
        }
        return priorityQueue.stream().max(Comparator.comparingInt(x -> x)).get();
    }
}