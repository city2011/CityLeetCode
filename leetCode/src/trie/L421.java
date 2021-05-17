package trie;

import java.util.Arrays;

public class L421 {
    // static 成员整个类独一份，只有在类首次加载时才会创建，因此只会被 new 一次
    static int N = (int) 1e6;
    static int[][] trie = new int[N][2];
    static int idx = 0;

    // 每跑一个数据，会被实例化一次，每次实例化的时候被调用，做清理工作
    public L421() {
        for (int i = 0; i <= idx; i++) {
            Arrays.fill(trie[i], 0);
        }
        idx = 0;
    }

    void add(int x) {
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (trie[p][u] == 0) trie[p][u] = ++idx;
            p = trie[p][u];
        }
    }

    int getVal(int x) {
        int ans = 0;
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            int a = (x >> i) & 1, b = 1 - a;
            if (trie[p][b] != 0) {
                ans |= (b << i);
                p = trie[p][b];
            } else {
                ans |= (a << i);
                p = trie[p][a];
            }
        }
        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            add(i);
            int j = getVal(i);
            ans = Math.max(ans, i ^ j);
        }
        return ans;
    }
}
