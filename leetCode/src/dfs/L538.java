package dfs;

import binaryTree.TreeNode;

public class L538 {
    public static void main(String[] args) {
        L538 m = new L538();
        TreeNode t = TreeNode.constructTreeByLevelTravesal(new Integer[] {2,0,3,-4,1});
        m.convertBST(t);
        System.out.println(t.levelTravesal());
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode convertBST(TreeNode root) {
        int bigger = 0;
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        sum = dfs(root.right, sum);
        sum += root.val;
        root.val = sum;
        sum = dfs(root.left, sum);
        return sum;
    }
}
