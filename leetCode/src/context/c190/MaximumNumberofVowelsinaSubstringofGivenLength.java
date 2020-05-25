package context.c190;

public class MaximumNumberofVowelsinaSubstringofGivenLength {
    public static void main(String[] args) {
        MaximumNumberofVowelsinaSubstringofGivenLength main = new MaximumNumberofVowelsinaSubstringofGivenLength();


        int ans = main.maxVowels("novowels", 1);
        System.out.println(ans);
    }
    public int maxVowels(String s, int k) {
        int ans = 0;

        char [] cs = s.toCharArray();

        if(k > cs.length){
            return ans;
        }

        for(int i = 0; i < k; i++){
            if(isVowel(cs[i]))
                ans++;
        }
        int max = ans;
        System.out.println(ans);

        for(int j = 0; j < cs.length - k; j++){
            if(isVowel(cs[j])) ans--;
            if(isVowel(cs[k+j])) ans++;
            max = Math.max(max, ans);
        }

        return max;
    }

    private boolean isVowel(char c){
        return c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c =='u';
    }
}
