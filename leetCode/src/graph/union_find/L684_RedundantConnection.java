package graph.union_find;

import java.util.Arrays;

public class L684_RedundantConnection {
    public static void main(String[] args) {
        L684_RedundantConnection m = new L684_RedundantConnection();
        int [] res = m.findRedundantConnection(new int [][]{{1,2},{1,3},{2,3}});
        System.out.println(Arrays.toString(res));
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFindService uf = new UnionFindService(n + 1);

        for(int [] edge :edges){
            if(uf.union(edge[0], edge[1]) == -1){
                return edge;
            }
        }

        return new int[0];
    }
}
