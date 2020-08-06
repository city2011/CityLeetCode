package array;

import java.util.*;

public class L415AddStrings {
    public static void main(String[] args) {
        L415AddStrings m = new L415AddStrings();
        System.out.println(m.addStrings("3876620623801494171", "6529364523802684779"));
        System.out.println(m.addStrings2("3876620623801494171", "6529364523802684779"));
    }

    public String addStrings(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        Deque<Character> d1 = new ArrayDeque<>();
        Deque<Character> d2 = new ArrayDeque<>();
        for(char c : c1){
            d1.push(c);
        }
        for(char c : c2){
            d2.push(c);
        }
        String ans = "";
        int a = 0, b = 0, c = 0, d = 0;
        long e = 1;
        while(!d1.isEmpty() && !d2.isEmpty()){
            a = d1.pop() - '0';
            b = d2.pop() - '0';
            d = a + b + c;
            if(d > 9){
                c = 1;
            } else {
                c = 0;
            }
            ans = (d % 10) + ans;
            e *= 10;
        }
        if(!d2.isEmpty()){
            d1 = d2;
        }
        if(!d1.isEmpty()){
            while(!d1.isEmpty()){
                a = d1.pop() - '0';
                d = a + c;
                if(d > 9){
                    c = 1;
                } else {
                    c = 0;
                }
                ans = (d % 10) + ans;
                e *= 10;
            }
        }
        if (c != 0){
            ans = c + ans;
        }
        return ans;
    }

    public String addStrings2(String num1, String num2){
        int idx1 = num1.length() - 1, idx2 = num2.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while(idx1 >= 0 || idx2 >= 0 || add != 0){
            int x = idx1 < 0 ? 0 : num1.charAt(idx1) - '0';
            int y = idx2 < 0 ? 0 : num2.charAt(idx2) - '0';
            int sum = x + y + add;
            sb.append(sum % 10);
            add = sum / 10;
            idx1--;
            idx2--;
        }
        return sb.reverse().toString();
    }
}