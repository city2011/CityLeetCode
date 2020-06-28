package array.kmp;

public class L28strIndexOf {
    public static void main(String[] args) {
        L28strIndexOf m = new L28strIndexOf();

        m.strStr("abcdefghikk", "defgh");
    }

    public int strStr(String haystack, String needle) {
        if(needle == "")
            return 0;
        int [] next = new int[needle.length()];
        next[0] = -1;
        int i = 0, j = -1;
        char [] p = needle.toCharArray();
        while(i < p.length - 1){
            if(j == -1 || p[i] == p[j]){
                i++;
                j++;
                next[i] = j;
            }
            else
                j = next[j];
        }

        int k = 0;
        int a = 0;
        while(a < haystack.length()){
            if(k == -1 || haystack.charAt(a) == needle.charAt(k)){
                k++;
                a++;
            } else
                k = next[k];

            if(k == needle.length())
                return a - needle.length() + 1;
        }
        return -1;

    }
}
