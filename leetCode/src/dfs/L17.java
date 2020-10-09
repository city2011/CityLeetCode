package dfs;

import java.util.*;

public class L17 {
    private static Map<Integer, char[]> characters = new HashMap<>();
    static {
        for (int i = 2; i <= 6; i++) {
            char[] tx = new char[3];
            for (int j = 0; j < 3; j++) {
                tx[j] = (char)('a' + j + 3 * (i - 2));
            }
            characters.put(i, tx);
        }
        characters.put(7, new char [] {'p','q','r','s'});
        characters.put(8, new char [] {'t','u','v'});
        characters.put(9, new char [] {'w','x','y','z'});
    }

    List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        characters.entrySet().forEach(x -> System.out.println(Arrays.toString(x.getValue())));
        System.out.println(characters);

        L17 m = new L17();
        String digits = "27363";
        List<String> rest = m.letterCombinations(digits);
        System.out.println(rest);
    }

    public List<String> letterCombinations(String digits) {
        char [] cs = digits.toCharArray();
        dfs(cs, 0, digits.length(), new StringBuilder());
        return ans;
    }

    private void dfs(char[] digits, int idx, int aim, StringBuilder sb){
        if(idx == aim){
            ans.add(sb.toString());
            return;
        }
        char [] x = characters.get(digits[idx] - '0');
        for(int i = 0; i < x.length; i++){
            sb.append(x[i]);
            dfs(digits, idx + 1, aim, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
