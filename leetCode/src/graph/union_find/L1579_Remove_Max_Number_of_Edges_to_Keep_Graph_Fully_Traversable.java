package graph.union_find;

public class L1579_Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable {
    public static void main(String[] args) {
        L1579_Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable m = new L1579_Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable();
        int [][] edges = new int [][]
                {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};

        int ans = m.maxNumEdgesToRemove(4, edges);
        System.out.println(ans);
    }


    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointUnionSet aliceDus = new DisjointUnionSet(n);
        DisjointUnionSet bobDus = new DisjointUnionSet(n);
        int sum = edges.length;

        // union公共边
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                aliceDus.union(edge[1], edge[2], 0);
                bobDus.union(edge[1], edge[2], 0);
            }
        }

        // union独占边
        for (int [] edge : edges){
            if(edge[0] == 1){
                aliceDus.union(edge[1], edge[2], 1);
            } else if (edge[0] == 2){
                bobDus.union(edge[1], edge[2], 1);
            }
        }

        // 判断是否有解
        if(aliceDus.isConnected() && bobDus.isConnected()){
            int [] aliceStatics = aliceDus.getStatics();
            int [] bobStatics = bobDus.getStatics();
            return sum - (aliceStatics[0] + aliceStatics[1] + bobStatics[1]);
        }
        return -1;
    }

    static class DisjointUnionSet {
        int n;
        int [] parent;
        // 这个应该是我和官方题解的不同？我使用了一个内部数组，维护加入到并查集中公共边和独占边的数量
        int [] statics;
        int soles;

        DisjointUnionSet(int n){
            parent = new int [n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            statics = new int [2];
            soles = n;
        }

        int find(int a){
            if(parent[a] != a){
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }

        void union(int a, int b, int type){
            int fa = find(a);
            int fb = find(b);
            if (fa != fb){
                parent[fa] = fb;
                // 每有一个有效合并，有效边数加1 （通过type区分类型）
                statics[type]++;
                // 每有一个有效合并，独立并查集数量减1
                soles--;
            }
        }

        boolean isConnected(){
            return soles == 1;
        }

        int [] getStatics(){
            return statics;
        }
    }
}
