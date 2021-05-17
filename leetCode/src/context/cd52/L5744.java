package context.cd52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L5744 {
    public static void main(String[] args) {
        L5744 m = new L5744();
        m.rotateTheBox(new char [] [] {{'#','.','#'}});
    }

    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char[][] ans = new char[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], '.');
        }

        for (int i = n - 1; i >= 0; i--) {
            List<int[]> stones = new ArrayList<>();
            int count = 0;
            int idx = 0;
            for (int j = m - 1; j >=0; j--) {
                if(box[i][j] == '*') {
                    ans[j][n - 1 - i] = '*';
                    if(count > 0) {
                        stones.add(new int[]{idx, count});
                        count = 0;
                    }
                    idx = m - j;
                }
                if(box[i][j] == '#') {
                    count++;
                }
            }

            if(count > 0) {
                stones.add(new int[]{idx, count});
            }

            for(int [] stone : stones) {
                for(int k = 0; k < stone[1]; k++){
                    ans[m - 1 - (stone[0] + k)][n - 1 - i] ='#';
                }
            }
        }
        return ans;
    }
}
