package dp;

import java.util.Arrays;

public class L1269_mid_complexity {
    public static void main(String[] args) {
        L1269_mid_complexity m = new L1269_mid_complexity();
        int ans = m.numWays(10, 4);
        System.out.println(ans);
    }

    public int numWays(int steps, int arrLen) {
        int mod = 1000000007;
        int thres = Math.min(arrLen, steps / 2 + 1);
        int [][] dp = new int [steps + 1][thres];

        dp[0][0] = 1;
        for(int i = 1; i < steps + 1; i++){
            for(int j = 0; j < thres; j++){
                dp[i][j] = dp[i - 1][j];
                if(j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
                if(j + 1 < thres){
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        for (int [] edp : dp){
            System.out.println(Arrays.toString(edp));
        }
        return dp[steps][0];
    }
}
