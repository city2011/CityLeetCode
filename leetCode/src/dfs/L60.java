package dfs;

import java.util.*;

public class L60 {


        public String getPermutation(int n, int k) {
            int[] factorial = new int[n];
            factorial[0] = 1;
            for (int i = 1; i < n; ++i) {
                factorial[i] = factorial[i - 1] * i;
            }

            --k;
            StringBuffer ans = new StringBuffer();
            int[] valid = new int[n + 1];
            Arrays.fill(valid, 1);
            for (int i = 1; i <= n; ++i) {
                int order = k / factorial[n - i] + 1;
                for (int j = 1; j <= n; ++j) {
                    order -= valid[j];
                    if (order == 0) {
                        ans.append(j);
                        valid[j] = 0;
                        break;
                    }
                }
                k %= factorial[n - i];
            }
            return ans.toString();
        }

}
