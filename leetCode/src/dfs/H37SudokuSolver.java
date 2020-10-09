package dfs;

/**
@author city
@date 11:30 PM 2020/9/15
 
############################################# 题目描述 #############################################

编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。



一个数独。



答案被标成红色。

Note:

给定的数独序列只包含数字 1-9 和字符 '.' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sudoku-solver
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

############################################# 题目描述 #############################################
 */
public class H37SudokuSolver {
    public static void main(String[] args) {
        H37SudokuSolver m = new H37SudokuSolver();
        char[][] board = new char[][]{
                {'1','.','.'},{'.','.','.'},{'.','.','.'}
        };
        m.solveSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        backTracing(board);
    }

    private boolean backTracing(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if(isValid(i, j, k, board)){
                        board[i][j] = (char)(0 + k);
                        if(backTracing(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, char val, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if(board[i][col] == val) return false;
        }

        for (int i = 0; i < board[0].length; i++) {
            if(board[row][i] == val) return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) { // 判断9方格里是否重复
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val ) {
                    return false;
                }
            }
        }

        return true;
    }

}
