package dfs;

import java.util.*;

public class L491IncreasingSubsequences {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, -1, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int [] nums, int idx, List<Integer> curList){
        if(curList.size() > 1){
            res.add(new ArrayList<>(curList));
        }


        Set<Integer> set = new HashSet<>();

        for (int i = idx + 1; i < nums.length; i++) {
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);

            if (idx == -1 || nums[i] >= nums[idx]){
                curList.add(nums[i]);
                dfs(nums, i, curList);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
