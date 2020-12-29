package array.binary;

import java.util.Arrays;

public class L34 {
    public static void main(String[] args) {
        L34 m = new L34();
        int[] ans = m.searchRange(new int[]{1,1,2,2,3,4}, 2);
        System.out.println(Arrays.toString(ans));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int ans [] = new int[2];
        while(left <= right){
            mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                ans[0] = findLeft(nums, mid, left, target);
                ans[1] = findRight(nums, mid, right, target);
                return ans;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        Arrays.fill(ans, -1);
        return ans;
    }

    private int findLeft(int[] nums, int mid, int left, int target){
        int idx;
        while(left <= mid){
            idx = left + (mid - left) / 2;
            if(nums[idx] < target){
                left = idx + 1;
            } else {
                mid = idx - 1;
            }
        }
        return mid + 1;
    }

    private int findRight(int[] nums, int mid, int right, int target){
        int idx;
        while(mid <= right){
            idx = mid + (right - mid) / 2;
            if(nums[idx] > target){
                right = idx - 1;
            } else {
                mid = idx + 1;
            }
        }
        return mid - 1;
    }
}
