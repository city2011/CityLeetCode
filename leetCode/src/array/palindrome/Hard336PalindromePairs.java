package array.palindrome;

import java.util.*;

/**
@author city
@date 1:35 AM 2020/8/7
 
############################################# 题目描述 #############################################

336. 回文对
给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。



示例 1：

输入：["abcd","dcba","lls","s","sssll"]
输出：[[0,1],[1,0],[3,2],[2,4]]
解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
示例 2：

输入：["bat","tab","cat"]
输出：[[0,1],[1,0]]
解释：可拼接成的回文串为 ["battab","tabbat"]

！！！！
！！！！
！！！！
这个题的知识点比较密集

1 回文串的判断 - todo manacher还是想看一下，后面记录
2 字典树的构建、标记 和 查找
3 回文对的组成规律
4 边界处理

############################################# 题目描述 #############################################
 */
public class Hard336PalindromePairs {
    public static void main(String[] args) {
        Hard336PalindromePairs m = new Hard336PalindromePairs();

        String [] input = {"abcd","dcba","aaa","","sssll"};
        List<List<Integer>> ans1 = m.palindromePairsUsingTrie(input);
        List<List<Integer>> ans2 = m.palindromePairsUsingHashMap(input);

        System.out.println(ans1);
        System.out.println(ans2);

    }

    // 字典树使用的数据结构
    class Node {
        int [] ch = new int [26];
        int flag;

        Node(){
            flag = -1;
        }
    }

    private List<Node> tree = new ArrayList<>();

    /**
     *@author city
     *@description 解法1，使用字典树，线性时间查找字符串是否存在
     *@date 1:40 AM 2020/8/7
     *@param words
     * description
     *@return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> palindromePairsUsingTrie(String[] words){
        tree.add(new Node());
        int n = words.length;
        for(int i = 0; i < n; i++) {
            insert(words[i], i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = words[i].length();
            for (int j = 0; j <= m; j++) {
                if(isPalindrome(words[i], j, m - 1)){
                    int leftId = findWord(words[i], 0, j - 1);
                    // -1 表示字典树里面没有 0 ~ j-1 的反转字符串，
                    // i 表示字典树里面的反转字符串等于i本身，也就是在字典树里面没有找到另外一个字符串。无法组成回文对。
                    if(leftId != -1 && leftId != i){
                        ans.add(Arrays.asList(i, leftId));
                    }
                }

                if(j != 0 && isPalindrome(words[i], 0, j - 1)){
                    int rightId = findWord(words[i], j, m - 1);
                    if(rightId != -1 && rightId != i){
                        ans.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ans;
    }

    private int findWord(String word, int left, int right) {
        int add = 0;
        for (int i = right; i >= left; i--) {
            int x = word.charAt(i) - 'a';
            if(tree.get(add).ch[x] == 0){
                return -1;
            }
            add = tree.get(add).ch[x];
        }
        return tree.get(add).flag;
    }

    private boolean isPalindrome(String word, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if(word.charAt(left + i) != word.charAt(right - i)){
                return false;
            }
        }
        return true;
    }

    private void insert(String word, int id) {
        int len = word.length(), add = 0;
        for (int i = 0; i < len; i++) {
            int x = word.charAt(i) - 'a';
            if(tree.get(add).ch[x] == 0){
                tree.add(new Node());
                tree.get(add).ch[x] = tree.size() - 1;
            }
            add = tree.get(add).ch[x];

        }

        // 如果word是一个空串。则第一个Node的flag指向id。
        tree.get(add).flag = id;
    }

    // HashMap使用的数据结构
    private Map<String, Integer> indices = new HashMap<>();

    /**
     *@author city
     *@description 解法2， 使用HashMap 记录反转后字符串
     *@date 1:40 AM 2020/8/7
     *@param words
     * description
     *@return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> palindromePairsUsingHashMap(String[] words){

        for (int i = 0; i < words.length; i++) {
            indices.put(new StringBuffer(words[i]).reverse().toString(), i);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int m = word.length();
            for (int j = 0; j <= m; j++) {
                if(isPalindrome(word, j, m - 1)){
                    int leftId = findInMap(word, 0, j - 1);
                    if(leftId != -1 && leftId != i){
                        ans.add(Arrays.asList(i, leftId));
                    }
                }
                if(j != 0 && isPalindrome(word, 0, j - 1)){
                    int rightId = findInMap(word, j , m - 1);
                    if(rightId != -1 && rightId != i){
                        ans.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ans;
    }

    private int findInMap(String word, int left, int right) {
        return indices.getOrDefault(word.substring(left, right + 1), -1);
    }
}
