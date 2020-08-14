package binaryTree;

import java.util.*;

/**
 * @ProjectName: CityLeetCode
 * @Author: City
 * @Description:
 * @Date: Created in 11:48 PM 2020/5/22
 * @Modified By:city
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    TreeNode(Integer x) {
        val = x;
    }

    public static TreeNode getTree(Integer [] value){
        TreeNode p = new TreeNode(value[0]);
        TreeNode q = p;
        Queue<TreeNode> queue = new LinkedList<>();
        int i=0;
        while (p != null){
            if(2*i+1<value.length){
                p.left = new TreeNode(value[2*i+1]);
                queue.add(p.left);
            }
            if (2*i+2<value.length){
                p.right = new TreeNode(value[2*i+2]);
                queue.add(p.right);
            }
            p = queue.poll();
            i+=1;
        }
        return q;
    }

    public static TreeNode constructTreeByLevelTravesal(Integer[] levelTravesal) {
        int size = levelTravesal.length;
        if (size == 0) {
            return null;
        }
        int i = 0;
        TreeNode root = new TreeNode(levelTravesal[i]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (i * 2 + 2 < size) {
            TreeNode node = queue.poll();

            if (levelTravesal[i * 2 + 1] != null) {
                node.left = new TreeNode(levelTravesal[i * 2 + 1]);
                queue.offer(node.left);
            }

            if (node != null) {
                if (levelTravesal[i * 2 + 2] != null) {
                    node.right = new TreeNode(levelTravesal[i * 2 + 2]);
                    queue.offer(node.right);
                }
            }

            i++;
        }

        return root;
    }

    public List<Integer> levelTravesal() {
        List<Integer> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                ans.add(null);
            } else {
                ans.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return ans;
    }
}
