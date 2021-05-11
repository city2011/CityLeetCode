package array.xor;

import java.util.Arrays;

public class L1734 {
    public static void main(String[] args) {
        L1734 m = new L1734();
        int [] ans = m.decode(new int [] {3, 1});
        System.out.println(Arrays.toString(ans));
    }

    public int[] decode(int[] encoded) {
        int n = encoded.length;
        int [] ans = new int [n + 1];
        int sumXor = 0;
        for(int i = 1; i <= n + 1; i++) {
            sumXor ^= i;
            System.out.print("["+i+"]"+sumXor+"  ");
        }
        System.out.println();
        System.out.println(sumXor);

        int encodeSumXor = 0;
        for(int i = 1; i < n; i+=2){
            encodeSumXor ^= encoded[i];
        }
        System.out.println(encodeSumXor);

        ans[0] = sumXor ^ encodeSumXor;
        for(int i = 0; i < n; i++) {
            ans[i + 1] = ans[i] ^ encoded[i];
        }
        return ans;
    }
}
