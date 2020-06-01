package context.c190.cd27;

import java.util.HashSet;
import java.util.Set;

public class L5409 {
    public static void main(String[] args) {
        L5409 main = new L5409();
        String s = "0110";
        int k = 2;
        boolean ret = main.hasAllCodes(s, k);
        System.out.println(ret);
    }

    public boolean hasAllCodes(String s, int k) {
        int upmax = 500000;

        int sum = 0;
        for(int i = 0; i <= k; i++){
            int a = 1, b = 1;
            for(int j1 = k; j1 > k - i; j1--){
                a = a * j1;
            }
            for(int j2 = i; j2 > 0;j2--){
                b = b * j2;
            }
            sum += a / b;
            if(sum > upmax){
                return false;
            }
        }
        System.out.println(sum);

        Set<String> sets = new HashSet<>();
        for(int i = 0; i < s.length() - k + 1; i++){
            System.out.print(i + k);
            System.out.print(" ");
            sets.add(s.substring(i, i + k));
            System.out.println(s.substring(i, i + k));
        }
        System.out.println(sets.size());

        return sets.size() >= sum;
    }
}
