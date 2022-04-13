package context;

import java.util.ArrayList;
import java.util.List;

public class C6035 {
    public long numberOfWays(String s) {
        List<Integer> mem = new ArrayList<>();
        char pre = s.charAt(0);
        int sum = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == pre) {
                sum++;
            } else {
                mem.add(sum);
                sum = 1;
                pre = s.charAt(i);
            }
        }
        mem.add(sum);
        int n = mem.size();
        long[] sumMem = new long[n];
        long[] ppre = new long[n];
        sumMem[n - 1] = mem.get(n - 1);
        sumMem[n - 2] = mem.get(n - 2);
        ppre[n - 1] = sumMem[n - 1];
        ppre[n - 2] = sumMem[n - 1] * sumMem[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            sumMem[i] = mem.get(i) + sumMem[i + 2];
            ppre[i] = ppre[i + 2] + mem.get(i) * sumMem[i + 1];
        }

        long res = 0;
        for(int i = 0; i < mem.size() - 2; i++){
            res += mem.get(i) * ppre[i + 1];
        }
        return res;
    }
}
