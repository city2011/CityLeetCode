import java.util.*;

public class L78 {
    public static void main(String[] args) {
        L78 m = new L78();
        int [] nums = {1, 2, 3};
        m.subsets(nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        dfs(nums, 0, n, new ArrayDeque<>(n), ans);
        return ans;
    }

    private void dfs(int[] nums, int idx, int n, Deque<Integer> deque, List<List<Integer>> ans) {
        if (idx == n) {
            ans.add(new ArrayList());
        }
        deque.addLast(nums[idx]);
        dfs(nums, idx + 1, n, deque, ans);
        deque.removeLast();

        dfs(nums, idx + 1, n, deque, ans);
    }
}

