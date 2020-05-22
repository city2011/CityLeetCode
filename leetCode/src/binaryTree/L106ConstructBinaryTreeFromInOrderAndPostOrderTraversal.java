package binaryTree;

/**
 * @ProjectName: CityLeetCode
 * @Author: City
 * @Description:
 * @Date: Created in 1:36 AM 2020/5/23
 * @Modified By:city
 */
public class L106ConstructBinaryTreeFromInOrderAndPostOrderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createTree(postorder, inorder, 0, postorder.length - 1, 0, inorder.length-1);
    }

    /*
        递归调用，每次更新后序和中序的位置头尾索引. 思路与L105一样
     */
    public TreeNode createTree(int[] postOrder, int[] inorder, int pstart, int pend, int istart, int iend){
        if(pstart > pend) return null;
        if(pstart == pend) return new TreeNode(postOrder[pend]);

        TreeNode node = new TreeNode(postOrder[pend]);

        int i = 0;
        for(; i < iend - istart + 1; i++){
            if(postOrder[pend] == inorder[istart+i])
                break;
        }

        node.left = createTree(postOrder, inorder, pstart , pstart + i - 1, istart, istart + i - 1);
        node.right = createTree(postOrder, inorder, pstart + i, pend-1, istart + i + 1, iend);

        return node;
    }
}
