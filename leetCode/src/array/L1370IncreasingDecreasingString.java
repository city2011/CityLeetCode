package array;

import java.util.*;

public class L1370IncreasingDecreasingString {
    public String sortString(String s) {
        Map<Character, Integer> mem = new HashMap<>();
        for(Character c : s.toCharArray()){
            mem.put(c, mem.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        while(!mem.isEmpty()){
            for(int i = 0; i < 26; i++){
                Character c = (char)('a'+ i);
                if(mem.get(c) != null){
                    sb.append(c);
                    if(mem.get(c) - 1 == 0){
                        mem.remove(c);
                    } else {
                        mem.put(c, mem.get(c) - 1);
                    }
                }
            }

            for(int i = 25; i >= 0; i--){
                Character c = (char)('a' + i);
                if(mem.get(c) != null){
                    sb.append(c);
                    if(mem.get(c) - 1 == 0){
                        mem.remove(c);
                    } else {
                        mem.put(c, mem.get(c) - 1);
                    }
                }
            }
        }
        return sb.toString();
    }

    public String sortString_UsingArray(String s) {
        int [] mem = new int[26];
        for(Character c : s.toCharArray()){
            mem[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();

        while(sb.length() != s.length()){
            for(int i = 0; i < 26; i++){
                if(mem[i] > 0){
                    mem[i]--;
                    sb.append((char)('a' + i));
                }
            }

            for(int i = 25; i >= 0; i--){
                if(mem[i] > 0){
                    mem[i]--;
                    sb.append((char)('a' + i));
                }
            }
        }
        return sb.toString();
    }
}
