package dp.stocks;

import java.util.Arrays;

public class Stocks6 {
    public static void main(String[] args) {
        Stocks6 m = new Stocks6();
        int [] prices = {7,1,5,3,6,4};

        int ans11 = m.maxProfit11(prices);
        System.out.println(ans11);

        int ans12 = m.maxProfit12(prices);
        System.out.println(ans12);

        int ans13 = m.maxProfit13(prices);
        System.out.println(ans13);

        int [] prices2 = {7,1,5,3,2,1};
        int ans21 = m.maxProfit21(prices2);
        System.out.println(ans21);

        int ans22 = m.maxProfit22(new int [] {});
        System.out.println(ans22);

        int [] prices3 = {1,4,2,8,3,9};
        int ans31 = m.maxProfit31(prices3);
        System.out.println(ans31);

        int ans32 = m.maxProfit32(prices2);
        System.out.println(ans32);

        System.out.println("**********");
        int ans41 = m.maxProfit41(3, prices3);
        System.out.println(ans41);
    }

    /**
    @author city
    @date 2:03 AM 2020/8/11
     
    ############################################# 题目描述 #############################################

    121. 买卖股票的最佳时机
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

    如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

    注意：你不能在买入股票前卖出股票。



    示例 1:

    输入: [7,1,5,3,6,4]
    输出: 5
    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
    示例 2:

    输入: [7,6,4,3,1]
    输出: 0
    解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
    
    ############################################# 题目描述 #############################################
     */
    private int maxProfit11(int[] prices) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }
        // dp[x][0] 表示第x天不持有股票
        // dp[x][1] 表示第x天持有股票
        int [][] dp = new int [n][2];
        dp[0][1] = -prices[0];

        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][1] + prices[i]);
            // 最多只能买一次
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[n - 1][0];
    }

    private int maxProfit12(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    private int maxProfit13(int[] prices) {
        int n = prices.length;
        int min = prices[0], ans = 0;
        for(int i = 0; i < n; i++){
            if(prices[i] > min){
                ans = Math.max(prices[i] - min, ans);
            } else {
                min = prices[i];
            }
        }
        return ans;
    }


    /**
    @author city
    @date 3:41 PM 2020/8/11

    ############################################# 题目描述 #############################################

    122. 买卖股票的最佳时机 II
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

    示例 1:
    输入: [7,1,5,3,6,4]
    输出: 7
    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
    示例 2:

    输入: [1,2,3,4,5]
    输出: 4
    解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
    因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
    示例 3:

    输入: [7,6,4,3,1]
    输出: 0
    解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

    ############################################# 题目描述 #############################################
     */
    private int maxProfit21(int[] prices) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }
        // dp[x][0] 表示第x天不持有股票
        // dp[x][1] 表示第x天持有股票
        int [][] dp = new int [n][2];
        dp[0][1] = -prices[0];

        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 只要能买，就能买
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }

    private int maxProfit22(int[] prices) {
        int n = prices.length;
        int ans = 0;
        for(int i = 1; i < n; i++){
            if(prices[i] > prices[i - 1]){
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }


    /**
    @author city
    @date 3:49 PM 2020/8/11

    ############################################# 题目描述 #############################################

    123. 买卖股票的最佳时机 III
    给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

    设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

    注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

    示例 1:

    输入: [3,3,5,0,0,3,1,4]
    输出: 6
    解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
    随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
    示例 2:

    输入: [1,2,3,4,5]
    输出: 4
    解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
    因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
    示例 3:

    输入: [7,6,4,3,1]
    输出: 0
    解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。

    ############################################# 题目描述 #############################################
     */
    private int maxProfit31(int[] prices) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }

        int maxK= 2;
        int dp [][][] = new int[n][maxK + 1][2];

        dp[0][2][1] = Integer.MIN_VALUE;
        dp[0][1][1] = -prices[0];
//        dp[0][2][0] = Integer.MIN_VALUE;

        for(int i = 1; i < n; i++){
            for(int k = maxK; k > 0; k--){
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i + "  " + prices[i]);
            for (int j = 0; j < 3; j++) {
                System.out.println(Arrays.toString(dp[i][j]));
            }
            System.out.println();
            System.out.println();
        }


        return Math.max(dp[n - 1][maxK][0], Math.max(dp[n - 1][1][0], 0));
    }

    private int maxProfit32(int[] prices) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }

        int dp[][] = new int [n][5];

        // dp[i][j] ，表示 [0, i] 区间里，状态为 j 的最大收益
        // j = 0：什么都不操作
        // j = 1：第 1 次买入一支股票
        // j = 2：第 1 次卖出一支股票
        // j = 3：第 2 次买入一支股票
        // j = 4：第 2 次卖出一支股票
        dp[0][1] = -prices[0];
        dp[0][3] = Integer.MIN_VALUE;
        dp[0][4] = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return Math.max(dp[n - 1][4], Math.max(dp[n - 1][2], 0));
    }

    /**
    @author city
    @date 5:54 PM 2020/8/12

    ############################################# 题目描述 #############################################

    188. 买卖股票的最佳时机 IV
    给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

    设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

    注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

    示例 1:

    输入: [2,4,1], k = 2
    输出: 2
    解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
    示例 2:

    输入: [3,2,6,5,0,3], k = 2
    输出: 7
    解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
    随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

    ############################################# 题目描述 #############################################
     */
    // k很大的情况下，会超出内存
    private int maxProfit41(int k, int[] prices) {
        int n = prices.length;
        if(n < 2 || k == 0){
            return 0;
        }

        int dp[][] = new int[k + 1][2];

        dp[1][1] = -prices[0];

        for (int i = 2; i < k + 1; i++) {
            dp[i][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < n; i++) {
            for (int j = k; j > 0; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
                System.out.println(i);
                System.out.println(Arrays.toString(dp[j]));
            }
        }

        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = Math.max(dp[i][0], ans);
        }
        return ans;
    }

    // 目前发现这个方法最好
    //
    private int maxProfit42(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0){
            return 0;
        }
        if (k >= n / 2){
            int res = 0;
            for (int i = 1; i < n; i ++){
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i < dp.length; i ++){
            int maxDiff = -prices[0];
            for (int j = 1; j < dp[0].length; j ++){
                maxDiff = Math.max(maxDiff, dp[i - 1][j - 1] - prices[j]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
            }
        }
        return dp[k][n - 1];
    }


    /**
     * @author city
     * @date 11:47 PM 2020/7/10
     * <p>
     * ############################################# 题目描述 #############################################
     * <p>
     * 309. 最佳买卖股票时机含冷冻期 （题型5）
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
     * <p>
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * <p>
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 示例:
     * <p>
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     * <p>
     * <p>
     * ############################################# 题目描述 #############################################
     */
    public int maxProfit51(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 根据状态转换图。前一天就持有股票，前一天未持有可买入，可以转换到dp[i][]的状态
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // 根据状态转换图。前一天就持有股票，卖出可以转换到dp[i][1]的状态
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 根据状态转换图。前一天未持有股票(包括不可买入和可买入)，保持未持有可以转换到dp[i][2]的状态.
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }

    // 从maxProfit51 简化而来，使用滚动数组
    public int maxProfit52(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < n; ++i) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }

        return Math.max(f1, f2);
    }

    /**
    @author city
    @date 7:19 PM 2020/8/12

    ############################################# 题目描述 #############################################

    714. 买卖股票的最佳时机含手续费
    给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

    你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

    返回获得利润的最大值。

    注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

    示例 1:

    输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
    输出: 8
    解释: 能够达到的最大利润:
    在此处买入 prices[0] = 1
    在此处卖出 prices[3] = 8
    在此处买入 prices[4] = 4
    在此处卖出 prices[5] = 9
    总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
    注意:

    0 < prices.length <= 50000.
    0 < prices[i] < 50000.
    0 <= fee < 50000.

    ############################################# 题目描述 #############################################
     */
    private int maxProfit61(int[] prices, int fee) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }

        int [][] dp = new int [n][2];

        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];

    }

    private int maxProfit62(int[] prices, int fee){
        int dp_i_0 = 0, dp_i_1 = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i] - fee);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }
        return dp_i_0;
    }

}
