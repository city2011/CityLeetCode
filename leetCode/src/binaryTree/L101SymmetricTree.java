package binaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class L101SymmetricTree {
    public static void main(String[] args) {
        L101SymmetricTree main = new L101SymmetricTree();
        Integer[] treeLevelTravesal = {1,2,2,null,3,null,3};
        TreeNode root = TreeNode.constructTreeByLevelTravesal(treeLevelTravesal);

        boolean ret1 = main.isSymmetric(root);
        boolean ret2 = main.isSymmetricIterative(root);

        System.out.println(ret1);
        System.out.println(ret2);

    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null)
            return true;
        if(leftNode == null || rightNode == null)
            return false;
        return leftNode.val == rightNode.val && check(leftNode.left, rightNode.right) && check(leftNode.right, rightNode.left);
    }

    private boolean isSymmetricIterative(TreeNode root){
        if(root == null)
            return false;
        Deque<TreeNode> deque = new LinkedList<>();

        deque.offer(root.left);
        deque.offer(root.right);
        while(!deque.isEmpty()){
            TreeNode l = deque.pop();
            TreeNode r = deque.pop();
            if(l == null && r == null)
                continue;
            if(l == null || r == null || l.val != r.val)
                return false;

            deque.offer(l.left);
            deque.offer(r.right);

            deque.offer(l.right);
            deque.offer(r.left);
        }
        return true;
    }
}
