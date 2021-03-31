package binaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class L73BinarySearchTreeIterator {
    Deque<TreeNode> x = new LinkedList<>();

    public L73BinarySearchTreeIterator(TreeNode root) {
        fill(root);
    }

    private void fill(TreeNode root){
        TreeNode cur = root;
        while(cur != null){
            x.push(cur);
            cur = cur.left;
        }
    }

    public int next() {
        TreeNode next = x.pop();
        int nextVal = next.val;
        if(next.right != null){
            fill(next.right);
        }
        return nextVal;
    }

    public boolean hasNext() {
        return !x.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(18);
        L73BinarySearchTreeIterator m = new L73BinarySearchTreeIterator(root);
        while(m.hasNext()){
            System.out.println(m.next());
        }
    }
}
