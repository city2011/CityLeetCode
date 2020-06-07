package JianzhiOffer;

public class E29ClockwiseSpinMatrix {
    public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int actions [][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 0;
        int ans [] = new int [n * m];
        int[] action = actions[0];
        int i = 0, j = 0;
        int idx = 0;

    }



    //    作者：jyd
    //    链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int[] spiralOrder_jyd(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i];
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r];
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i];
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l];
            if(++l > r) break;
        }
        return res;
    }

}
