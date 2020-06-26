package array.rabinKarp;

import java.util.HashSet;

/**
@author city
@date 11:11 PM 2020/6/26
 
############################################# 题目描述 #############################################

知乎题解
https://zhuanlan.zhihu.com/p/150853583

############################################# 题目描述 #############################################
 */
public class L1044LongestRepeatedSubString {
    public static void main(String[] args) {
        L1044LongestRepeatedSubString m = new L1044LongestRepeatedSubString();
        String res = m.longestDupSubstring("ababaefefe");
        System.out.println(res);
    }

    /*
        Rabin-Karp with polynomial rolling hash.
        Search a substring of given length
        that occurs at least 2 times.
        Return start position if the substring exits and -1 otherwise.
        */
    public int search(int L, int n, int[] nums) {
        // roll hash的base值，26个字符，用26进制玩。
        int a = 26;

        // 防止hash值溢出，使用的mod数
        long modulus = (long) Math.pow(10, 16);

        // 计算长度为L的第一个子串的 roll hash 值
        long h = 0;
        for (int i = 0; i < L; ++i)
            h = (h * a + nums[i]) % modulus;

        // 存储已出现过的hash值
        HashSet<Long> seen = new HashSet<>();
        seen.add(h);

        // 第一位的26的L幂 取模 : aL % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i)
            aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;

            if (seen.contains(h)) return start;
            seen.add(h);
        }
        return -1;
    }

    public String longestDupSubstring(String S) {
        int n = S.length();
        // 将字符串映射成 hash值 （26进制的数值）
        // 实现常数时间复杂度的滑动窗口
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i)
            nums[i] = (int) S.charAt(i) - (int) 'a';

        // 二分搜索, L = 要定位的重复字符串的长度
        int minRepeat = 1, maxRepeat = n;
        int L;
        while (minRepeat != maxRepeat) {
            L = minRepeat + (maxRepeat - minRepeat) / 2;

            if (search(L, n, nums) != -1)
                minRepeat = L + 1;
            else
                maxRepeat = L;
        }

        int start = search(minRepeat - 1, n, nums);
        return start != -1 ? S.substring(start, start + minRepeat - 1) : "";
    }
}
