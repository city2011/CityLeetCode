package graph.union_find;

public class L1319Operations2ConnectAllNodes {
    public static void main(String[] args) {
        L1319Operations2ConnectAllNodes m = new L1319Operations2ConnectAllNodes();
        int ans = m.makeConnected(4,  new int [][] {{0,1},{0,2},{1,2}});
        System.out.println(ans);
    }

    public int makeConnected(int n, int[][] connections) {
        DisconnectJoinUnion dju = new DisconnectJoinUnion(n);
        for(int [] conn : connections){
            dju.union(conn[0], conn[1]);
        }
        System.out.println(dju.count);
        System.out.println(dju.abandonEdge);
        return dju.stepsToConnectAll();
    }

    class DisconnectJoinUnion{
        int [] parent;
        int [] rank;
        int count;
        int abandonEdge;

        DisconnectJoinUnion(int n){
            parent = new int [n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
            count = n;
            abandonEdge = 0;
        }

        int find(int v){
            if(parent[v] != v){
                parent[v] = find(parent[v]);
            }
            return parent[v];
        }

        void union(int a, int b){
            int fa = find(a);
            int fb = find(b);
            if(fa == fb) {
                abandonEdge++;
                return;
            }
            if(rank[fa] == rank[fb]){
                parent[fa] = fb;
                rank[fb]++;
            } else if(rank[fa] < rank[fb]){
                parent[fa] = fb;
            } else {
                parent[fb] = fa;
            }
            count--;
        }

        int stepsToConnectAll(){
            if(abandonEdge - count + 1 >= 0){
                return count - 1;
            } else {
                return -1;
            }
        }
    }
}
