package context;

import java.util.*;

public class C5302 {
}

class Encrypter {
    char[] keys;
    String[] values;
    HashSet<String> dics = new HashSet<>();
    Map<String, List<Character>> v2k = new HashMap<>();
    Map<Character, Integer> pos = new HashMap<>();
    int res;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        this.keys = keys;
        this.values = values;
        dics.addAll(Arrays.asList(dictionary));
        for (int i = 0; i < values.length; i++) {
            if (v2k.get(values[i]) == null){
                List<Character> tmp = new ArrayList<>();
                tmp.add(keys[i]);
                v2k.put(values[i], tmp);
            } else {
                v2k.get(values[i]).add(keys[i]);
            }
            pos.put(keys[i], i);
         }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (char c :
                word1.toCharArray()) {
            sb.append(values[pos.get(c)]);
        }
        return sb.toString();
    }

    public int decrypt(String word2) {
        int n = word2.length();
        String[] dv = new String[n / 2];
        for(int i = 0; i < word2.length(); i += 2) {
            dv[i/2] = word2.substring(i, i + 2);
            if(v2k.get(dv[i/2]) == null) {
                return 0;
            }
        }
        HashSet<String> ndics = new HashSet<>();
        for (String dic : dics) {
            if(n/2 == dic.length()) {
                ndics.add(dic);
            }
        }
        res = 0;
        StringBuilder sb = new StringBuilder();
        dfs(dv, 0, n / 2, sb, ndics);
        return res;
    }

    public void dfs(String[] dv, int idx, int n, StringBuilder sb, HashSet<String> ndics) {
        if(idx == n) {
            if(ndics.contains(sb.toString())) {
                res+=1;
            }
        }
        for (Character c : v2k.get(dv[idx])) {
            sb.append(c);
            dfs(dv, idx+1, n, sb, ndics);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

class Encrypter2 {
    private String[] values = new String[26];
    private HashMap<String, Integer> map = new HashMap<>();

    public Encrypter2(char[] keys, String[] values, String[] dictionary) {
        for (int i = 0; i < keys.length; i++) {
            this.values[keys[i] - 'a'] = values[i];
        }
        for (String word : dictionary) {
            String s = encrypt(word);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (char c : word1.toCharArray()) {
            sb.append(values[c - 'a']);
        }
        return "" + sb;
    }

    public int decrypt(String word2) {
        return map.getOrDefault(word2, 0);
    }
}