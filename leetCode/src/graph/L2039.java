package graph;

import java.util.*;

public class L2039 {
    public static void main(String[] args) {
        int [][] edges = new int [][]{{0,1},{1,2}};
        int [] patience = new int [] {0,2,2};
        L2039 m = new L2039();
        int res = m.networkBecomesIdle(edges, patience);

        System.out.println(res);
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        Map<Integer, HashSet<Integer>> mem = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mem.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            mem.get(edge[0]).add(edge[1]);
            mem.get(edge[1]).add(edge[0]);
        }

        List<Integer> tmp = new ArrayList<>();
        tmp.add(0);
        int minDis = 0;
        int[] minDistance = new int[n];
        boolean[] record = new boolean[n];
        while (!tmp.isEmpty()) {
            List<Integer> next = new ArrayList<>();
            for (int x : tmp) {
                if (record[x]) {
                    continue;
                }
                if (minDistance[x] == 0)
                    minDistance[x] = minDis;
                next.addAll(mem.get(x));
                record[x] = true;
            }
            tmp = next;
            minDis++;
        }

        int maxTime = 0;
        for (int i = 1; i < n; i++) {
            int m = (minDistance[i]*2) % patience[i];
            if(m == 0) {
                maxTime = Math.max(maxTime, minDistance[i]*4  - patience[i] + 1);
            } else {
                maxTime = Math.max(maxTime, minDistance[i]*4 - m + 1);
            }
        }
        return maxTime;
    }
}
