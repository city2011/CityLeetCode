package array.kmp;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author city
 * @date 2:25 PM 2020/6/27
 * <p>
 * ############################################# 题目描述 #############################################
 * <p>
 * <p>
 * <p>
 * ############################################# 题目描述 #############################################
 */
public class L459RepeatedSubStringPattern {
    public static void main(String[] args) {
        L459RepeatedSubStringPattern m = new L459RepeatedSubStringPattern();

        boolean res = m.repeatedSubstringPatternKmp("abababab");
        System.out.println(res);

        boolean ret = m.repeatedSubstringPattern("abababab");
        System.out.println(ret);
    }

    /**
     *@author city
     *@solution notes

     解法一
     今天死磕一下KMP。但本题不大适合KMP，有更优秀的解法

     Kmp的next记录的是 当前位置前一个位置，前后缀最大公共部分的长度

     next[n] 是包含整个字符串最后一个字符，最长的前后缀公共部分的长度
     假设字符串是由内部的子串重复叠加起来的。那 n - next[n] 留下的则是最基本的 重复子串

     取模

     *@date
     */
    private boolean repeatedSubstringPatternKmp(String s) {
        int n = s.length();
        if (n == 0) return false;

        char[] p = s.toCharArray();

        int[] next = new int[n + 1];
        next[0] = -1;

        int i = 0, k = -1;
        while (i < n) {
            if (k == -1 || p[i] == p[k]) {
                i++;
                k++;
                next[i] = k;
            } else {
                k = next[k];
            }
        }
        System.out.println(Arrays.toString(next));

        return next[n] > 0 && n % (n - next[n]) == 0;
    }


    /**
     * @author city
     * @solution notes
     * <p>
     * 解法二
     * @date 2:27 PM 2020/6/27
     */
    private boolean repeatedSub(String s){
        return (s + s).indexOf(s, 1) != s.length();
    }

    /**
     * @author city
     * @solution notes
     *
     * 解法三
     * 基于解法二，使用 Rabin-Karp 比较字符串
     *
     *
     * @date 2:27 PM 2020/6/27
     */
    private boolean repeatedSubstringPattern(String s) {
        int start = search(s);
        return start != s.length();
    }

    private int search(String s) {
        int L = s.length();
        String x = s + s;
        int[] nums = new int[x.length()];

        for (int i = 0; i < x.length(); ++i)
            nums[i] = (int) x.charAt(i) - (int) 'a';

        // roll hash的base值，26个字符，用26进制玩。
        int a = 256;

        // 防止hash值溢出，使用的mod数
        long modulus = (long) Math.pow(10, 16);

        // 计算长度为L的第一个子串的 roll hash 值
        long sh = 0;
        for (int i = 0; i < L; ++i)
            sh = (sh * a + nums[i]) % modulus;

        // 第一位的26的L幂 取模 : aL % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i)
            aL = (aL * a) % modulus;

        long h = sh;
        for (int start = 1; start < x.length() - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;

            if (h == sh && s.equals(x.substring(start, start + L)))
                return start;
        }
        return -1;
    }

}
