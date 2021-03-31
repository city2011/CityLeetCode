package context.c234;

import java.util.HashSet;
import java.util.Set;

public class C5713 {
    public static void main(String[] args) {
        C5713 m = new C5713();
        int ans = m.numDifferentIntegers("a1b01c001");
        System.out.println(ans);
    }

    public int numDifferentIntegers(String word) {
        Set<Long> mem = new HashSet<>();
        int i = 0, n = word.length();
        while(i < n){
            if(Character.isDigit(word.charAt(i))){
                long num = 0;
                while(i < n && Character.isDigit(word.charAt(i))){
                    num = num * 10 + Integer.parseInt(word.charAt(i)+"");
                    i++;
                }
                mem.add(num);
            } else {
                i++;
            }
        }
        return mem.size();
    }
}
