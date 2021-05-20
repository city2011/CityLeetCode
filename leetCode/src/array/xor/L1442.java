package array.xor;

import java.util.HashMap;
import java.util.Map;

public class L1442 {
    public static void main(String[] args) {

    }

    /**
     * 对于右端点每个k来说。每个左端点i, 贡献的异或对的加和是
     * k - i1 + k - i2 + k + i3 ... + k - im
     * =
     * m * k  -  (i1 + i2 + i3 + ... + im)
     *
     * @param arr
     * @return
     */
    public int countTriplets(int[] arr) {

        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> total = new HashMap<>();

        int ans = 0, s = 0;
        for (int k = 0; k < arr.length; k++) {
            int val = arr[k];
            // 如果 s ^ val 也就是包含k的前缀和，在前面出现过了。
            // 做这个判断的时候，统计数据包含到了k - 2。 k - 1在后面才放进去、
            // 这个原因是 如果统计k时， k - 1 已经放入，那么会把 k - (k - 1) 只有1个数据的情况考虑进去。这无法构成“对”。
            if(cnt.containsKey(s ^ val)) {
                ans += cnt.get(s ^ val) * k - total.get(s ^ val);
            }

            // 此时放入的是包含k - 1的前缀和 的统计数据
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
            total.put(s, total.getOrDefault(s, 0) + k);

            // 此时包含k
            s ^= val;
        }
        return ans;
    }
}
