package array.threeNumbers;

import java.util.Arrays;

public class L16Smallest3Numbers {
    public static void main(String[] args) {
        L16Smallest3Numbers m = new L16Smallest3Numbers();
        int [] nums = {-1, 0, 1, 2, -1, -4};
        int target = 4;

        int res = m.threeSumClosest(nums, target);
        System.out.println(res);
    }

    // 排序 + 双指针夹逼
    private int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int first = i + 1, last = n - 1;
            while (first < last) {
                int sum = nums[i] + nums[first] + nums[last];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int tmp = last - 1;
                    // 移动到下一个不相等的元素
                    while (first < tmp && nums[tmp] == nums[last]) {
                        --tmp;
                    }
                    last = tmp;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int tmp = first + 1;
                    // 移动到下一个不相等的元素
                    while (tmp < last && nums[tmp] == nums[first]) {
                        ++tmp;
                    }
                    first = tmp;
                }
            }
        }
        return best;
    }
}
