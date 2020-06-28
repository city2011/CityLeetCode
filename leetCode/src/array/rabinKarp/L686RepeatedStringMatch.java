package array.rabinKarp;

import java.util.Arrays;

/**
@author city
@date 1:50 AM 2020/6/27

############################################# 题目描述 #############################################

686. 重复叠加字符串匹配
给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。

举个例子，A = "abcd"，B = "cdabcdab"。

答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。

注意:

A 与 B 字符串的长度在1和10000区间范围内。

############################################# 题目描述 #############################################
 */
public class L686RepeatedStringMatch {
    public static void main(String[] args) {
        L686RepeatedStringMatch m = new L686RepeatedStringMatch();
        String A = "";
        String B = "aac";
        int res = m.repeatedStringMatch(A, B);
        System.out.println(res);
    }

    private int repeatedStringMatch(String A, String B) {

        int Blen = B.length();
        if(Blen == 0)
            return 1;

        int Alen = A.length();
        if (Alen == 0){
            return -1;
        }
        int endLen = Alen + Blen;
        String nA = A;

        while(nA.length() < endLen){
            nA += A;
        }

        int [] numsA = new int [nA.length()];
        for(int i = 0; i < nA.length(); i++){
            numsA[i] = nA.charAt(i) - 'a';
        }

        System.out.println(Arrays.toString(numsA));

        long hash = 0;
        long hashA = 0;
        int a = 1024;
        int mod = Integer.MAX_VALUE;
        for(int i = 0; i < B.length(); i++){
            hash = (hash * a + B.charAt(i) - 'a') % mod;
            hashA = (hashA * a + numsA[i]) % mod;
        }


        if (hashA == hash && B.equals(nA.substring(0, B.length()))){
            return B.length() % Alen == 0 ? B.length() / Alen : B.length() / Alen + 1;
        }

        long al = 1;
        for(int i = 0; i < B.length(); i++){
            al = (al * a) % mod;
        }

        for(int i = 0; i < Alen - 1; i++){
            hashA = (hashA * a - al * numsA[i] % mod + mod) % mod;
            hashA = (hashA + numsA[i + B.length()]) % mod;
            if(hashA == hash && B.equals(nA.substring(i+1, i + B.length()+1))){
                return (i + B.length() + 1) % Alen == 0 ? (i + B.length()+1) / Alen : (i + B.length()+1) / Alen + 1;
            }
        }

        return -1;
    }

}
