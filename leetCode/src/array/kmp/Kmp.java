package array.kmp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Kmp {
    public static void main(String[] args) {
        Kmp m = new Kmp();

        String s = "ahsjskshaaahsjs";

        int [] res = m.getNext(s);

        System.out.println(Arrays.toString(res));
        System.out.println(s.length() +" " + (s.length()-res[s.length()-1]));

    }

    private int [] getNext(String p){
        char[] cp = p.toCharArray();
        int [] next = new int[p.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while(i < p.length() - 1){
            if(j == -1 || cp[i] == cp[j]){
                j++;
                i++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
