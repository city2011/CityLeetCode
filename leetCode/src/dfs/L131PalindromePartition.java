package dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class L131PalindromePartition {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        int n = s.length();
        dfs(ans, 0, n, new ArrayDeque<>(), s);
        return ans;
    }

    private void dfs(List<List<String>> ans, int start, int n, ArrayDeque<String> queue, String s){
        if(start > n){
            ans.add(new ArrayList<>(queue));
        }

        for(int i = start; i < n; i++){
            String tmp = s.substring(start, i);
            if(isPalindrome(tmp)){
                queue.add(tmp);
                dfs(ans, i + 1, n, queue, s);
                queue.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
