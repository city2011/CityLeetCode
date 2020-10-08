package array.reverse;

public class L345ReverseVowelsofaString {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] cs = s.toCharArray();

        while(left < right){
            while(left < right && !isVowel(cs[left])){
                left++;
            }

            while(left < right && !isVowel(cs[right])){
                right--;
            }

            if(left < right){
                swap(cs, left, right);
                left++;
                right--;
            }
        }

        return String.valueOf(cs);
    }

    private boolean isVowel(char x){
        return x == 'a' || x == 'e' || x == 'i' || x =='o' || x=='u' || x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U';
    }

    private void swap(char[] cs, int a, int b){
        char tmp = cs[a];
        cs[a] = cs[b];
        cs[b] = tmp;
    }
}
