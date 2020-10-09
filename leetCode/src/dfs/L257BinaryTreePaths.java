package dfs;

import binaryTree.TreeNode;

import java.util.*;

public class L257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<String> sb = new ArrayList<>();
        dfs(root, ans, sb);
        return ans;
    }

    private void dfs(TreeNode root, List<String> ans, List<String> ss) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                ss.add(String.valueOf(root.val));
                ans.add(generatePath(ss));
                ss.remove(ss.size() - 1);
            }
            if (root.left != null) {
                ss.add(String.valueOf(root.val));
                if (root.left != null) {
                    dfs(root.left, ans, ss);
                }
                ss.remove(ss.size() - 1);
            }
            if (root.right != null) {
                ss.add(String.valueOf(root.val));
                if (root.right != null) {
                    dfs(root.right, ans, ss);
                }
                ss.remove(ss.size() - 1);
            }
        }
    }

    private String generatePath(List<String> sb) {
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < sb.size() - 1; i++) {
            sb2.append(sb.get(i));
            sb2.append("->");
        }
        sb2.append(sb.get(sb.size() - 1));
        return sb2.toString();
    }

    private List<String> binaryTreePaths2(TreeNode root) {
        List<String> ans = new ArrayList<>();
        constructBinary(root, "", ans);
        return ans;
    }

    private void constructBinary(TreeNode root, String s, List<String> ans) {
        if (root != null){
            s += String.valueOf(root.val);
            if(root.left == null && root.right == null){
                ans.add(s);
            } else {
                s += "->";
                constructBinary(root.left, s, ans);
                constructBinary(root.right, s, ans);
            }
        }
    }

}
