package array.threeNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L18FourSum {
    public static void main(String[] args) {
        L18FourSum m = new L18FourSum();
        int[] nums = {-1,0,1,2,-1,-4};
        int target = -1;
        List<List<Integer>> res = m.fourSum(nums, target);
        res.forEach(x -> System.out.println(Arrays.toString(x.toArray())));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // 如果数字重复了，跳过下一个
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 提前结束。若当前最小值加起来小于target
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                break;
            }
            if(nums[n - 1] + nums[n - 2] + nums[n - 3] + nums[i] < target){
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                // 如果数字重复了，跳过下一个
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 提前结束。若当前最小值加起来小于target
                if(nums[i] + nums[j] + nums[j+1] + nums[j+2] > target){
                    break;
                }
                if(nums[n - 1] + nums[n - 2] + nums[j] + nums[i] < target){
                    continue;
                }

                int first = j + 1;
                int last = n - 1;
                while (first < last) {
                    int sum = nums[i] + nums[j] + nums[first] + nums[last];
                    if (sum == target) {
                        List<Integer> tmpAns = new ArrayList<>();
                        tmpAns.add(nums[i]);
                        tmpAns.add(nums[j]);
                        tmpAns.add(nums[first]);
                        tmpAns.add(nums[last]);
                        ans.add(tmpAns);

                    }

                    // last左移 至不同的数
                    if (sum > target) {
                        int tmp = last - 1;
                        while (tmp > first && nums[tmp] == nums[last])
                            tmp--;
                        last = tmp;
                    } // first 右移 至不同的数
                    else {
                        int tmp = first + 1;
                        while (tmp < last && nums[tmp] == nums[first])
                            tmp++;
                        first = tmp;
                    }
                }
            }
        }
        return ans;
    }
}
