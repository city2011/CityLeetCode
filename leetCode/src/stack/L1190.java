package stack;

import com.google.common.collect.Lists;

import java.util.*;

public class L1190 {
    public static void main(String[] args) {
        List<Integer> arry = Lists.newArrayList(1,2,3,4,5,6,7,8,9);
        System.out.println(arry.subList(0, 3));
        System.out.println(arry.subList(3, 6));
        String input = "(da((ab(r)cd)i))";
        String input2 = "a(bcdefghijkl(mno)p)q";
        String input3 = "ta()usw((((a))))";

        L1190 m = new L1190();
        System.out.println(m.reverseParentheses_UsingMath(input));
        System.out.println(m.reverseParentheses_UsingStack(input));

        System.out.println(m.reverseParentheses_UsingMath(input2));
        System.out.println(m.reverseParentheses_UsingStack(input2));

        System.out.println(m.reverseParentheses_UsingMath(input3));
        System.out.println(m.reverseParentheses_UsingStack(input3));

    }

    public String reverseParentheses_UsingStack(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        char [] cs = s.toCharArray();
        for(Character c : cs) {
            if(c == ')') {
                Queue<Character> queue = new ArrayDeque<>();
                while(stack.peek() != '('){
                    queue.offer(stack.pop());
                }
                stack.pop();
                while(!queue.isEmpty()) {
                    stack.push(queue.poll());
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    /** this method just fit  quota
     *
     * @param s
     * @return
     */
    public String reverseParentheses_UsingMath(String s) {
        boolean lastIsRight = false;
        if(s.charAt(s.length() - 1) == ')'){
            lastIsRight = true;
            s += "$";
        }
        String[] arr1 = s.split("\\(");
        int n = arr1.length;
        String[] arr2 = arr1[n - 1].split("\\)");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            if(i % 2 == 0) {
                ans.append(arr1[i]);
            } else {
                addReverse(ans, arr2[n - i - 1]);
            }
        }
        if(n % 2 == 0){
            addReverse(ans, arr2[0]);
        } else {
            ans.append(arr2[0]);
        }
        for (int i = n - 2; i >= 0; i--) {
            if(i % 2 == 0){
                ans.append(arr2[n - i - 1]);
            } else {
                addReverse(ans, arr1[i]);
            }
        }
        if(lastIsRight) {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }

    private void addReverse(StringBuilder sb, String x){
        int n = x.length();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(x.charAt(i));
        }
    }
}
