package dfs;

import java.util.*;

public class L39IIICombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>(k);
        if (n < 1 || n > 45 || k < 1 || k > 9){
            return ans;
        }

        dfs(k, n, 0, 1, ans, deque);
        return ans;

    }

    private void dfs(int k, int n, int sum, int num, List<List<Integer>> ans, Deque<Integer> deque){
        if (k == 0 || sum >= n){
            if(sum == n){
                ans.add(new ArrayList<>(deque));
            }
            return;
        }

        for (int i = num; i <= 9; i++) {
            int newSum = sum + i;

            deque.addLast(i);
            dfs(k - 1, n, newSum, i + 1, ans, deque);
            deque.removeLast();
        }

    }

    public List<List<Integer>> combinationSum3_1(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, 1, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
        //终止条件，如果满足这个条件，再往下找也没什么意义了
        if (list.size() == k || n <= 0) {
            //如果找到一组合适的就把他加入到集合list中
            if (list.size() == k && n == 0)
                res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            //选择当前值
            list.add(i);
            //递归
            dfs(res, list, k, i + 1, n - i);
            //撤销选择
            list.remove(list.size() - 1);
        }
    }
}
