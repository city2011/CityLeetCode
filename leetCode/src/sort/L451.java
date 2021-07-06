package sort;

import java.util.*;

public class L451 {
    public static void main(String[] args) {
        L451 m = new L451();
        String input = "treeee";
        String ans = m.frequencySort(input);
        System.out.println(ans);
        System.out.println(m.frequencySort2(input));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> statis = new HashMap<>();
        for (char c : s.toCharArray()) {
            statis.put(c, statis.getOrDefault(c, 0) + 1);
        }
        Map<Integer, List<Character>> time2char = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : statis.entrySet()) {
            if (time2char.get(entry.getValue()) == null) {
                List<Character> tmp = new ArrayList<>();
                tmp.add(entry.getKey());
                time2char.put(entry.getValue(), tmp);
            } else {
                time2char.get(entry.getValue()).add(entry.getKey());
            }
        }
        List<Integer> counts = new ArrayList<>(time2char.keySet());
        Collections.sort(counts, (a, b) -> b - a);
        StringBuilder sb = new StringBuilder();
        for (Integer count : counts) {
            for (Character cs : time2char.get(count)) {
                for (int i = 0; i < count; i++) {
                    sb.append(cs);
                }
            }
        }
        return sb.toString();
    }

    public String frequencySort2(String s) {
        Map<Character, Integer> statis = new HashMap<>();
        for (char c : s.toCharArray()) {
            statis.put(c, statis.getOrDefault(c, 0) + 1);
        }
        List<Character> list = new ArrayList<>(statis.keySet());
        list.sort((a, b) -> statis.get(b) - statis.get(a));

        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            int count = statis.get(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
