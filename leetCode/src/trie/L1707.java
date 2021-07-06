package trie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class L1707 {
    public static void main(String[] args) {
        L1707 m = new L1707();
        int [] ans = m.maximizeXor(new int [] {}, new int [][] {});
        System.out.println(Arrays.toString(ans));
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie t = new Trie();
        Map<int[], Integer> mem = new HashMap<>();
        int m = queries.length;
        for (int i = 0; i < m; i++) {
            mem.put(queries[i], i);
        }
        int[] ans = new int[m];

        Arrays.sort(nums);
        Arrays.sort(queries, Comparator.comparingInt(x -> x[1]));

        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < m; i++) {
            while (idx < n && nums[idx] <= queries[i][1]) {
                t.insert(nums[idx++]);
            }
            if (idx == 0)
                ans[mem.get(queries[i])] = -1;
            else
                ans[mem.get(queries[i])] = t.getMaxXor(queries[i][0]);
        }
        return ans;
    }

    static class Trie {
        static int N = (int) 1e5 * 32 * 2;
        static int[][] trie = new int[N][2];
        static int idx = 0;

        Trie() {
            Trie.idx = 0;
            for (int [] each : trie) {
                Arrays.fill(each, 0);
            }
        }

        void insert(int x) {
            int p = 0;
            for (int i = 31; i >= 0; i--) {
                int u = (x >> i) & 1;
                if (trie[p][u] == 0) trie[p][u] = ++idx;
                p = trie[p][u];
            }
        }

        int getMaxXor(int x) {
            int p = 0;
            int ans = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (x >> i) & 1;
                int r_bit = 1 - bit;
                if (trie[p][r_bit] != 0) {
                    ans |= (r_bit << i);
                    p = trie[p][r_bit];
                } else {
                    ans |= (bit << i);
                    p = trie[p][bit];
                }
            }
            return ans ^ x;
        }
    }
}
