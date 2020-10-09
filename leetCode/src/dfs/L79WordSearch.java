package dfs;

public class L79WordSearch {
    public static void main(String[] args) {
        L79WordSearch m = new L79WordSearch();

        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        boolean res = m.exist2(board, "ABCBA");
        System.out.println(res);

        boolean res2 = m.exist(board, "ABCBA");
        System.out.println(res2);

        boolean res3 = m.exist3(board, "SEE");
        System.out.println(res3);
    }

    int dir[][] = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist2(char[][] board, String word) {
        int size = word.length();
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, 0, 0, word, 0, n, m, size)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx, int n, int m, int size) {
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }

        if (idx == size - 1) {
            return true;
        }

        for (int k = 0; k < 4; k++) {
            int newN = i + dir[k][0];
            int newM = j + dir[k][1];
            if ((newN < n && newM < m && newN >= 0 && newM >= 0) && dfs(board, newN, newM, word, idx + 1, n, m, size)) {
                return true;
            }
        }

        return false;
    }

    public boolean exist3(char[][] board, String word) {
        int size = word.length();
        int n = board.length;
        int m = board[0].length;
        boolean [][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs3(board, visited, i, j, word, 0, n, m, size)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs3(char[][] board, boolean [][] visited, int i, int j, String word, int idx, int n, int m, int size) {
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }

        if (idx == size - 1) {
            return true;
        }

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int newN = i + dir[k][0];
            int newM = j + dir[k][1];
            if (newN < n && newM < m && newN >= 0 && newM >= 0) {
                if(!visited[newN][newM] && dfs3(board, visited, newN, newM, word, idx + 1, n, m, size)) {
                        return true;
                }
            }
        }

        visited[i][j] = false;
        return false;
    }


    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
