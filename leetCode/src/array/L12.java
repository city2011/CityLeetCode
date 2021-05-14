package array;

public class L12 {
    public static void main(String[] args) {
        L12 m = new L12();
        String ans = m.intToRoman(3999);
        System.out.println(ans);
    }

    public String intToRoman(int num) {
        String[] ans = new String[4];
        int base = 1000;
        int i = 0;
        while(base > 0){
            int tmp = num / base;
            num = num - base * tmp;
            ans[i++] = generate(tmp, base);
            base = base / 10;
        }

        StringBuilder romanNum = new StringBuilder();
        for(String x : ans) {
            if(!"".equals(x)){
                romanNum.append(x);
            }
        }
        return romanNum.toString();
    }

    private String generate(int num, int base){
        switch(base){
            case 1000 :
                return generate("M", "U", "U", num);
            case 100 :
                return generate("C", "D", "M", num);
            case 10 :
                return generate("X", "L", "C", num);
            case 1 :
                return generate("I", "V", "X", num);
            default :
                return "????";
        }
    }

    private String generate(String a, String b, String c, int num) {
        switch(num){
            case 0:
                return "";
            case 1:
                return a;
            case 2:
                return a + a;
            case 3:
                return a + a + a;
            case 4:
                return a + b;
            case 5:
                return b;
            case 6:
                return b + a;
            case 7:
                return b + a + a;
            case 8:
                return b + a + a + a;
            case 9:
                return a + c;
            default:
                return "!!!!";
        }
    }

    public String intToRomanMethod2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }

    public String intToRomanMethod3(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }
}
