package context.cd27;

import java.util.*;

public class L5410 {
    public static void main(String[] args) {
        L5410 main = new L5410();

        int[][] prerequisites = {{0,1},{1,2},{2,3},{3,4}};
        int[][] queries = {{0,4},{4,0},{1,3},{3,0}};

        List<Boolean> res = main.checkIfPrerequisite(5, prerequisites, queries);
        System.out.println(res);

    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Set<Integer> [] req = new HashSet[n];

        for(int [] pr : prerequisites){
            if(req[pr[0]] == null) {
                req[pr[0]] = new HashSet<>();
                req[pr[0]].add(pr[1]);
            } else {
                req[pr[0]].add(pr[1]);
            }
        }

        List<Boolean> ans = new ArrayList<>();
        boolean[][] isCalculated = new boolean[n][n];
        boolean[][] cache = new boolean[n][n];

        for(int [] query : queries){
            ans.add(isPre(query[0], query[1], req, isCalculated, cache));
        }

        return ans;
    }

    boolean isPre(int a, int b, Set<Integer> [] req, boolean[][] isCalculated, boolean[][] cache){
        if(isCalculated[a][b]){
            return cache[a][b];
        }
        isCalculated[a][b] = true;
        if(a == b){
            cache[a][b] = true;
            return true;
        }
        if(req[a] == null){
            cache[a][b] = false;
            return false;
        }
        for(Integer i : req[a]){
            isCalculated[a][i] = true;
            cache[a][i] = true;
            if(isPre(i, b, req, isCalculated, cache)){
                cache[a][b] = true;
                return true;
            }
        }

        cache[a][b] = false;
        return false;
    }
}
