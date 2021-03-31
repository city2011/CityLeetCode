package monotone;

import java.util.Stack;

public class L503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] ans = new int [n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n * 2 - 1; i++){
            while(!stack.isEmpty() && stack.peek() < nums[i % n]){
                ans[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }

        return ans;
    }
}
