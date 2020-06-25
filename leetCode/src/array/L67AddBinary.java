package array;

public class L67AddBinary {
    public static void main(String[] args) {
        L67AddBinary m = new L67AddBinary();
        String a = "111";
        String b = "";

        String res = m.addBinary(a, b);
        System.out.println(res);
    }

    public String addBinary(String a, String b) {
        int incre = 0;

        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int n = a.length();
        int m = b.length();

        char[] cs = new char[n];

        for (int i = n - 1, j = m - 1; j >= 0; i--, j--) {
            int tsum = incre;
            if (a.charAt(i)=='1')
                tsum++;
            if(b.charAt(j)=='1')
                tsum++;

            switch (tsum) {
                case 0:
                    incre = 0;
                    cs[i] = '0';
                    break;
                case 1:
                    incre = 0;
                    cs[i] = '1';
                    break;
                case 2:
                    incre = 1;
                    cs[i] = '0';
                    break;
                case 3:
                    incre = 1;
                    cs[i] = '1';
                    break;
                default:
                    throw new IllegalArgumentException("这个异常理论上是不可能的");
            }
        }

        for(int i = n - m - 1; i >= 0; i--){
            int tsum = incre;
            if (a.charAt(i)=='1')
                tsum++;
            switch (tsum) {
                case 0:
                    incre = 0;
                    cs[i] = '0';
                    break;
                case 1:
                    incre = 0;
                    cs[i] = '1';
                    break;
                case 2:
                    incre = 1;
                    cs[i] = '0';
                    break;
                default:
                    throw new IllegalArgumentException("这个异常理论上是不可能的");
            }
        }

        if(incre == 1){
            return "1"+ String.valueOf(cs);
        } else {
            return cs.length == 0 ? "0" : String.valueOf(cs);
        }
    }
}
