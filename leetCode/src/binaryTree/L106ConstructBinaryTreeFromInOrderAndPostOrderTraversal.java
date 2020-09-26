package binaryTree;

import java.util.Arrays;

/**
 * @ProjectName: CityLeetCode
 * @Author: City
 * @Description:
 * @Date: Created in 1:36 AM 2020/5/23
 * @Modified By:city
 */
public class L106ConstructBinaryTreeFromInOrderAndPostOrderTraversal {
    public static void main(String[] args) {
        L106ConstructBinaryTreeFromInOrderAndPostOrderTraversal m = new L106ConstructBinaryTreeFromInOrderAndPostOrderTraversal();
        TreeNode node = m.buildTree2(new int []{9,3,15,20,7}, new int [] {9,15,7,20,3});
        System.out.println(node.levelTravesal());
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createTree(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    /*
        递归调用，每次更新后序和中序的位置头尾索引. 思路与L105一样
     */
    public TreeNode createTree(int[] postOrder, int[] inorder, int pstart, int pend, int istart, int iend) {
        if (pstart > pend) return null;
        if (pstart == pend) return new TreeNode(postOrder[pend]);

        TreeNode node = new TreeNode(postOrder[pend]);

        int i = 0;
        for (; i < iend - istart + 1; i++) {
            if (postOrder[pend] == inorder[istart + i])
                break;
        }

        node.left = createTree(postOrder, inorder, pstart, pstart + i - 1, istart, istart + i - 1);
        node.right = createTree(postOrder, inorder, pstart + i, pend - 1, istart + i + 1, iend);

        return node;
    }


    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        int idx = 0, n = postorder.length;
        TreeNode root = new TreeNode(postorder[n - 1]);

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[n - 1]) {
                idx = i;
                break;
            }
        }

        if (idx == 0) {
            root.left = null;
        } else {
            int[] linorder = Arrays.copyOfRange(inorder, 0, idx);
            int[] lpostorder = Arrays.copyOfRange(postorder, 0, idx);
            root.left = buildTree(linorder, lpostorder);
        }

        if (idx == n - 1) {
            root.right = null;
        } else {
            int[] rinorder = Arrays.copyOfRange(inorder, idx + 1, n);
            int[] rpostorder = Arrays.copyOfRange(postorder, idx, n - 1);
            root.right = buildTree(rinorder, rpostorder);
        }

        return root;
    }

}
