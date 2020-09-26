package binaryTree;

import java.util.*;

public class L113PathSumII {
    private static int path = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        if(root == null) return ans;
        dfs(root, ans, deque, sum);
        return ans;
    }

    private void dfs(TreeNode root, List<List<Integer>> ans, Deque<Integer> deque, int sum){
        if(root.left == null && root.right == null){
            path += root.val;
            deque.push(root.val);
            if(path == sum){
                List<Integer> tmp = new ArrayList<>(deque);
                Collections.reverse(tmp);
                ans.add(tmp);
            }
            deque.poll();
            path -= root.val;
            return;
        }

        path += root.val;
        deque.push(root.val);

        if(root.left != null){
            dfs(root.left, ans, deque, sum);
        }

        if(root.right != null){
            dfs(root.right, ans, deque, sum);
        }

        deque.poll();
        path -= root.val;
    }
}
