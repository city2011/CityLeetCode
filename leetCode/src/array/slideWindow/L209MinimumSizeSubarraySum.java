package array.slideWindow;

public class L209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        L209MinimumSizeSubarraySum m = new L209MinimumSizeSubarraySum();
        int s = 7;
        int [] nums = {1,3,7,7,7,7};
        int res = m.minSubArrayLen(s, nums);
        System.out.println(res);
    }

    private int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        int start = 0;
        int end = 0;
        while(end < nums.length) {
            sum += nums[end];
            while (sum >= s && start < nums.length) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
