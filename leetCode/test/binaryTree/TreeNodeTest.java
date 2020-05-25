package binaryTree;

import org.junit.Test;

import java.util.List;

public class TreeNodeTest {

    @Test
    public void levelTravesal() {
        Integer[] levelTravesal = {2,1,1,1,3,null,null,null,null,null,1,2,3,null,3};
        TreeNode node = TreeNode.constructTreeByLevelTravesal(levelTravesal);
        if(node != null) {
            List<Integer> levelTravesalList = node.levelTravesal();
            System.out.println(levelTravesalList);
        }
    }

    @Test
    public void levelTravesalGetTree() {
        Integer[] levelTravesal = {2,1,1,1,3,null,null,null,null,null,1,2,3,null,3};
        TreeNode node = TreeNode.getTree(levelTravesal);
        if(node != null) {
            List<Integer> levelTravesalList = node.levelTravesal();
            System.out.println(levelTravesalList);
        }
    }
}
