package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class L126WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 将wordList放到哈希表里，便于判断某个单测是否在 wordList里
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord) || !wordSet.contains(beginWord)) {
            return res;
        }

        // 第一步：双向广度优先遍历 得到后继节点列表 successors
        // key : 字符串 value：key的后继节点列表
        Map<String, Set<String>> successors = new HashMap<>();
        boolean found = bidirectionBfs(beginWord, endWord, wordSet, successors);
        if (!found) {
            return res;
        }

        // 第二步：基于后继节点列表successors, 使用回溯算法得到所有最短路径列表
        Deque<String> path = new ArrayDeque<>();
        path.addLast(beginWord);
        dfs(beginWord, endWord, successors, path, res);
        return res;
    }

    private boolean bidirectionBfs(String beginWord,
                                   String endWord,
                                   Set<String> wordSet,
                                   Map<String, Set<String>> successors) {
        // 记录访问过的单词
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);

        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        int wordLen = beginWord.length();
        boolean forward = true;
        boolean found = false;

        // 在保证 beginVisited 总是比较小（可以相等）的集合的前提下，以及!endVisited.isEmpty() 可以省略
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 一直保证 beginVisited 是相对较小的集合，方便后续编码
            if (beginVisited.size() > endVisited.size()){
                Set<String> tmp = beginVisited;
                beginVisited = endVisited;
                endVisited = tmp;
                // 只要交换，就更改方向，以便维护 successors 的定义
                forward = !forward;
            }
            Set<String> nextLevelVisited = new HashSet<>();
            // 默认 beginVisited 是小集合， 因此从beginVisited出发
            for(String currentWord : beginVisited) {
                char[] charArray = currentWord.toCharArray();


                //  todo 这一段可以优化。时间复杂度挺高
                for(int i = 0; i < wordLen; i++) {
                    char originalChar = charArray[i];
                    for(char j = 'a'; j <= 'z'; j++){
                        if(originalChar == j){
                            continue;
                        }
                        charArray[i] = j;
                        String nextWord = new String(charArray);
                        if(wordSet.contains(nextWord)){
                            if(endVisited.contains(nextWord)){
                                found = true;
                                // 在另一侧找到单词以后，还需要把这一层关系添加到"后继节点列表"
                                addToSuccessors(successors, forward, currentWord, nextWord);
                            }
                        }

                        if(!visited.contains(nextWord)){
                            nextLevelVisited.add(nextWord);
                            addToSuccessors(successors, forward, currentWord, nextWord);
                        }

                    }
                    charArray[i] = originalChar;
                }

            }
            beginVisited = nextLevelVisited;
            visited.addAll(nextLevelVisited);
            if(found){
                break;
            }
        }
        return found;
    }

    private void dfs(String beginWord,
                     String endWord,
                     Map<String, Set<String>> successors,
                     Deque<String> path,
                     List<List<String>> res){
        if (beginWord.equals(endWord)) {
            res.add((new ArrayList<>(path)));
            return;
        }

        if(!successors.containsKey(beginWord)){
            return;
        }

        Set<String> successorWords = successors.get(beginWord);
        for(String next : successorWords){
            path.addLast(next);
            dfs(next, endWord, successors, path, res);
            path.removeLast();
        }
    }

    private void addToSuccessors(Map<String, Set<String>> successors,
                                 boolean forward,
                                 String currentWord,
                                 String nextWord) {
        if (!forward) {
            String temp = currentWord;
            currentWord = nextWord;
            nextWord = temp;
        }

        successors.computeIfAbsent(currentWord, a -> new HashSet<>());
        successors.get(currentWord).add(nextWord);

    }

}
