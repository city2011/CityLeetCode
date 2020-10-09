package context.c202;

/**
@author city
@date 10:24 PM 2020/8/23

############################################# 题目描述 #############################################

5498. 石子游戏 V 显示英文描述
通过的用户数384
尝试过的用户数748
用户总通过次数399
用户总提交次数1574
题目难度Hard
几块石子 排成一行 ，每块石子都有一个关联值，关联值为整数，由数组 stoneValue 给出。

游戏中的每一轮：Alice 会将这行石子分成两个 非空行（即，左侧行和右侧行）；Bob 负责计算每一行的值，即此行中所有石子的值的总和。Bob 会丢弃值最大的行，Alice 的得分为剩下那行的值（每轮累加）。如果两行的值相等，Bob 让 Alice 决定丢弃哪一行。下一轮从剩下的那一行开始。

只 剩下一块石子 时，游戏结束。Alice 的分数最初为 0 。

返回 Alice 能够获得的最大分数 。


示例 1：
输入：stoneValue = [6,2,3,4,5,5]
输出：18
解释：在第一轮中，Alice 将行划分为 [6，2，3]，[4，5，5] 。左行的值是 11 ，右行的值是 14 。Bob 丢弃了右行，Alice 的分数现在是 11 。
在第二轮中，Alice 将行分成 [6]，[2，3] 。这一次 Bob 扔掉了左行，Alice 的分数变成了 16（11 + 5）。
最后一轮 Alice 只能将行分成 [2]，[3] 。Bob 扔掉右行，Alice 的分数现在是 18（16 + 2）。游戏结束，因为这行只剩下一块石头了。
示例 2：

输入：stoneValue = [7,7,7,7,7,7,7]
输出：28
示例 3：

输入：stoneValue = [4]
输出：0


提示：

1 <= stoneValue.length <= 500
1 <= stoneValue[i] <= 10^6

############################################# 题目描述 #############################################
 */
public class L5498 {
    int[] values;
    Integer[][] dp;
    int n;

    public int stoneGameV(int[] stoneValue) {
        n = stoneValue.length;
        values = new int[n + 1];
        dp = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            values[i + 1] = values[i] + stoneValue[i];
        }
        return solve(stoneValue, 0, n - 1);
    }

    int solve(int[] stoneValue, int s, int e) {
        if (s == e) return 0;
        if (dp[s][e] != null) return dp[s][e];

        int res = 0;
        for (int i = s; i < e; i++) {
            int left = values[i + 1] - values[s];
            int right = values[e + 1] - values[i + 1];

            int tmp = 0;
            if (left > right) {
                tmp = right + solve(stoneValue, i + 1, e);
                res = Math.max(res, tmp);
            } else if (left < right) {
                tmp = left + solve(stoneValue, s, i);
                res = Math.max(res, tmp);
            } else {
                tmp = right + solve(stoneValue, i + 1, e);
                tmp = Math.max(tmp, left + solve(stoneValue, s, i));
                res = Math.max(res, tmp);
            }
        }
        dp[s][e] = res;
        return res;
    }
}
