package array.slideWindow;

import java.util.HashMap;
import java.util.Map;

public class L567 {
    public static void main(String[] args) {
        L567 m = new L567();
        boolean ans = m.checkInclusion("ab","a");
        System.out.println(ans);
    }

    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(m > n){
            return false;
        }
        Map<Integer, Integer> baseFre = new HashMap<>();
        Map<Integer, Integer> targetFre = new HashMap<>();
        for(int i = 0; i < 26; i++){
            baseFre.put(i, 0);
            targetFre.put(i, 0);
        }

        for(Character c : s1.toCharArray()) {
            baseFre.put(c - 'a', baseFre.getOrDefault(c - 'a', 0) + 1);
        }
        for(int i = 0; i < m; i++) {
            targetFre.put(s2.charAt(i) - 'a', targetFre.getOrDefault(s2.charAt(i) - 'a', 0) + 1);
        }
        if(compareMap(baseFre, targetFre)){
            return true;
        }
        for(int i = m; i < n; i++) {
            targetFre.put(s2.charAt(i) - 'a', targetFre.getOrDefault(s2.charAt(i) - 'a', 0) + 1);
            int key = s2.charAt(i - m) - 'a';
            targetFre.put(key, targetFre.get(key) - 1);
            if(compareMap(baseFre, targetFre)){
                return true;
            }
        }
        return false;
    }

    private boolean compareMap(Map<Integer, Integer> baseFre, Map<Integer, Integer> targetFre){
        for(int i = 0; i < 26; i++){
            if(!baseFre.get(i).equals(targetFre.get(i)))
                return false;
        }
        return true;
    }
}
