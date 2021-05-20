package array.xor;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class L1738_I_think_is_dp {
    public static void main(String[] args) {
        L1738_I_think_is_dp m = new L1738_I_think_is_dp();
        int ans = m.kthLargestValue(new int [][] {{5,2},{1,6}}, 4);
        System.out.println(ans);
    }

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int [][] dp = new int[m][n];
        PriorityQueue<Integer> p = new PriorityQueue<>();

        dp[0][0] = matrix[0][0];
        p.offer(dp[0][0]);
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] ^ matrix[0][i];
            if(p.size() < k) {
                p.offer(dp[0][i]);
            } else {
                if(p.peek() < dp[0][i]) {
                    p.poll();
                    p.add(dp[0][i]);
                }
            }
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] ^ matrix[i][0];
            if(p.size() < k) {
                p.offer(dp[i][0]);
            } else {
                if(p.peek() < dp[i][0]) {
                    p.poll();
                    p.add(dp[i][0]);
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j - 1] ^ dp[i][j - 1] ^ dp[i - 1][j] ^ matrix[i][j];
                if(p.size() < k) {
                    p.offer(dp[i][j]);
                } else {
                    if(p.peek() < dp[i][j]) {
                        p.poll();
                        p.add(dp[i][j]);
                    }
                }
            }
        }

        return p.peek();
    }

    public int kthLargestValueQuick(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                results.add(pre[i][j]);
            }
        }

        nthElement(results, 0, k - 1, results.size() - 1);
        return results.get(k - 1);
    }

    // 读源码，读思想。
    // 有点像快排？？
    public void nthElement(List<Integer> results, int left, int kth, int right) {
        if (left == right) {
            return;
        }
        int pivot = (int) (left + Math.random() * (right - left + 1));
        swap(results, pivot, right);
        // 三路划分（three-way partition）
        int sepl = left - 1, sepr = left - 1;
        for (int i = left; i <= right; i++) {
            if (results.get(i) > results.get(right)) {
                swap(results, ++sepr, i);
                swap(results, ++sepl, sepr);
            } else if (results.get(i) == results.get(right)) {
                swap(results, ++sepr, i);
            }
        }
        if (sepl < left + kth && left + kth <= sepr) {
            return;
        } else if (left + kth <= sepl) {
            nthElement(results, left, kth, sepl);
        } else {
            nthElement(results, sepr + 1, kth - (sepr - left + 1), right);
        }
    }

    public void swap(List<Integer> results, int index1, int index2) {
        int temp = results.get(index1);
        results.set(index1, results.get(index2));
        results.set(index2, temp);
    }
}
