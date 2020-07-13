package dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
@author city
@date 11:37 PM 2020/7/4

############################################# 题目描述 #############################################

32. 最长有效括号
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
通过次数80,107提交次数246,113

LeetCode Url
https://leetcode-cn.com/problems/longest-valid-parentheses/

############################################# 题目描述 #############################################
 */
public class L36LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        int res = 0;
        deque.push(-1);

        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                deque.push(i);
            } else {
                int currentStartPoint = deque.pop();
                if(deque.isEmpty()){
                    deque.push(i);
                } else {
                    res = Math.max(res, i - currentStartPoint + 1);
                }
            }
        }
        return res;
    }
}
