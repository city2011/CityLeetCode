package array;

import java.util.Arrays;

public class L238ProductofArrayExceptSelf {
    public static void main(String[] args) {
        L238ProductofArrayExceptSelf main = new L238ProductofArrayExceptSelf();

        int [] nums = {3};

        int ans [] = main.productExceptSelf(nums);
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n < 2){
            return nums;
        }
        int [] ans = new int[n];

        ans[0] = 1;
        for(int i = 1; i < n; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        System.out.println(Arrays.toString(ans));

        int right = 1;

        for(int i = n-2; i>=0;i--){
            right = right * nums[i+1];
            ans[i] = ans[i] * right;
        }

        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
