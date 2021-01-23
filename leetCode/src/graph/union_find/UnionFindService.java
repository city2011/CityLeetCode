package graph.union_find;

public class UnionFindService {
    private int[] parent;
    private int[] rank;

    public UnionFindService(int n){
        parent = new int [n];
        rank = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findRoot(int i){
        if(parent[i] == i){
            return i;
        } else {
            return findRoot(parent[i]);
        }
    }

    public int findRootUsingPS(int i){
        if(i != parent[i]){
            parent[i] = findRootUsingPS(i);
        }
        return parent[i];
    }

    public int union(int i, int j){
        int fi = findRoot(i);
        int fj = findRoot(j);
        if(fi == fj){
            return -1;
        }
        if(rank[fi] == rank[fj]){
            parent[fi] = fj;
            rank[fj]++;
            return fj;
        } else if (rank[fi] < rank[fj]){
            parent[fi] = fj;
            return fj;
        } else {
            parent[fj] = fi;
            return fi;
        }
    }
}
