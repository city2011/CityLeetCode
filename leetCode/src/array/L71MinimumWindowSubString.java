package array;

import java.util.HashMap;
import java.util.Map;

public class L71MinimumWindowSubString {
    private Map<Character, Integer> ori2 = new HashMap<>();
    private Map<Character, Integer> cnt2 = new HashMap<>();

    private String minWindow(String s, String t) {
        if(t.length() == 0){
            return "";
        }

        for(Character c : t.toCharArray()){
            ori2.put(c, ori2.getOrDefault(c, 0)+1);
        }

        int slength = s.length();

        int left = 0, right = -1;
        int optLeft = -1, optRight = -1;

        while(right < slength - 1){
            right++;
            cnt2.put(s.charAt(right), cnt2.getOrDefault(s.charAt(right),0) + 1);

            while(check2()){
                if(optLeft == -1 || right - left < optRight - optLeft){
                    optLeft = left;
                    optRight = right;
                }
                cnt2.put(s.charAt(left), cnt2.get(s.charAt(left))-1);
                left++;
            }
        }

        System.out.println("optLeft:"+optLeft+"  optRight:"+optRight);
        return optLeft == -1 ? "" : s.substring(optLeft, optRight+1);
    }

    private boolean check2(){
        for(Map.Entry<Character, Integer> entry : ori2.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();

            if(cnt2.get(key) == null || cnt2.get(key) < value){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L71MinimumWindowSubString main = new L71MinimumWindowSubString();
        String s = "ADOBECODEBANC";
        String t = "OBCO";

        String ans = main.minWindow(s, t);
        System.out.println(ans);
    }
}

