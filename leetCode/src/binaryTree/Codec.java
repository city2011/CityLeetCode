package binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Codec {
    int idx = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return null;
        String pre = dfsSerial(root);
        pre.substring(0, pre.length() -1);
        return pre;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");
        TreeNode resNode = dfsDs(strs);
        return resNode;
    }

    private TreeNode dfsDs(String[] strs) {
        if(strs[idx].equals("null")) {
            idx++;
            return null;
        }
        TreeNode resNode = new TreeNode(Integer.valueOf(strs[idx]));
        idx++;
        resNode.left = dfsDs(strs);
        resNode.right = dfsDs(strs);
        return resNode;
    }


    private String dfsSerial(TreeNode root) {
        if(root == null) {
            return "null,";
        }
        String str = root.val + ",";
        str += dfsSerial(root.left);
        str += dfsSerial(root.right);
        return str;
    }
}
