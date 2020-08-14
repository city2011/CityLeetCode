package dp.binarySearchTree;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L95UniqueBinarySearchTreeII {
    public static void main(String[] args) {
        L95UniqueBinarySearchTreeII main = new L95UniqueBinarySearchTreeII();

        List<TreeNode> ans = main.generateTrees(4);
        ans.forEach(x -> System.out.println(x.levelTravesal()));
        System.out.println(ans);
    }

    /// 初始方案 回溯？
    /// 一层一层地向下去增加，然后回退到上一种可能的时候，将之前的影响去除。意味"回溯"
    private List<TreeNode> generateTrees(int n){
        List<TreeNode> ans = new ArrayList<>();
        if(n == 0)
            return ans;
        TreeNode root = new TreeNode(0);
        getAns(n, ans, root, 0);
        return ans;
    }

    private void getAns(int n, List<TreeNode> ans, TreeNode root, int count){
        if(count == n){
            TreeNode newRoot = treeCopy(root);
            ans.add(newRoot.right);
            return;
        }

        TreeNode root_copy = root;
        for(int i = 1; i <= n; i++){
            root = root_copy;
            while(root != null){
                if (i < root.val){
                    if(root.left == null){
                        root.left = new TreeNode(i);

                        getAns(n, ans, root_copy, count + 1);

                        root.left = null;
                        break;
                    }
                    root = root.left;
                } else if (i > root.val){
                    if(root.right == null){
                        root.right = new TreeNode(i);

                        getAns(n, ans, root_copy, count + 1);

                        root.right = null;

                    }
                    root = root.right;
                } else {
                    break;
                }
            }
        }
    }

    private TreeNode treeCopy(TreeNode root) {
        if(root != null){
            TreeNode x = new TreeNode(root.val);
            x.left = treeCopy(root.left);
            x.right = treeCopy(root.right);
            return x;
        } else {
            return null;
        }
    }

    /// 递归解法
    private List<TreeNode> generateTrees2(int n){
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0){
            return ans;
        }
        return getAns2(1, n);
    }

    private List<TreeNode> getAns2(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();

        if(start > end){
            ans.add(null);
            return ans;
        }

        if(start == end){
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> leftTrees = getAns2(start, i - 1);
            List<TreeNode> rightTrees = getAns2(i + 1, end);

            for(TreeNode lTNode : leftTrees) {
                for(TreeNode rTNode : rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = lTNode;
                    root.right = rTNode;
                    ans.add(root);
                }
            }
        }

        return ans;
    }
}
