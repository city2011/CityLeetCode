package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class L224 {

    public int calculate(String s) {
        int ret = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int sign = 1;
        stack.push(1);

        int n = s.length();
        int i = 0;
        while(i < n){
            if (s.charAt(i) == ' ') {
                i++;
            } else if(s.charAt(i) == '+') {
                sign = stack.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -stack.peek();
                i++;
            } else if (s.charAt(i) =='('){
                stack.push(sign);
                i++;
            } else if(s.charAt(i) == ')'){
                stack.pop();
                i++;
            } else {
                long num = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}
