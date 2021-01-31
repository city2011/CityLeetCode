package graph.union_find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L778SwimInRisingWater {
    public static void main(String[] args) {
        L778SwimInRisingWater m = new L778SwimInRisingWater();
        int ans = m.swimInWater(new int [][] {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}});
        System.out.println(ans);
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        List<int[]> trip = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
               trip.add(new int [] {grid[i][j], i * n + j});
            }
        }
        DisjoinUionSet dus = new DisjoinUionSet(n * n);
        int bottomRight = n * n - 1;

        trip.sort(Comparator.comparing(e -> e[0]));
//        trip.forEach(x -> System.out.print(Arrays.toString(x)));

        for (int i = 0; i < trip.size() - 1; i++) {
            System.out.println(Arrays.toString(trip.get(i)));
            System.out.println(Arrays.toString(trip.get(i + 1)));
            dus.union(trip.get(i)[1], trip.get(i + 1)[1]);
            if (dus.isConnected(0, bottomRight)) return trip.get(i + 1)[0];
        }

        return 0;
    }

    class DisjoinUionSet {
        int [] parent;
        int [] rank;

        public DisjoinUionSet(int n){
            parent = new int [n];
            rank = new int [n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        int find(int x){
            return x == parent[x] ? x : (parent[x] = find(parent[x]));
        }

        void union(int a, int b){
            int fa = find(a);
            int fb = find(b);
            if(fa == fb) return;
            if(rank[fa] < rank[fb]){
                parent[fa] = fb;
                rank[fb] += rank[fa];
            } else {
                parent[fb] = fa;
                rank[fa] += rank[fb];
            }
        }

        boolean isConnected(int a, int b){
            return find(a) == find(b);
        }
    }
}
