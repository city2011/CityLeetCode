package experience;

import java.util.ArrayList;
import java.util.List;

/**
@author city
@date 11:10 PM 2020/8/10
 
############################################# 题目描述 #############################################

696. 计数二进制子串
给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。

重复出现的子串要计算它们出现的次数。

示例 1 :

输入: "00110011"
输出: 6
解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。

请注意，一些重复出现的子串要计算它们出现的次数。

另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
示例 2 :

输入: "10101"
输出: 4
解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
注意：

s.length 在1到50,000之间。
s 只包含“0”或“1”字符。

https://leetcode-cn.com/problems/count-binary-substrings/

############################################# 题目描述 #############################################
 */
public class L696CountBinarySubString {
    public static void main(String[] args) {
        L696CountBinarySubString m = new L696CountBinarySubString();
        String s =  "001100001000010001111";
        int ans1 = m.countBinarySubstrings(s);
        int ans2 = m.countBinarySubstrings1(s);

        System.out.println(ans1);
        System.out.println(ans2);
    }

    private int countBinarySubstrings1(String s) {
        List<Integer> statis = new ArrayList<>();
        int n = s.length();
        int ptr = 0;
        while(ptr < n){
            int count = 0;
            char c = s.charAt(ptr);
            while(ptr < n && s.charAt(ptr) == c){
                ++ptr;
                ++count;
            }
            statis.add(count);
        }

        if(statis.size() < 2){
            return 0;
        }

        int ans = 0;
        for(int i = 1; i < statis.size(); i++){
            ans += Math.min(statis.get(i), statis.get(i - 1));
        }
        return ans;
    }

    private int countBinarySubstrings(String s) {
        int n = s.length();
        int ptr = 0, last = 0, ans = 0;
        while(ptr < n){
            int count = 0;
            char c = s.charAt(ptr);
            while(ptr < n && s.charAt(ptr) == c){
                ++ptr;
                ++count;
            }
            ans += Math.min(last, count);
            last = count;
        }
        return ans;
    }
}
