package context.c190;

import binaryTree.TreeNode;

import java.util.Arrays;

public class L5418PseudoPalindromicPathInBinaryTree {
    public static void main(String[] args) {
        L5418PseudoPalindromicPathInBinaryTree main = new L5418PseudoPalindromicPathInBinaryTree();

        Integer[] levelTravesal = {2,1,1,1,3,null,null,null,null,null,1,2,3,null,3};
        TreeNode tree = TreeNode.constructTreeByLevelTravesal(levelTravesal);
        int ans = main.pseudoPalindromicPaths(tree);
        System.out.println(ans);
    }

    int [] nums = new int [10];
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root != null){
            nums[root.val]++;
            return caculatePalindromePathNums(root);
        }
        return 0;
    }

    public int caculatePalindromePathNums(TreeNode root) {
        int ans = 0;

        if(root.left == null && root.right==null){
            // last node
            if(check())
                return 1;
            else return 0;
        }

        System.out.println(Arrays.toString(nums));

        if(root.left != null){
            nums[root.left.val]++;
            System.out.println(root.left.val);
            System.out.println(Arrays.toString(nums));
            ans += caculatePalindromePathNums(root.left);
            System.out.println(Arrays.toString(nums));
            nums[root.left.val]--;
        }

        if(root.right != null){
            nums[root.right.val]++;
            System.out.println(root.right.val);
            System.out.println(Arrays.toString(nums));
            ans += caculatePalindromePathNums(root.right);
            nums[root.right.val]--;
            System.out.println(Arrays.toString(nums));
        }

        return ans;
    }

    private boolean check(){
        int addNums = 0;
        for(int num : nums){
            if(num % 2 == 1)
                addNums++;
        }
        return addNums <= 1;
    }
}
