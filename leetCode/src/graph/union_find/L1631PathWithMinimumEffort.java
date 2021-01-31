package graph.union_find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L1631PathWithMinimumEffort {
    public static void main(String[] args) {
        L1631PathWithMinimumEffort m = new L1631PathWithMinimumEffort();
        int ans = m.minimumEffortPath(new int [][] {{4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}});
        System.out.println(ans);
    }

    public int minimumEffortPath(int[][] heights) {
        List<int[]> edges = new ArrayList<>();

        int n = heights.length;
        int m = heights[0].length;

        for(int i = 0; i < n - 1; i++){
            for (int j = 0; j < m - 1; j++){
                int idx = i * m + j;
                edges.add(new int[] {Math.abs(heights[i][j + 1] - heights[i][j]), idx, idx + 1});
                edges.add(new int[] {Math.abs(heights[i + 1][j] - heights[i][j]), idx, idx + m});
            }
        }

        for (int j = 0; j < m - 1; j++) {
            int idx = (n - 1) * m + j;
            edges.add(new int[] {Math.abs(heights[n - 1][j + 1] - heights[n - 1][j]), idx,  idx + 1});
        }

        for (int i = 0; i < n - 1; i++) {
            int idx = (i + 1) * m - 1;
            edges.add(new int[] {Math.abs(heights[i + 1][m - 1] - heights[i][m - 1]), idx, idx + m});
        }

        edges.sort(Comparator.comparing(e -> e[0]));
        edges.forEach(x -> System.out.println(Arrays.toString(x)));

        UnionFindService uf = new UnionFindService(n * m);
        int rightBottom = n * m - 1;
        for(int [] edge : edges){
            uf.union(edge[1], edge[2]);
            if(uf.isUnion(0, rightBottom)){
                return edge[0];
            }
        }
        return -1;
    }
}
