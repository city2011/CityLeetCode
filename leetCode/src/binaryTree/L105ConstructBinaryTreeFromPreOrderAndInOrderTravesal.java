package binaryTree;

import java.util.Arrays;

/**
 * @ProjectName: CityLeetCode
 * @Author: City
 * @Description:
 * @Date: Created in 11:47 PM 2020/5/22
 * @Modified By:city
 */
public class L105ConstructBinaryTreeFromPreOrderAndInOrderTravesal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    /*
        递归调用，每次更新前序和中序的位置头尾索引
     */
    public TreeNode createTree(int[] preorder, int[] inorder, int pstart, int pend, int istart, int iend){
        if(pstart > pend) return null;
        if(pstart == pend) return new TreeNode(preorder[pstart]);

        TreeNode node = new TreeNode(preorder[pstart]);

        int i = 0;
        for(; i < iend - istart + 1; i++){
            if(preorder[pstart] == inorder[istart+i])
                break;
        }

        node.left = createTree(preorder, inorder, pstart + 1, pstart + i, istart, istart + i - 1);
        node.right = createTree(preorder, inorder, pstart + i + 1, pend, istart + i + 1, iend);

        return node;
    }

    /*
        递归地每次新建一个preorder， inorder
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode node = new TreeNode(preorder[0]);
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == node.val) break;
        }
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
        node.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
        return node;
    }
}
