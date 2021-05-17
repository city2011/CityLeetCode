package binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class L993Cousins_in_Binary_Tree {
    public static void main(String[] args) {
        L993Cousins_in_Binary_Tree m = new L993Cousins_in_Binary_Tree();
        TreeNode t = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        t.left = t1;
        t.right = t2;
        t1.right = t3;
        t2.right = t4;
        boolean res = m.isCousins(t, 4, 5);
        System.out.println(res);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Node993> queue = new ArrayDeque<>();
        queue.add(new Node993(-1, root));

        while (!queue.isEmpty()) {
            Node993 nx = null, ny = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node993 node993 = queue.poll();
                if(node993.c.val == x) {
                    nx = node993;
                }
                if(node993.c.val == y) {
                    ny = node993;
                }
                if(node993.c.left != null){
                    queue.add(new Node993(node993.c.val, node993.c.left));
                }
                if(node993.c.right != null){
                    queue.add(new Node993(node993.c.val, node993.c.right));
                }
            }
            if(nx != null && ny != null) {
                return !nx.p.equals(ny.p);
            }
            if(nx != null || ny != null)
                return false;
        }
        return false;
    }

    static class Node993 {
        Integer p;
        TreeNode c;

        Node993(Integer a, TreeNode b){
            p = a;
            c = b;
        }
    }
}
