package array;

public class L557ReverseWordsInAString3 {
    public static void main(String[] args) {
        L557ReverseWordsInAString3 m = new L557ReverseWordsInAString3();
        String s = "Let's take LeetCode contest";
        String ss = m.reverseWords(s);
        System.out.println(ss);
    }

    public String reverseWords(String s) {
        String [] tmp = s.split(" ");
        if (tmp.length <= 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(String ts : tmp){
            sb.append(reverseWord(ts)).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String reverseWord(String w){
        StringBuilder sb = new StringBuilder();
        for(int i = w.length() - 1; i >= 0; i--){
            sb.append(w.charAt(i));
        }
        return sb.toString();
    }
}
