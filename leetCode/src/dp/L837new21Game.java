package dp;

public class L837new21Game {

    public double new21Game2(int N, int K, int W) {
        if(K == 0)
            return 1.0;
        if(N - K + 1 >= W)
            return 1.0;

        double[] dp = new double[K + W];

        for(int i = K; i <= N && i < K + W; i++){
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * (N - K + 1) / W;
        for(int i = K - 2; i>=0; i--){
            dp[i] = dp[i+1] + (dp[i+1] - dp[i+1+W])/W;
        }
        return dp[0];
    }

    public double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K + W];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }
}
