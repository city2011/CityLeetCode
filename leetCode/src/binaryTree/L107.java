package binaryTree;

import java.util.*;

public class L107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> deque = new ArrayDeque<>();

        List<List<Integer>> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }

        deque.offer(root);

        while(!deque.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = deque.poll();
                level.add(t.val);
                if(t.left != null){
                    deque.offer(t.left);
                }
                if(t.right != null){
                    deque.offer(t.right);
                }
            }
            ans.add(0, level);
        }

        return ans;
    }
}
