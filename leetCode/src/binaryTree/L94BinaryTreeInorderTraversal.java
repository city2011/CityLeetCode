package binaryTree;

import java.util.*;

public class L94BinaryTreeInorderTraversal {

    private List<Integer> inorderTraversal1(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        if(root.left != null){
            ans.addAll(inorderTraversal1(root.left));
        }

        ans.add(root.val);

        if(root.right != null){
            ans.addAll(inorderTraversal1(root.right));
        }

        return ans;
    }

    private List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        while(root != null || !deque.isEmpty()){
            while(root != null){
                deque.push(root);
                root = root.left;
            }
            TreeNode tmp = deque.pop();
            ans.add(tmp.val);
            root = tmp.right;
        }
        return ans;
    }

    private List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode preprocessor = null;

        while(root != null){
            if (root.left == null) {
                ans.add(root.val);
                root = root.right;
            } else {
                preprocessor = root.left;
                while(preprocessor.right != null && preprocessor.right != root) {
                    preprocessor = preprocessor.right;
                }

                if(preprocessor.right == null){
                    preprocessor.right = root;
                    root = root.left;
                } else {
                    preprocessor.right = null;
                    ans.add(root.val);
                    root = root.right;
                }
            }
        }

        return ans;
    }

}
