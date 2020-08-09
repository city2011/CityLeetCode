package dp;

import binaryTree.TreeNode;

/**
@author city
@date 11:34 PM 2020/8/9
 
############################################# 题目描述 #############################################

https://leetcode-cn.com/problems/house-robber/
https://leetcode-cn.com/problems/house-robber-ii/
https://leetcode-cn.com/problems/house-robber-iii/submissions/

############################################# 题目描述 #############################################
 */
public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        int [] nums = {2,7,9,3,1};

        int ans1 = h.rob11(nums);
        System.out.println(ans1);

        int ans2 = h.rob11(nums);
        System.out.println(ans2);

        int ans3 = h.rob21Helper(nums, 0, nums.length - 1);
        System.out.println(ans3);
    }

    // 从前往后动态规划
    private int rob11(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n + 2];
        for (int i = 0; i < n; i++) {
            dp[i + 2] = Math.max(nums[i] + dp[i], dp[i + 1]);
        }
        return dp[n + 1];
    }

    // 从后往前动态规划
    private int rob12(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n + 2];
        for (int i = n - 1; i >= 0; i++) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }

    private int rob21(int[] nums){
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];

        return Math.max(rob21Helper(nums, 0, nums.length - 2),
                rob21Helper(nums, 1, nums.length - 1));
    }

    private int rob21Helper(int[] nums, int start, int end) {
        int a=0, b=0, c=0;
        for(int i = start; i <= end; i++){
            a = b;
            b = c;
            c = Math.max(a+nums[i], b);
        }
        return c;
    }

    public int rob3(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    // dfs计算的是当前节点 不抢该点(结果int[0]) 和 抢该点(结果int[1]) 的最大收益
    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
