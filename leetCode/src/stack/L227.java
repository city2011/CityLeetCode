package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L227 {
    public static void main(String[] args) {
        L227 m = new L227();
        int ans = m.calculate("0-2147483647".replace(" ", ""));
        System.out.println(ans);
    }

    public int calculate(String s) {
        Deque<Long> stack = new ArrayDeque<>();
        List<Character> symbol = new ArrayList<>();
        int n = s.length();
        int i = 0;

        while(i < n){
            if(s.charAt(i) == ' '){
                i++;
            } else if (s.charAt(i) == '+'){
                symbol.add('+');
                i++;
            } else if (s.charAt(i) == '-'){
                symbol.add('-');
                i++;
            } else if (s.charAt(i) == '*'){
                i++;
                long pre = stack.pop();
                long num = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                num = pre * num;
                stack.push(num);
            } else if (s.charAt(i) == '/'){
                i++;
                long pre = stack.pop();
                long num = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                num = pre / num;
                stack.push(num);
            } else {
                long num = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                stack.push(num);
            }
        }

        int size = stack.size();
        long res = stack.pollLast();
        for (int j = 1; j < size; j++) {
            if(symbol.get(j - 1) == '+'){
                res += stack.pollLast();
            } else {
                res -= stack.pollLast();
            }
        }
        return (int)res;
    }
}
