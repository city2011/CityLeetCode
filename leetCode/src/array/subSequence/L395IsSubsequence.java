package array.subSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
@author city
@date 2:26 AM 2020/7/28

############################################# 题目描述 #############################################

给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

示例 1:
s = "abc", t = "ahbgdc"

返回 true.

示例 2:
s = "axc", t = "ahbgdc"

返回 false.

后续挑战 :

如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

致谢:

特别感谢 @pbrother 添加此问题并且创建所有测试用例。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/is-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

############################################# 题目描述 #############################################
 */
public class L395IsSubsequence {
    public static void main(String[] args) {
        L395IsSubsequence m = new L395IsSubsequence();
        List<String> s = new ArrayList<>();
        s.add("axc");
        s.add("abc");
        s.add("acg");
        String t = "ahbgdc";
        List<Boolean> ans = m.isSubsequenceDp(s, t);
        System.out.println(ans);

        String sss = "axc";
        boolean ans1 = m.isSubsequence(sss, t);
        System.out.println(ans1);
    }

    // 双指针遍历. 针对t很长，且s只有一个的情况。
    private boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int sIndex = 0, tIndex = 0;

        while(sIndex < n && tIndex < m){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }
        }
        return sIndex == n;
    }

    // 动态规划，为t建立 每个位置下一个字符的"索引"。
    // 针对扩展的情况。很多很多s，只有一个t，在t中匹配每个s
    private List<Boolean> isSubsequenceDp(List<String> s, String t) {
        int m = t.length();
        int [][] dp = new int [m+1][26];
        for(int i = 0; i < 26; i++){
            dp[m][i] = m;
        }
        dp[m][t.charAt(t.length() - 1) - 'a'] = m - 1;

        for(int i = m - 1; i >= 0; i--){
            for(int j = 0; j < 26; j++){
                if(t.charAt(i) == ('a' + j)){
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        for(int i = 0; i < 26; i++){
            System.out.print((char)('a' + i) +", ");
        }
        System.out.println();

        for(int [] ddd : dp) {
            System.out.println(Arrays.toString(ddd));
        }

        List<Boolean> ans = new ArrayList<>();
        for(String ss : s){
            isSubSequence(ans, dp, ss, m);
        }
        return ans;
    }

    private void isSubSequence(List<Boolean> ans, int [][] dp, String s, int m){
        int next = 0;
        for(int i = 0; i < s.length(); i++){
            if(dp[next][s.charAt(i) - 'a'] == m){
                ans.add(false);
                return;
            }
            next = dp[next][s.charAt(i) - 'a'] + 1;
        }
        ans.add(true);
    }

}
