package dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L90SubSet2 {
    public static void main(String[] args) {
        L90SubSet2 m = new L90SubSet2();
        List<List<Integer>> ans = m.subsetsWithDup(new int [] {-1,1,2});
        System.out.println(ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int [] mem = new int[21];
        for(int num : nums) {
            if(num < 0){
                num = num + 21;
            }
            mem[num]++;
        }
        int n = mem.length;
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(ans, deque, 0, n, mem);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, Deque<Integer> deque, int cur, int n, int[]mem){
        if(cur >= n){
            ans.add(new ArrayList<>(deque));
        } else {
            dfs(ans, deque, cur + 1, n, mem);
            for(int i = 1; i <= mem[cur]; i++){
                int x = cur > 10 ? cur - 21 : cur;
                for(int j = 0; j < i; j++) {
                    deque.addLast(x);
                }
                dfs(ans, deque, cur + 1, n, mem);
                for(int j = 0; j < i; j++) {
                    deque.removeLast();
                }
            }
        }
    }
}
