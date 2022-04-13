package context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class C5268 {
    class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            List<List<Integer>> res = new ArrayList<>();
            HashSet<Integer> a1 = new HashSet<>();
            HashSet<Integer> a2 = new HashSet<>();
            Arrays.stream(nums1).forEach(a1::add);
            Arrays.stream(nums2).forEach(a2::add);

            List<Integer> diff1 = new ArrayList<>();
            List<Integer> diff2 = new ArrayList<>();
            for (int j : nums1) {
                if (!a2.contains(j)) {
                    diff1.add(j);
                    a2.add(j);
                }
            }
            res.add(diff1);
            for (int j : nums2) {
                if (!a1.contains(j)) {
                    diff2.add(j);
                    a1.add(j);
                }
            }
            res.add(diff2);
            return res;
        }
    }
}
