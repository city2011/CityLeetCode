package binaryTree;

import java.lang.reflect.Array;
import java.util.*;

public class L297 {
    public static void main(String[] args) {
        L297 main = new L297();
        String data = "null,";
        String d = "2,1,1,1,3,null,null,null,null,null,1,2,3,null,3,";
        TreeNode node = main.deserialize(d);
        if(node != null) {
            String levelTravesalList = main.serialize(node);
            System.out.println(levelTravesalList);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                ans.add("null");
            } else {
                ans.add(node.val+"");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String x : ans){
            sb.append(x).append(",");
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        System.out.println(data);

        String[] datas = data.split(",");
        System.out.println(datas.length);
        System.out.println(Arrays.toString(datas));
        int size = datas.length - 1;
        Integer[] levelTravesal = new Integer[size];

        for (int i = 0; i < datas.length - 1; i++) {
            if ("null".equals(datas[i])) {
                levelTravesal[i] = null;
            } else {
                levelTravesal[i] = Integer.parseInt(datas[i]);
            }
        }

        System.out.println(Arrays.toString(levelTravesal));

        return TreeNode.constructTreeByLevelTravesal(levelTravesal);
    }
}
