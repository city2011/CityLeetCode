package array.threeNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15Zero3NumberList {


    // 排序 + 双指针夹逼
    private List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

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
                // 如果和为 0 记录下标至答案
                if (sum == 0) {
                    List<Integer> tmpAns = new ArrayList<>();
                    tmpAns.add(i);
                    tmpAns.add(first);
                    tmpAns.add(last);
                    ans.add(tmpAns);
                }
                if (sum > 0) {
                    // 如果和大于0，移动 c 对应的指针last, 左移last
                    int tmp = last - 1;
                    // 移动到下一个不相等的元素
                    while (first < tmp && nums[tmp] == nums[last]) {
                        --tmp;
                    }
                    last = tmp;
                } else {
                    // 如果和小于 target，移动 b 对应的指针 first, 右移first
                    int tmp = first + 1;
                    // 移动到下一个不相等的元素
                    while (tmp < last && nums[tmp] == nums[first]) {
                        ++tmp;
                    }
                    first = tmp;
                }
            }
        }
        return ans;
    }
}
