package context;

public class C5236 {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int cur = 0;
        int ans = 0;
        while (cur < n - 1) {
            if (nums[cur] == nums[cur+1]) {
                ans++;
                cur++;
            } else {
                cur+=2;
            }
        }
        if ((n - ans) % 2 != 0) {
            ans++;
        }
        return ans;
    }
}