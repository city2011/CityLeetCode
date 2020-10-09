package sort;

import java.util.Arrays;

public class L73 {
    public static void main(String[] args) {
        L73 m = new L73();
        int [] nums = new int [] {2,0,2,1,1,0};
        m.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int n = nums.length;

        int[] res = dfs(nums, 0, n - 1, 2, 0, n);

        if (res[0] < n) {
            dfs(nums, 0, n - 1, 2, 1, n);

        }

        if (res[1] >= 0) {
            dfs(nums, 0, n - 1, 1, 0, n);
        }
    }

    private int[] dfs(int[] nums, int left, int right, int lv, int rv, int n) {
        while (left < right) {
            while (left < n && nums[left] != lv) {
                left++;
            }

            while (right >= 0 && nums[right] != rv) {
                right--;
            }

            if (left < n && right >= 0 && left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return new int[]{left, right};
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
