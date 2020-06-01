import java.util.ArrayDeque;
import java.util.Arrays;

public class LargestRectangle {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int [] left = new int[n];
        int [] right = new int[n];
        Arrays.fill(right, n);

        ArrayDeque<Integer> mono_stack = new ArrayDeque();
        for(int i = 0; i < n; i++){
            while(!mono_stack.isEmpty() && mono_stack.peek() <= heights[i]){
                right[mono_stack.pop()] = i;
            }
            left[i] = mono_stack.isEmpty() ? -1 : mono_stack.peek();
            mono_stack.push(i);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max((right[i] - left[i] + 1) * heights[i], ans);
        }
        return ans;

    }
}
