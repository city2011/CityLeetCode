package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class L20 {
    public static void main(String[] args) {
        L20 l = new L20();
        String s = "({(((((({{{}}}})))))(((((({{{{[[[[]]]]]]";
        long start = System.currentTimeMillis();
        l.isValid(s);
        System.out.println("USing micro Seconds : " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        l.isValidUsingStack(s);
        System.out.println("USing micro Seconds : " + (System.currentTimeMillis() - start));
    }

    private boolean isValidUsingStack(String s){
        Stack<Character> stack = new Stack<>();
        int n = s.length();

        for(int i = 0; i < n; i++){
            if(isLeft(s.charAt(i))){
                stack.push(s.charAt(i));
            } else {
                // 漏掉了deque为空的判断
                if(stack.isEmpty()){
                    return false;
                }
                // 结束位置
                if(!isMatch(stack.pop(), s.charAt(i))){
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    private boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(isLeft(s.charAt(i))){
                deque.push(s.charAt(i));
            } else {
                // 漏掉了deque为空的判断
                if(deque.isEmpty()){
                    return false;
                }
                // 结束位置
                if(!isMatch(deque.pop(), s.charAt(i))){
                    return false;
                }
            }
        }
        if(deque.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    private boolean isLeft(Character c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isMatch(Character a, Character b){
        return (a == '(' && b ==')' ) ||
                (a == '[' && b ==']' ) ||
                (a == '{' && b =='}' );
    }
}
