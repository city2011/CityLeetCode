package bfs;

import binaryTree.TreeNode;

import java.util.*;

public class L103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        while(!deque.isEmpty()){
            List<Integer> x = new ArrayList<>();
            for(int i = 0; i < deque.size(); i++){
                TreeNode tmp = deque.pop();
                x.add(tmp.val);
                if(tmp.left != null){
                    deque.addLast(tmp.left);
                }
                if(tmp.right != null) {
                    deque.addLast(tmp.right);
                }
            }
            ans.add(x);
        }

        for (int i = 0; i < ans.size(); i++) {
            if(i % 2 == 1){
                Collections.reverse(ans.get(i));
            }
        }

        return ans;
    }
}
