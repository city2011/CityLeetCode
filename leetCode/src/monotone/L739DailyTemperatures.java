package monotone;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L739DailyTemperatures {
    public static void main(String[] args) {
        L739DailyTemperatures main = new L739DailyTemperatures();
        int [] a = {73,74,75,71,69,72,76,73};
        int [] ans = main.dailyTemperatures(a);
        int [] ans2 = main.dailyTemperaturesMonotone(a);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(ans2));
    }

    // https://leetcode-cn.com/problems/daily-temperatures/solution/bu-zhi-dao-wei-sha-jiu-xie-liao-ge-er-fen-ran-hou-/
    // 脑洞一开，开出来一个二分 + 递归。 不过效果不好。还是要用 单调栈做。
    public int[] dailyTemperatures(int[] T) {
        int [] ans = new int [T.length];
        cac(T, ans, 0, T.length - 1);
        return ans;
    }

    private void cac(int T [], int [] ans, int le, int ri){
        if(le == T.length){
            ans[le] = 0;
            return;
        }
        if(le >= ri){
            return;
        }

        int s = le + 1;
        for(; s <= ri; s++){
            if(T[s] > T[le]){
                break;
            }
        }
        if(s == ri + 1){
            ans[le] = 0;
            cac(T, ans, le + 1, ri);
            return;
        }
        ans[le] = s - le;
        cac(T, ans, s, ri);
        if(le + 1 < s){
            cac(T, ans, le + 1, s);
        }
    }

    /**
    * author:city
    * date:2020/6/11 2:26
    * description: 单调栈的做法
    *
    */
    public int[] dailyTemperaturesMonotone(int[] T) {
        int [] ans = new int [T.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < T.length; i++){
            while(!deque.isEmpty() && T[i] > T[deque.peek()]) {
                ans[deque.peek()] = i - deque.pop();
            }
            deque.push(i);
        }

        return ans;
    }
}
