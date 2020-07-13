package array.kmp;

import java.util.Arrays;

public class L28strIndexOf {
    public static void main(String[] args) {
        L28strIndexOf m = new L28strIndexOf();

        m.strStr("abeabeabc", "abeabc");
    }

    public int strStr(String haystack, String aimStr) {
//        if(needle == "")
//            return 0;
//        int [] next = new int[needle.length()];
//        next[0] = -1;
//        int i = 0, j = -1;
//        char [] p = needle.toCharArray();
//        while(i < p.length - 1){
//            if(j == -1 || p[i] == p[j]){
//                i++;
//                j++;
//                next[i] = j;
//            }
//            else
//                j = next[j];
//        }
//
//        System.out.println(Arrays.toString(next));
        int [] next = caculateNext(aimStr);
        if(next.length == 0){
            return 0;
        }

        int k = 0;
        int a = 0;
        while(a < haystack.length()){
            if(k == -1 || haystack.charAt(a) == aimStr.charAt(k)){
                k++;
                a++;
            } else
                k = next[k];

            if(k == aimStr.length())
                return a - aimStr.length() + 1;
        }
        return -1;
    }

    private int [] caculateNext(String aimStr){
        if(aimStr == "")
            return new int [0];
        int [] next = new int[aimStr.length()];
        next[0] = -1;
        int i = 0, j = -1;
        char [] p = aimStr.toCharArray();
        while(i < p.length - 1){
            if(j == -1 || p[i] == p[j]){
                i++;
                j++;
                next[i] = j;
            }
            else
                j = next[j];
        }
        return next;
    }
}
