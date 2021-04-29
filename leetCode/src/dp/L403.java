package src.dp;

public class L403 {
    public static void main(String[] args) {
        L403 m = new L403();
        boolean ans1 = m.canCross(new int [] {0,1,3,5,6,8,12,17});
        System.out.println(ans1);
    }

    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean [][] dp = new boolean[n][n];
        dp[0][0] = true;

        for (int i = 1; i < n; i++) {
            if(stones[i] - stones[i - 1] > i)
                return false;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                int k = stones[i] - stones[j];
                if(k > j + 1)
                    break;
                dp[i][k] = dp[j][k] || dp[j][k - 1] || dp[j][k + 1];
                if(i == n - 1 && dp[i][k])
                    return true;
            }
        }
        return false;
    }
}
