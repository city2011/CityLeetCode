package context;

public class C5253 {
    public long[] kthPalindrome(int[] queries, int intLength) {
        boolean even = intLength % 2 == 0;
        long[] res = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = kthQuery(intLength, even, queries[i]);
        }
        return res;
    }

    public long kthQuery(int intLength, boolean even, int query) {
        int x = (intLength + 1) / 2 - 1;
        int max = 1;
        for (int i = 0; i < x; i++) {
            max *= 10;
        }
        int fnum = query - 1;
        fnum += max;

        if (fnum > max * 10) {
            return -1L;
        }


        String str = String.valueOf(fnum);
        if(even) {
            str += reverse(str);
        } else {
            str = str + reverse(str.substring(0,str.length() - 1));
        }
        return Long.parseLong(str);
    }

    private String reverse(String before) {
        if(before == null || before.length() == 0) {
            return "";
        }
        char [] cs = before.toCharArray();
        for (int i = 0; i < cs.length / 2; i++) {
            char tmp = cs[i];
            cs[i] = cs[cs.length - 1 - i];
            cs[cs.length - 1 - i] = tmp;
        }
        return new String(cs);
    }
}
