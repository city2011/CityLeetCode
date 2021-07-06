package crackingTCI;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LCP07 {
    public static void main(String[] args) {
        LCP07 m = new LCP07();
        m.numWays(5,new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}}, 3);
    }

    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> path = new HashMap<>();
        for(int i = 0; i < n; i++) {
            path.put(i, new HashSet<>());
        }
        for(int [] r : relation) {
            path.get(r[0]).add(r[1]);
        }

        Map<Integer, Integer> pointPath = new HashMap<>();
        pointPath.put(0, 1);
        for(int i = 0; i < k; i++) {
            Map<Integer, Integer> tmp = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : pointPath.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                Set<Integer> target = path.get(key);
                for(Integer eachKey : target) {
                    tmp.put(eachKey, tmp.getOrDefault(eachKey, 0) + value);
                }
            }
            if(tmp.size() < 1)
                return 0;
            pointPath = tmp;
        }

        return pointPath.get(n - 1) == null ? 0 : pointPath.get(n - 1);
    }
}
