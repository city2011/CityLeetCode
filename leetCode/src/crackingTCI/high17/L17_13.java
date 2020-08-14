package crackingTCI.high17;

import java.util.HashSet;
import java.util.Set;

/**
@author city
@date 10:52 PM 2020/7/9
 
############################################# 题目描述 #############################################

哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。

注意：本题相对原题稍作改动，只需返回未识别的字符数

 

示例：

输入：
dictionary = ["looked","just","like","her","brother"]
sentence = "jesslookedjustliketimherbrother"
输出： 7
解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
提示：

0 <= len(sentence) <= 1000
dictionary中总字符数不超过 150000。
你可以认为dictionary和sentence中只包含小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/re-space-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

############################################# 题目描述 #############################################
 */
public class L17_13 {
    public static void main(String[] args) {

    }

    public int respace(String[] dictionary, String sentence) {
        Set<String> dict = new HashSet<>();
        for(String s : dictionary){
            dict.add(s);
        }

        Integer[] memo = new Integer[sentence.length()];
        return leastInvalid(dict, sentence, 0, memo);
    }

    int leastInvalid(Set<String> dict, String sentence, int start, Integer[] memo){
        if(start >= sentence.length()){
            return 0;
        }
        if(memo[start] != null)
            return memo[start];

        int bestInvalid = Integer.MAX_VALUE;
        String partial = "";
        int index = start;
        while (index < sentence.length()) {
            char c = sentence.charAt(index);
            partial += c;
            int invalid = dict.contains(partial) ? 0 : partial.length();
            if(invalid < bestInvalid){
                int p = leastInvalid(dict, sentence, index + 1, memo);
                if(invalid + p < bestInvalid){
                    bestInvalid = invalid + p;
                    if(bestInvalid == 0) break;
                }
            }
            index++;
        }

        memo[start] = bestInvalid;
        return memo[start];
    }

    ParseResult split(Set<String> dict, String sentence, int start, ParseResult[] memo){
        if(start >= sentence.length()){
            return new ParseResult(0, "");
        }
        if(memo[start] != null)
            return memo[start];

        int bestInvalid = Integer.MAX_VALUE;
        String bestParsing = null;
        String partial = "";
        int index = start;
        while (index < sentence.length()) {
            char c = sentence.charAt(index);
            partial += c;
            int invalid = dict.contains(partial) ? 0 : partial.length();
            if(invalid < bestInvalid){
                ParseResult p = split(dict, sentence, index + 1, memo);
                if(invalid + p.valid < bestInvalid){
                    bestInvalid = invalid + p.valid;
                    bestParsing = partial + " " + p.parsed;
                    if(bestInvalid == 0) break;
                }
            }
            index++;
        }

        memo[start] = new ParseResult(bestInvalid, bestParsing);
        return memo[start];
    }

    private class ParseResult{
        int valid;
        String parsed;
        public ParseResult(int val, String p){
            valid = val;
            parsed = p;
        }
    }

}
