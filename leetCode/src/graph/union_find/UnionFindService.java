package graph.union_find;

public class UnionFindService {
    private int[] parent;
    private int[] rank;
    private int count;

    public UnionFindService(int n){
        parent = new int [n];
        rank = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
        count = n;
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
            parent[i] = findRootUsingPS(parent[i]);
        }
        return parent[i];
    }

    public int union(int i, int j){
        int fi = findRoot(i);
        int fj = findRoot(j);
        if(fi == fj){
            return -1;
        }
        count--;
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

    public boolean isUnion(int a, int b){
        return findRootUsingPS(a) == findRootUsingPS(b);
    }

    public int soloCount(){
        return count;
    }
}
