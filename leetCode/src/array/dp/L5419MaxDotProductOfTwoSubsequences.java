package array.dp;

import java.util.Arrays;

/**
 *@author city
 *
 *######## 题目描述 ########
 *
 * Given two arrays nums1 and nums2.
 *
 * Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.
 *
 * A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).
 *
 *
 * Example 1:
 *
 * Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * Output: 18
 * Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
 * Their dot product is (2*3 + (-2)*(-6)) = 18.
 * Example 2:
 *
 * Input: nums1 = [3,-2], nums2 = [2,-6,7]
 * Output: 21
 * Explanation: Take subsequence [3] from nums1 and subsequence [7] from nums2.
 * Their dot product is (3*7) = 21.
 * Example 3:
 *
 * Input: nums1 = [-1,-1], nums2 = [1,1]
 * Output: -1
 * Explanation: Take subsequence [-1] from nums1 and subsequence [1] from nums2.
 * Their dot product is -1.
 *  
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 500
 * -1000 <= nums1[i], nums2[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-dot-product-of-two-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Use dynamic programming, define DP[i][j] as the maximum dot product of two subsequences starting in the position i of nums1 and position j of nums2.
 *
 *@date 10:43 PM 2020/5/24
 */
public class L5419MaxDotProductOfTwoSubsequences {
    private static L5419MaxDotProductOfTwoSubsequences ourInstance
            = new L5419MaxDotProductOfTwoSubsequences();

    public static L5419MaxDotProductOfTwoSubsequences getInstance() {
        return ourInstance;
    }

    private L5419MaxDotProductOfTwoSubsequences() {

    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length==0){
            return 0;
        }

        int dp [][] = new int[nums1.length][nums2.length];
        dp[0][0] = nums1[0] * nums2[0];

        if(nums2[0] > 0){
            int max1 = nums1[0];
            for(int i = 1; i < nums1.length; i++) {
                max1 = Math.max(nums1[i], max1);
                dp[i][0] = max1 * nums2[0];
            }
        } else {
            int min1 = nums1[0];
            for(int i = 1; i < nums1.length; i++) {
                min1 = Math.min(nums1[i], min1);
                dp[i][0] = min1 * nums2[0];
            }
        }

        if(nums1[0] > 0){
            int max1 = nums2[0];
            for(int i = 1; i < nums2.length; i++) {
                max1 = Math.max(nums2[i], max1);
                dp[0][i] = max1 * nums1[0];
            }
        } else {
            int min1 = nums2[0];
            for(int i = 1; i < nums2.length; i++) {
                min1 = Math.min(nums2[i], min1);
                dp[0][i] = min1 * nums1[0];
            }
        }

        for(int i = 1; i < nums1.length; i++){
            for(int j = 1; j < nums2.length; j++){
                dp[i][j] = nums1[i]*nums2[j];
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + dp[i][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
            }
        }

        for(int[] level : dp){
            System.out.println(Arrays.toString(level));
        }

        return dp[nums1.length-1][nums2.length-1];
    }

    public static void main(String[] args) {
        int [] nums1 = {-1,-1};
        int [] nums2 = {1,1};
        int ans = getInstance().maxDotProduct(nums1, nums2);
        System.out.println(ans);
    }
}