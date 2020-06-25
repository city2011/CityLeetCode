package binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class L1028 {

    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        int idx = 0;
        while(idx < S.length()){
            int level = 0;
            while(S.charAt(idx) == '-'){
                level++;
                idx++;
            }

            int value = 0;
            while(idx < S.length() && Character.isDigit(S.charAt(idx))){
                value = value * 10 + S.charAt(idx) - '0';
                idx++;
            }

            TreeNode node = new TreeNode(value);

            if(level == deque.size()){
                if(!deque.isEmpty()) {
                    deque.peek().left = node;
                }
            } else {
                if (level > deque.size()){
                    throw new IllegalArgumentException("这组不成树了");
                }
                while(level < deque.size()){
                    deque.pop();
                }
                deque.peek().right = node;
            }

            deque.push(node);
        }

        while(deque.size() > 1){
            deque.pop();
        }

        return deque.peek();

    }

    public static void main(String[] args) {

    }

    public TreeNode recoverFromPreorder2(String S) {
        Deque<TreeNode> path = new LinkedList<TreeNode>();
        int pos = 0;
        while (pos < S.length()) {
            int level = 0;
            while (S.charAt(pos) == '-') {
                ++level;
                ++pos;
            }
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + (S.charAt(pos) - '0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);
            if (level == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            } else {
                while (level != path.size()) {
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }

}
