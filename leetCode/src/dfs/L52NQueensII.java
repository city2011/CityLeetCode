package dfs;

import java.util.*;

public class L52NQueensII {
    int ans = 0;

    public int solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagnals1 = new HashSet<>();
        Set<Integer> diagnals2 = new HashSet<>();

        int [] queens = new int [n];
        Arrays.fill(queens, -1);
        backTrace(queens, 0, n, columns, diagnals1, diagnals2);
        return ans;
    }

    private void backTrace(int[] queens, int row, int n, Set<Integer> columns, Set<Integer> diagnals1, Set<Integer> diagnals2) {
        if(row == n){
            ans++;
        } else {
            for (int i = 0; i < n; i++) {
                if(columns.contains(i)){
                    continue;
                }
                int diagonal1 = row - i;
                if(diagnals1.contains(diagonal1)){
                    continue;
                }
                int diagonal2 = row + i;
                if(diagnals2.contains(diagonal2)){
                    continue;
                }

                queens[row] = i;
                columns.add(i);
                diagnals1.add(diagonal1);
                diagnals2.add(diagonal2);
                backTrace(queens, row + 1, n, columns, diagnals1, diagnals2);
                queens[row] = -1;
                columns.remove(i);
                diagnals1.remove(diagonal1);
                diagnals2.remove(diagonal2);
            }
        }
    }
}
