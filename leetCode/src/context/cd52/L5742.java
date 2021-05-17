package context.cd52;

public class L5742 {
    public static void main(String[] args) {
        L5742 m = new L5742();
        System.out.println(m.sortSentence("is2 sentence4 This1 a3"));
    }
    public String sortSentence(String s) {
        String ans = "";
        String[] strArr = s.split(" ");
        int n = strArr.length;
        String[] ansArr = new String[n];
        for(String str : strArr) {
            Integer seq = Integer.parseInt(str.charAt(str.length() - 1)+"");
            ansArr[seq - 1] = str.substring(0, str.length() - 1);
        }

        for(int i = 0; i < n - 1; i++){
            ans += ansArr[i] + " ";
        }
        ans += ansArr[n - 1];
        return ans;
    }
}
