package context.c234;

public class C5715 {
    public int reinitializePermutation(int n) {
        Usf usf = new Usf();
        usf.init(n);

        for (int i = 0; i < n; i++) {
            int ni = i % 2 == 0 ? i / 2 : (n / 2 + (i - 1) / 2);
            usf.union(i, ni);
        }

        return usf.maxUsfNum();
    }

    static class Usf {
        int[] parent;
        int[] index;
        int[] pnums;
        int n;

        void init(int n) {
            parent = new int[n];
            index = new int[n];
            this.n = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int a, int b) {
            int fa = find(a);
            int fb = find(b);
            if (index[fa] == index[fb]) {
                parent[fa] = fb;
                index[fb]++;
            } else if (index[fa] > index[fb]) {
                parent[fb] = fa;
            } else {
                parent[fa] = fb;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
                return parent[x];
            }
            return x;
        }

        void caculatePnums() {
            pnums = new int[n];
            for (int i = 0; i < n; i++) {
                pnums[find(i)]++;
            }
        }

        int maxUsfNum() {
            caculatePnums();
            int max = Integer.MIN_VALUE;
            for (int num : pnums) {
                max = Math.max(max, num);
            }
            return max;
        }
    }
}
