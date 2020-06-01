package context.c190.c191;

import java.util.Arrays;

public class L5425 {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        long ret = (long)a * b;
        System.out.println(ret);
        System.out.println((int) ret % 1000000007);
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int n = horizontalCuts.length;
        int m = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int nmax = horizontalCuts[0] - 0;
        for(int i = 1; i < n; i++){
            nmax = Math.max(nmax, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        nmax = Math.max(nmax, h - horizontalCuts[n-1]);
        System.out.println(nmax);

        int mmax = verticalCuts[0] - 0;
        for(int i = 1; i < m; i++){
            mmax = Math.max(mmax, verticalCuts[i] - verticalCuts[i-1]);
        }
        mmax = Math.max(mmax, w - verticalCuts[m-1]);
        System.out.println(mmax);

        return (nmax * mmax) % (10^9 + 7);
    }
}
