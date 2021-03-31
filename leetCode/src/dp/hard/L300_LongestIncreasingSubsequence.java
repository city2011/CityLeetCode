package dp.hard;

public class L300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        L300_LongestIncreasingSubsequence m = new L300_LongestIncreasingSubsequence();
        int ans = lengthOfLIS(new int [] {5,7,-24,12,13,2,3,12,5,6,35});
        System.out.println(ans);
    }

    public static int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        int [] d = new int [n + 1];
        d[len] = nums[0];
        for(int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0;
                while(l <= r){
                    int mid = l + (r - l) / 2;
                    if(d[mid] < nums[i]){
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

}
