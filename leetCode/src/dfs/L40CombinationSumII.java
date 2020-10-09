package dfs;

import java.util.*;

public class L40CombinationSumII {
    List<List<Integer>> ans = new ArrayList<>();
    List<int []> freq = new ArrayList<>();
    List<Integer> sequence = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates){
            int size = freq.size();
            if(freq.isEmpty() || num != freq.get(size - 1)[0]){
                freq.add(new int [] {num, 1});
            } else {
                ++freq.get(size)[1];
            }
        }
        dfs1(0, target);
        return ans;
    }

    private void dfs1(int pos, int res){
        if(res == 0){
            ans.add(new ArrayList<>(sequence));
        }

        if(pos == freq.size() || res < freq.get(pos)[0]){
            return;
        }

        dfs1(pos + 1, res);

        int most = Math.min(res / freq.get(pos)[0], freq.get(pos)[1]);

        for (int i = 1; i <= most; i++) {
            sequence.add(freq.get(pos)[0]);
            dfs1(pos + 1, res - freq.get(pos)[0] * i);
        }

        for (int i = 0; i < most; i++) {
            sequence.remove(sequence.size() - 1);
        }




    }

    public List<List<Integer>> combinationSum2_2(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        if(n == 0){
            return ans;
        }
        Deque<Integer> deque = new ArrayDeque<>(n);
        Arrays.sort(candidates);
        dfs(candidates, target, 0, n, ans, deque);
        return ans;
    }

    private void dfs(int[] candidates, int target, int idx, int len, List<List<Integer>> ans, Deque<Integer> deque){
        if(target == 0){
            ans.add(new ArrayList<>(deque));
            return;
        }

        for (int i = idx; i < len; i++) {
            if(candidates[i] > target){
                break;
            }

            if(i > idx && candidates[i] == candidates[i - 1]){
                continue;
            }

            deque.addLast(candidates[i]);

            dfs(candidates, target - candidates[i], i + 1, len, ans, deque);

            deque.removeLast();
        }
    }
}
