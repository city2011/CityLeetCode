package array.kmp;

import java.util.Arrays;

public class L214KmpManacher {
    public static void main(String[] args) {

    }


    public String shortestPalindromeRK(String s) {
            int n = s.length();
            int base = 131, mod = 1000000007;
            int left = 0, right = 0, mul = 1;
            int best = -1;
            for (int i = 0; i < n; ++i) {
                left = (int) (((long) left * base + s.charAt(i)) % mod);
                right = (int) ((right + (long) mul * s.charAt(i)) % mod);
                if (left == right) {
                    best = i;
                }
                mul = (int) ((long) mul * base % mod);
            }
            String add = (best == n - 1 ? "" : s.substring(best + 1));
            StringBuffer ans = new StringBuffer(add).reverse();
            ans.append(s);
            return ans.toString();
    }

    public String shortestPalindrome(String s) {
        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int best = -1;
        for (int i = n - 1; i >= 0; --i) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                ++best;
            }
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }
}
