package dfs;

import binaryTree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class L987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> mem = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(mem, root, 0, 0);
        List<Integer> keys = mem.keySet().stream().sorted().collect(Collectors.toList());
        System.out.println(keys);

        for(Integer key : keys) {
            Map<Integer, List<Integer>> row2Vals = mem.get(key);
            List<Integer> rowKeys = row2Vals.keySet().stream().sorted().collect(Collectors.toList());
            List<Integer> rowVals = new ArrayList<>();
            for(Integer rowKey : rowKeys){
                List<Integer> values = row2Vals.get(rowKey);
                Collections.sort(values);
                rowVals.addAll(values);
            }
            ans.add(rowVals);
        }
        return ans;
    }

    private void dfs(Map<Integer, Map<Integer, List<Integer>>> mem, TreeNode tree, int col, int row){
        if(tree == null) {
            return;
        }

        if(mem.get(col) == null) {
            Map<Integer, List<Integer>> tmp = new HashMap<>();
            List<Integer> tmpVals = new ArrayList<>();
            tmpVals.add(tree.val);
            tmp.put(row, tmpVals);
            mem.put(col, tmp);
        } else {
            Map<Integer, List<Integer>> tmp = mem.get(col);
            if(tmp.get(row) == null) {
                List<Integer> tmpVals = new ArrayList<>();
                tmpVals.add(tree.val);
                tmp.put(row, tmpVals);
            } else {
                tmp.get(row).add(tree.val);
            }
        }

        dfs(mem, tree.left, col - 1, row + 1);
        dfs(mem, tree.right, col + 1, row + 1);
    }
}
