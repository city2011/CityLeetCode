package dfs;

import java.util.*;

/**
@author city
@date 11:43 PM 2020/9/3
 
############################################# 题目描述 #############################################

n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。


给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。


示例：

输入：4
输出：[
[".Q..",  // 解法 1
"...Q",
"Q...",
"..Q."],

["..Q.",  // 解法 2
"Q...",
"...Q",
".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。
 

提示：
皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

############################################# 题目描述 #############################################
 */
public class L51NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagnals1 = new HashSet<>();
        Set<Integer> diagnals2 = new HashSet<>();
        int [] queens = new int [n];
        Arrays.fill(queens, -1);

        backTrace(queens, 0, n, columns, diagnals1, diagnals2, solutions);
        return solutions;
    }

    private void backTrace(int[] queens, int row, int n, Set<Integer> columns, Set<Integer> diagnals1, Set<Integer> diagnals2, List<List<String>> solutions) {
        if(row == n){
            solutions.add(generateBoard(queens, n));
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

                backTrace(queens, row + 1, n, columns, diagnals1, diagnals2, solutions);

                queens[row] = -1;
                columns.remove(i);
                diagnals1.remove(diagonal1);
                diagnals2.remove(diagonal2);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char [] line = new char[n];
            Arrays.fill(line, '.');
            line[queens[i]] = 'Q';
            ans.add(new String(line));
        }
        return ans;
    }
}
