package dp;

import java.util.Arrays;

public class L1142LongestCommonSubSequence {
    public static void main(String[] args) {
        L1142LongestCommonSubSequence m = new L1142LongestCommonSubSequence();
        int ans = m.longestCommonSubsequence("abcde", "ace");
        System.out.println(ans);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j) ?
                                   dp[i][j] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }

        for(int[] ddp : dp){
            System.out.println(Arrays.toString(ddp));
        }

        int max = 0;
        for(int k = 0; k <= m; k++){
            max = Math.max(max, dp[n][k]);
        }

        return max;
    }
}
